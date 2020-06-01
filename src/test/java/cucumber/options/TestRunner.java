package cucumber.options;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",plugin="json:target/json-reports/cucmber-reports.json",glue= {"stepDefinitions"},monochrome=true)
public class TestRunner {

}
