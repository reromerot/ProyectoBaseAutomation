package company.com.co.stepdefinitions.demoblaze;

import company.com.co.models.Credentials;
import company.com.co.questions.WelcomeMessageQuestion;
import company.com.co.resolvers.LoginFlowResolver;
import company.com.co.tasks.EnterCredentials;
import company.com.co.tasks.SubmitLogin;
import company.com.co.resolvers.LoginPageResolver;
import company.com.co.resolvers.UrlResolver;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.WebDriver;
import net.serenitybdd.screenplay.questions.Text;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class DemoblazeLoginDefinitions {

    private WebDriver driver;
    private Actor user;

    @Before
    public void setUp() {
        driver = Serenity.getDriver();
        user = Actor.named("User");
        user.can(BrowseTheWeb.with(driver));
    }

    // 🌐 Navegación
    @Given("I navigate to the {string} login page")
    public void iNavigateToTheLoginPageWithAlias(String pageAlias) {
        String loginUrl = UrlResolver.getUrlFor(pageAlias);
        System.out.println("\u001B[34m🌐 Navigating to:\u001B[0m " + loginUrl);
        user.attemptsTo(Open.url(loginUrl));
    }

    // 🔐 Login
    @When("I enter username {string} and password {string} on {string}")
    public void iEnterUsernameAndPasswordOn(String username, String password, String alias) {
        Credentials credentials = new Credentials(username, password);

        LoginFlowResolver.resolve(alias).prepare(user);

        user.attemptsTo(
                EnterCredentials.with(credentials,
                        LoginPageResolver.getUsernameField(alias),
                        LoginPageResolver.getPasswordField(alias))
        );
    }

    @And("I submit the login form on {string}")
    public void iSubmitTheLoginFormOn(String alias) {
        user.attemptsTo(
                SubmitLogin.using(LoginPageResolver.getSubmitButton(alias))
        );
    }

    @Then("I should see the welcome {string} on {string}")
    public void iShouldSeeTheWelcomeMessageOn(String expectedTitle, String alias) {
        user.attemptsTo(
                WaitUntil.the(LoginPageResolver.getWelcomeTitle(alias), isVisible()).forNoMoreThan(10).seconds(),
                Ensure.that(Text.of(LoginPageResolver.getWelcomeTitle(alias))).isEqualTo(expectedTitle)
        );
    }


    // ❌ Validación de login fallido
    @Then("I should see the error message {string} on {string}")
    public void iShouldSeeTheErrorMessageOn(String expectedMessage, String alias) {
        String actualMessage = WelcomeMessageQuestion.errorMessage(alias).answeredBy(user);
        System.out.println("\u001B[31m❌ Error recibido:\u001B[0m " + actualMessage);
        user.attemptsTo(
                Ensure.that(actualMessage).isEqualTo(expectedMessage)
        );
    }
}
