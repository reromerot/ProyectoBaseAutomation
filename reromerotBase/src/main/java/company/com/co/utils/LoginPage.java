package company.com.co.utils;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {

    // 🔐 Login Form Elements
    public static final Target USERNAME_FIELD = Target.the("Username input field")
            .located(By.name("uid"));

    public static final Target PASSWORD_FIELD = Target.the("Password input field")
            .located(By.name("password"));

    public static final Target LOGIN_BUTTON = Target.the("Login button")
            .located(By.name("btnLogin"));

    // ✅ Welcome Message Elements
    public static final Target WELCOME_TITLE = Target.the("Welcome title marquee")
            .located(By.xpath("//marquee[@class='heading3']"));

    public static final Target MANAGER_ID_LABEL = Target.the("Manager ID label")
            .located(By.xpath("//tr[@class='heading3']/td[@style='color: green']"));

    // ❌ Error Message Element (optional, if needed for failed login)
    public static final Target ERROR_MESSAGE = Target.the("Login error message")
            .located(By.cssSelector("body > div > div > h3")); // Adjust this selector based on actual HTML
}
