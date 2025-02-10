
package com.techademy.maven.testng.techademy_assignment.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
 
@CucumberOptions(tags = "", features = "src/test/resources/features/CapstoneAssignment.feature", glue = "com.techademy.maven.testng.techademy_assignment.definitions",
        plugin = {})
 
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
}