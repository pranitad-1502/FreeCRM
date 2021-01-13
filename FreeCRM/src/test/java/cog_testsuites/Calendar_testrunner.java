package cog_testsuites;

import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
	@CucumberOptions(
			features = {"Featurefiles/Calendar.feature"}
			,glue = {"cog_stefdef"}
			,tags = "@CalendarTag"
			)

public class Calendar_testrunner extends AbstractTestNGCucumberTests
{}
