package TRunnerPkg;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="/Users/shirishaprathi/eclipse-workspace/TestingProj/src/test/resources/Features",glue={"Stepdefinitions"},
//monochrome=true
plugin = {"pretty","html:target/cucumber-reports/report.html"}
)

public class TRunner_Test {
	

}