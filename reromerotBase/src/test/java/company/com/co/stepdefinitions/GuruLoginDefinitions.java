package company.com.co.stepdefinitions;

import company.com.co.models.Credentials;
import company.com.co.questions.WelcomeMessageQuestion;
import company.com.co.tasks.Login;
import company.com.co.utils.UrlResolver;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;
import org.openqa.selenium.WebDriver;

public class GuruLoginDefinitions {

    private WebDriver driver;
    private Actor user;

    @Before
    public void setUp() {
        driver = Serenity.getDriver();
        user = Actor.named("User");
        user.can(BrowseTheWeb.with(driver));}

    // 🌐 Navegación
    @Given("I navigate to the {string} login page")
    public void iNavigateToTheLoginPageWithAlias(String pageAlias) {
        String loginUrl = UrlResolver.getUrlFor(pageAlias);
        System.out.println("\u001B[32m🔍 Navigating to:\u001B[0m" + loginUrl);
        user.attemptsTo(Open.url(loginUrl));
    }

    // 🔐 Login
    @When("I enter username {string} and password {string}")
    public void iEnterUsernameAndPassword(String username, String password) {
        user.attemptsTo(Login.withCredentials(new Credentials(username, password)));
    }

    @And("I submit the login form")
    public void iSubmitTheLoginForm() {
        // Submit is handled inside the Login task
    }

    // ✅ Validación de login exitoso
    @Then("I should see the welcome {string} {string}")
    public void iShouldSeeTheWelcomeMessage(String expectedTitle, String expectedManagerId) {
        String actualTitle = WelcomeMessageQuestion.title().answeredBy(user);
        String actualManagerId = WelcomeMessageQuestion.managerId().answeredBy(user);

        System.out.println("\u001B[32m✅ Validando login exitoso:\u001B[0m");
        System.out.println("\u001B[32m📝 Título recibido:\u001B[0m" + actualTitle);
        System.out.println("\u001B[32m🆔 ID del Manager recibido:\u001B[0m" + actualManagerId);

        user.attemptsTo(
                Ensure.that(actualTitle).isEqualTo(expectedTitle),
                Ensure.that(actualManagerId).isEqualTo(expectedManagerId)
        );
    }


    // ❌ Validación de login fallido
    @Then("I should see the error message {string}")
    public void iShouldSeeTheErrorMessage(String expectedError) {
        user.attemptsTo(
                Ensure.that(WelcomeMessageQuestion.errorMessage()).contains(expectedError)
        );
    }
}
