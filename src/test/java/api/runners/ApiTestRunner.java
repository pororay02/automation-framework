package api.runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/api/features",
        glue = "api.steps",
        plugin = {
                "pretty",
                "html:build/reports/cucumber-api.html",
                "json:build/reports/cucumber-api.json"
        },
        tags = "@api"
)
public class ApiTestRunner {
}
