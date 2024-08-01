package com.ucodeacademy.test_runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)

@CucumberOptions(
        plugin = {"html:target/rerun_report.html", "json:target/json_rerun_report.json"},
        features = "@target/rerun.txt",
        glue = "com/ucodeacademy/step_definitions"
)

public class FailedTestRunner {


}
