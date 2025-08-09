package company.com.co.tasks;


import company.com.co.utils.LoginPage;
import company.com.co.models.Credentials;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.Tasks;


    public class Login implements Task {

        private final Credentials credentials;

        public Login(Credentials credentials) {
            this.credentials = credentials;
        }

        public static Login withCredentials(Credentials credentials) {
            return Tasks.instrumented(Login.class, credentials);
        }

        @Override
        public <T extends Actor> void performAs(T actor) {
            actor.attemptsTo(
                    Enter.theValue(credentials.getUsername()).into(LoginPage.USERNAME_FIELD),
                    Enter.theValue(credentials.getPassword()).into(LoginPage.PASSWORD_FIELD),
                    Click.on(LoginPage.LOGIN_BUTTON)
            );
        }
    }

