package company.com.co.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/demoblaze_login.feature",
        glue = {
                "company.com.co.stepdefinitions.demoblaze",
                "company.com.co.hooks"

        },
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = "pretty"

)

public class DemoblazeLogin {
}

