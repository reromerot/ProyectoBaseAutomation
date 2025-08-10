package company.com.co.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

public class SubmitLogin implements Task {

    private final Target submitButton;

    public SubmitLogin(Target submitButton) {
        this.submitButton = submitButton;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(submitButton)
        );
    }

    public static SubmitLogin using(Target submitButton) {
        return instrumented(SubmitLogin.class, submitButton);
    }
}
