package com.riaTestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/featuresfolder/RiaLogin.feature",
		glue="com.web",
		tags="@Smoke",
		plugin = { "json:target/reports/cucumber.json", "pretty", "html:target/reports/cucumber-reports"} 
		)
public class RiaLoginTestRunner {

}

