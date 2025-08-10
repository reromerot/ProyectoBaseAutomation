package company.com.co.resolvers;

import company.com.co.userinterfaces.DemoblazeLoginPage;
import company.com.co.userinterfaces.GuruLoginPage;
import net.serenitybdd.screenplay.targets.Target;

import java.util.Map;

public class LoginPageResolver {

    private static final Map<String, Target> usernameFields = Map.ofEntries(
            Map.entry("guru", GuruLoginPage.USERNAME_FIELD),
            Map.entry("guru99", GuruLoginPage.USERNAME_FIELD),
            Map.entry("demoblaze", DemoblazeLoginPage.USERNAME_FIELD)
    );

    private static final Map<String, Target> passwordFields = Map.ofEntries(
            Map.entry("guru", GuruLoginPage.PASSWORD_FIELD),
            Map.entry("guru99", GuruLoginPage.PASSWORD_FIELD),
            Map.entry("demoblaze", DemoblazeLoginPage.PASSWORD_FIELD)
    );

    private static final Map<String, Target> submitButtons = Map.ofEntries(
            Map.entry("guru", GuruLoginPage.LOGIN_BUTTON),
            Map.entry("guru99", GuruLoginPage.LOGIN_BUTTON),
            Map.entry("demoblaze", DemoblazeLoginPage.LOGIN_BUTTON)
    );

    private static final Map<String, Target> welcomeTitles = Map.ofEntries(
            Map.entry("guru", GuruLoginPage.WELCOME_TITLE),
            Map.entry("guru99", GuruLoginPage.WELCOME_TITLE),
            Map.entry("demoblaze", DemoblazeLoginPage.WELCOME_TITLE)
    );

    private static final Map<String, Target> managerIdLabels = Map.ofEntries(
            Map.entry("guru", GuruLoginPage.MANAGER_ID_LABEL),
            Map.entry("guru99", GuruLoginPage.MANAGER_ID_LABEL)
            // Si otros sistemas lo soportan, agrégalos aquí
    );

    private static final Map<String, Target> errorMessages = Map.ofEntries(
            Map.entry("guru", GuruLoginPage.ERROR_MESSAGE_LABEL),
            Map.entry("guru99", GuruLoginPage.ERROR_MESSAGE_LABEL),
            Map.entry("demoblaze", DemoblazeLoginPage.ERROR_MESSAGE_LABEL)
    );

    // Métodos públicos
    public static Target getUsernameField(String alias) {
        return resolve(alias, usernameFields, "username field");
    }

    public static Target getPasswordField(String alias) {
        return resolve(alias, passwordFields, "password field");
    }

    public static Target getSubmitButton(String alias) {
        return resolve(alias, submitButtons, "submit button");
    }

    public static Target getWelcomeTitle(String alias) {
        return resolve(alias, welcomeTitles, "welcome title");
    }

    public static Target getManagerIdLabel(String alias) {
        return resolve(alias, managerIdLabels, "manager ID label");
    }

    public static Target getErrorMessageTarget(String alias) {
        return resolve(alias, errorMessages, "error message label");
    }

    // Método genérico para resolver alias
    private static Target resolve(String alias, Map<String, Target> map, String fieldName) {
        Target target = map.get(alias.toLowerCase());
        if (target == null) {
            throw new IllegalArgumentException("❌ No " + fieldName + " defined for alias: " + alias);
        }
        return target;
    }
}
