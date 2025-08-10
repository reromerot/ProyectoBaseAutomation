package company.com.co.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class GuruLoginPage extends PageObject {

    // 🔐 Login Form
    public static final Target USERNAME_FIELD = Target.the("username input field")
            .located(By.name("uid"));

    public static final Target PASSWORD_FIELD = Target.the("password input field")
            .located(By.name("password"));

    public static final Target LOGIN_BUTTON = Target.the("login button")
            .located(By.name("btnLogin"));

    // ✅ Post-login Welcome Section
    public static final Target WELCOME_TITLE = Target.the("welcome title marquee")
            .located(By.xpath("//marquee[@class='heading3']"));

    public static final Target MANAGER_ID_LABEL = Target.the("manager ID label")
            .located(By.xpath("//tr[@class='heading3']/td[@style='color: green']"));

    // ❌ Error Message (if login fails)
        public static final Target ERROR_MESSAGE_LABEL = Target.the("login error message")
                .located(By.cssSelector("label.error")); // Ajusta el selector según tu HTML
    }

