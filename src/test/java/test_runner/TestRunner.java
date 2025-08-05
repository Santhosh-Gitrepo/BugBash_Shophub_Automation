package test_runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features", // path to feature files
    glue = "test_steps",                      // path to step definitions
    plugin = {"pretty", "summary", "html:target/cucumber-reports.html"},
    monochrome = true,
    publish = true
)
public class TestRunner
{

}