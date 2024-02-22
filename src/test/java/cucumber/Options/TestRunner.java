package cucumber.Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",plugin="json:target/jsonsReports/cucumber-repot.json", glue= {"stepDefinations"}, tags="@Addplace" ) 
public class TestRunner {
	// tags= {"@Addplace"}, "DeletePlace"}
}
