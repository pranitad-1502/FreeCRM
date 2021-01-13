package cog_testsuites;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"Featurefiles/Contact1.feature"} 
		,glue={"cog_stefdef"}				//package names having the scripts for the feature file	
		,tags= "@contact1tag" // the tags to run.... which are in feature file		
		)

public class Contact1_Runner extends AbstractTestNGCucumberTests
{
	
} 