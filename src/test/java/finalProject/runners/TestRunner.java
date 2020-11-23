package finalProject.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "@Test",
        features = "src/test/resources",
        glue = "finalProject/steps"
)
public class TestRunner {
}