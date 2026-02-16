package TRunner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;


	
	
	@Suite
	@IncludeEngines("cucumber")
	@SelectClasspathResource("Features")
	@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "Stepdefinitions")
	//monochrome=true

	//features = "src/test/resources/Features", 
	//glue = {"StepDefinitions"},
	//@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty","html:/Users/shirishaprathi/git/DemoProject/TestingProj/target/cucumber-reports/report.html")
	@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-reports/report.html")

	public class TRunner {
		
	}
