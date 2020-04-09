package com.bbva.japow;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/int/resources/features", plugin = { "pretty", "json:target/failsafe-reports/cucumber-json/cucumber.json"}, glue="",tags = {"!@SKIP"})
public class ITAcceptance {
}
