package com.bbva.japow.steps;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.cucumber.java8.En;

import static org.junit.Assert.*;


public class Stepdefs implements En {

    private String targetJar;
    private String sCommands;
    private String options;
    private String params;
    private Map<String, String> envVars = new HashMap<>();

    private String stdErr;
    private String stdOut;
    private Integer statusCode;

    private static String readToString(InputStream input) {
        StringBuilder sb = new StringBuilder();
        Reader r = new BufferedReader(new InputStreamReader(input, Charset.forName(StandardCharsets.UTF_8.name())));

        try {
            int c = 0;
            while ((c = r.read()) != -1)
                sb.append((char) c);
        } catch (IOException ioe) {
            throw new AssertionError("Error reading from process output", ioe);
        } finally {
            try { r.close(); } catch (IOException e) {};
        }

        return sb.toString();
    }

    public Stepdefs() {

        Before(() -> {
            if (this.targetJar == null)
                this.targetJar = System.getProperty("targetJar");
            this.sCommands = "";
            this.options = "";
            this.params = "";
            this.envVars.clear();

            this.stdErr = null;
            this.stdOut = null;
            this.statusCode = 0;
        });

        Given("subcommands are {string}", (String sCommands) -> { this.sCommands = sCommands; });

        Given("options are {string}", (String options) -> { this.options = options; });

        Given("parameters are {string}", (String params) -> { this.params = params; });

        Given("env. variable {string} is set to {string}", (String envVar, String value) -> {
            this.envVars.put(envVar, value);
        });

        When("I run Kapow!", () -> {
            ProcessBuilder pb = new ProcessBuilder();

            if (System.getProperty("os.name").toLowerCase().startsWith("windows"))
                pb.command("cmd.exe", "/c", "java -jar " + this.targetJar + " " + this.sCommands + " " + this.options + " " + this.params);
            else
                pb.command("/bin/bash", "-c", "java -jar " + this.targetJar + " " + this.sCommands + " " + this.options + " " + this.params);

            if (!this.envVars.isEmpty())
                pb.environment().putAll(this.envVars);

            Process p = pb.start();

            assertTrue("japow didn't finish after 2 seconds", p.waitFor(2, TimeUnit.SECONDS));

            this.stdErr = Stepdefs.readToString(p.getErrorStream());
            this.stdOut = Stepdefs.readToString(p.getInputStream());
            this.statusCode = p.exitValue();
        });

        Then("I get an error code of {int}", (Integer expected) -> {
            assertEquals("Error code mismatch.", expected, this.statusCode);
        });

        Then("I see in StdErr the following message", (String expected) -> {
//            System.out.println("expected: " + expected + "*\nstdErr: " + this.stdErr + "*");
            assertEquals("StdErr mismatch.", expected, this.stdErr);
        });

        Then("I see in StdOut the following message", (String expected) -> {
//            System.out.println("expected: " + expected + "*\nstdOut: " + this.stdOut + "*");
            assertEquals("StdOut mismatch.", expected, this.stdOut);
        });

    }
}
