package com.dumitruc.exercises.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by dumitruc on 13/12/2014.
 */


@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"@RUNNABLE","~@wip"},
        features = ".",
        glue = "com.dumitruc.training.stepdefs",
        format = {"pretty","json:target/report-cucumber/cucumber.json","html:report/report-cucumber"})
public class CucumberDefaultRunnerTest {
}
