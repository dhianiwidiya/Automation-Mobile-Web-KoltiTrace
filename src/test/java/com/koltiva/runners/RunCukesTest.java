package com.koltiva.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {
                "com.koltiva.hooks",
                "com.koltiva.stepdef"
        },
        features = {"src/test/resources/features"},
        plugin = {"json:target/cucumber.json"},
        tags = "@TestSuiteID=19059"
)
public class RunCukesTest {

}
