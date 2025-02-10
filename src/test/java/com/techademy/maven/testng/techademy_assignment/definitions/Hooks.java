package com.techademy.maven.testng.techademy_assignment.definitions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import utils.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
 
public class Hooks {
 
    @Before
    public static void setUp() {
 
       BaseClass.setUpDriver();
    }
 
    @After
    public static void tearDown(Scenario scenario) {
 
        //validate if scenario has failed
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) BaseClass.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName()); 
        }   
         
        BaseClass.tearDown();
    }
}