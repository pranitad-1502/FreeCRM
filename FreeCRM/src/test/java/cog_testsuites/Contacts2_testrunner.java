package cog_testsuites;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
	@CucumberOptions(		
			features = {"Featurefiles/Contacts2.feature"}//feature file want to run
			,glue={"cog_stefdef"}				         //package names having the scripts for the feature file		
			,tags="@contact2tag"	                             //the tags to run.... which are in feature file		
)
public class Contacts2_testrunner extends AbstractTestNGCucumberTests{

}
