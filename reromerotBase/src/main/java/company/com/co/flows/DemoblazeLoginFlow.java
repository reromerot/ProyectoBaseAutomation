package company.com.co.flows;

import company.com.co.tasks.OpenLoginModal;
import net.serenitybdd.screenplay.Actor;

public class DemoblazeLoginFlow implements LoginFlow {

    @Override
    public void prepare(Actor actor) {
        actor.attemptsTo(OpenLoginModal.now());
    }
}
