package Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@io.cucumber.junit.CucumberOptions(features = "src/test/java/Features",
tags = "@test", monochrome = true,
plugin= {"pretty","json:target/cucumber-report/cucumber.json"
		,"html:target/cucumber-report/cucumber.html"
			},glue = "StepDefination")


public class WebTestRun {
	
	
	
	
	

}
