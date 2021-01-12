package cog_testsuites;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
features= {"FeatureFiles/Deal.feature"}
,glue= {"cog_stefdef"}
,tags= "@dealtag"
)
public class Deal_testrunner extends AbstractTestNGCucumberTests
{}
