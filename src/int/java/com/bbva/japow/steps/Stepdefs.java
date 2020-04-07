package com.bbva.japow.steps;

import java.util.HashMap;
import java.util.Map;

import io.cucumber.java8.En;


public class Stepdefs implements En {

    private String sCommands;
    private String options;
    private Map<String, String> envVars = new HashMap<>();

    public Stepdefs() {
        Before(() -> {
            this.sCommands = null;
            this.options = null;
            this.envVars.clear();
        });

        Given("subcommands are {string}", (String sCommands) -> {
            this.sCommands = sCommands;
        });

        Given("options are {string}", (String options) -> {
            this.options = options;
        });

        Given("env. variable {string} is set to {string}", (String envVar, String value) -> {
            this.envVars.put(envVar, value);
        });

        When("I run Kapow!", () -> {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java8.PendingException();
        });

        Then("I get an error code of {int}", (Integer int1) -> {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java8.PendingException();
        });

        Then("I see in StdErr the following message", (String docString) -> {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java8.PendingException();
        });

        Then("I see in StdOut the following message", (String docString) -> {
            // Write code here that turns the phrase above into concrete actions
            throw new io.cucumber.java8.PendingException();
        });

    }
}
