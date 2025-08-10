package company.com.co.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DemoblazeLoginPage extends PageObject {

    public static final Target OPEN_LOGIN_MODAL_BUTTON = Target.the("Click on login modal navbar")
            .located(By.id("login2"));

    // 🔐 Login Form
    public static final Target USERNAME_FIELD = Target.the("username input field")
            .located(By.id("loginusername"));

    public static final Target PASSWORD_FIELD = Target.the("password input field")
            .located(By.id("loginpassword"));

    public static final Target LOGIN_BUTTON = Target.the("login button")
            .located(By.xpath("/html/body/div[3]/div/div/div[3]/button[2]"));

    // ✅ Post-login Welcome Section
    public static final Target WELCOME_TITLE = Target.the("welcome title marquee")
            .located(By.id("nameofuser"));

    public static final Target MANAGER_ID_LABEL = Target.the("manager ID label")
            .located(By.xpath("//tr[@class='heading3']/td[@style='color: green']"));

    // ❌ Error Message (if login fails)
        public static final Target ERROR_MESSAGE_LABEL = Target.the("login error alert")
                .located(By.id("login-error")); // Ajusta el selector según tu HTML
    }

