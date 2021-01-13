
package cog_testsuites;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"Featurefiles/Login.feature"}
		,glue= {"cog_stefdef"}
		,tags= "@tag"
		)
public class Login_testrunner extends AbstractTestNGCucumberTests{}
