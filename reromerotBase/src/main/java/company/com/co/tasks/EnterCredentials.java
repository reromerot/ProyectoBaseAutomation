package company.com.co.tasks;

import company.com.co.models.Credentials;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

public class EnterCredentials implements Task {

    private final Credentials credentials;
    private final Target usernameField;
    private final Target passwordField;

    public EnterCredentials(Credentials credentials, Target usernameField, Target passwordField) {
        this.credentials = credentials;
        this.usernameField = usernameField;
        this.passwordField = passwordField;
    }

    public static EnterCredentials with(Credentials credentials, Target usernameField, Target passwordField) {
        return Tasks.instrumented(EnterCredentials.class, credentials, usernameField, passwordField);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(credentials.getUsername()).into(usernameField),
                Enter.theValue(credentials.getPassword()).into(passwordField)
        );
    }

    @Override
    public String toString() {
        return String.format("🔐 Entering credentials for user [%s] with password masked", credentials.getUsername());
    }
}
