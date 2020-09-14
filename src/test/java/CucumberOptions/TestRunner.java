package CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/features", glue = "stepDefinitions")
//@RunWith(Cucumber.class)
public class TestRunner extends AbstractTestNGCucumberTests {

}