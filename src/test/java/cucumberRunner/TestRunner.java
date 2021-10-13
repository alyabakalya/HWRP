package cucumberRunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty", "com.epam.reportportal.cucumber.StepReporter"},
		monochrome = true,
		tags = "@Test",
		glue = "cucumberStepDefinitions",
		features = "src/test/resources/CucumberFeatures"
)

public class TestRunner {
}


