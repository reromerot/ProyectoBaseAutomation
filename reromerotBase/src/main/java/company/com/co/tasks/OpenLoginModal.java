package company.com.co.tasks;

import company.com.co.userinterfaces.DemoblazeLoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class OpenLoginModal implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(DemoblazeLoginPage.OPEN_LOGIN_MODAL_BUTTON),
                WaitUntil.the(DemoblazeLoginPage.USERNAME_FIELD, isVisible()).forNoMoreThan(5).seconds()
        );
    }

    public static OpenLoginModal now() {
        return new OpenLoginModal();
    }
}
