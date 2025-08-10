package company.com.co.questions;

import company.com.co.resolvers.LoginPageResolver;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class WelcomeMessageQuestion {

    public static Question<String> title(String alias) {
        return actor -> {
            Target welcomeTarget = LoginPageResolver.getWelcomeTitle(alias);
            welcomeTarget.resolveFor(actor).waitUntilVisible();
            return Text.of(welcomeTarget).answeredBy(actor);
        };
    }


    public static Question<String> managerId(String alias) {
        return Text.of(LoginPageResolver.getManagerIdLabel(alias))
                .describedAs("the manager ID for " + alias);
    }

    public static Question<String> errorMessage(String alias) {
        return actor -> {
            WebDriver driver = Serenity.getDriver();

            // 1. Intentar capturar alerta
            try {
                Alert alert = driver.switchTo().alert();
                String alertText = alert.getText();
                alert.accept(); // opcional
                return alertText;
            } catch (NoAlertPresentException e) {
                // 2. Si no hay alerta, buscar Target definido por alias
                Target errorTarget = LoginPageResolver.getErrorMessageTarget(alias);

                if (errorTarget.resolveFor(actor).isVisible()) {
                    return Text.of(errorTarget).answeredBy(actor);
                } else {
                    return "No error message found";
                }
            }
        };
    }


    public static Question<Boolean> isWelcomeVisible(String alias) {
        return actor -> LoginPageResolver.getWelcomeTitle(alias)
                .resolveFor(actor)
                .isVisible();
    }
}
