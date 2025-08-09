package company.com.co.runners;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/guru_login.feature",
        glue = {
                "company.com.co.stepdefinitions",
                "company.com.co.hooks"

        },
        snippets = CucumberOptions.SnippetType.CAMELCASE
)

public class GuruLogin {
}

