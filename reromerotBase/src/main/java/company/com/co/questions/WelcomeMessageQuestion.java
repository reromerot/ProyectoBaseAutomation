package company.com.co.questions;

import company.com.co.utils.LoginPage;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class WelcomeMessageQuestion {

    public static Question<String> title() {
        return Text.of(LoginPage.WELCOME_TITLE).describedAs("the welcome title");
    }

    public static Question<String> managerId() {
        return Text.of(LoginPage.MANAGER_ID_LABEL).describedAs("the manager ID");
    }

    // ✅ Corregido: captura el texto del Alert emergente
    public static Question<String> errorMessage() {
        return new Question<>() {
            @Override
            public String answeredBy(Actor actor) {
                WebDriver driver = Serenity.getDriver();
                try {
                    Alert alert = driver.switchTo().alert();
                    String alertText = alert.getText();
                    alert.accept(); // opcional: cierra el alert
                    return alertText;
                } catch (NoAlertPresentException e) {
                    return "No alert present";
                }
            }

            @Override
            public String toString() {
                return "the login error alert message";
            }
        };
    }
}
