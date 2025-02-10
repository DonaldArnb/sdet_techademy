package com.techademy.maven.testng.techademy_assignment.definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import actions.HomePageActions;
import actions.ABTestingPageActions;
import actions.HomePageActions;
import actions.DropDownPageActions;
import actions.FramesPageActions;
import utils.BaseClass;
import org.testng.Assert;
 
public class PageDefinitions {
 
    HomePageActions basePage = new HomePageActions();
    HomePageActions objHomePage = new HomePageActions();
    ABTestingPageActions abtest = new ABTestingPageActions();
    DropDownPageActions dropdown = new DropDownPageActions();
    FramesPageActions frames = new FramesPageActions();

    
    @Given("User is on the assigned website page {string}")
    public void loginTest(String url) {
 
        BaseClass.openPage(url);
 
    }
    
    @When("user clicks on AB testing link")
    public void ABTestLink() {
    	basePage.ABTestingLink();
    }
    @When("user clicks on dropdown link")
    public void DropDownLink() {
    	basePage.DropDownLink();
    }
    @When("user clicks on frames link")
    public void Frames() {
    	basePage.FramesLink();
    }
    @Then("Verify the title of the page")
    public void Title(){
    	String expectedTitle = "The Internet";
    	Assert.assertEquals(basePage.getTitle(), expectedTitle);
    	
    
    }
    
    @Then("Verify the presence of {string} in the page")
    public void ABTestPage(String text) {
    	Assert.assertTrue(abtest.PageSource().contains(text));
    	
    }
    
    @Then("user clicks on {string}")
    public void SelectOption(String option) {
    	dropdown.selectOption_1(option);
    }
    
    @Then("validate if {string} is selected")
    public void validateSelection(String option) {
    	Assert.assertEquals(dropdown.selectedOption(), option);;
    }
    
    @Then("validate the following hyperlinks are present {string}, {string}")
    public void validateFrameLinks(String x, String y) {
    	Assert.assertTrue(frames.validateLinks(x));
    	Assert.assertTrue(frames.validateLinks(y));

    }
   
    
    @Then ("Go back to the previous page")
    public void PreviousPage() {
    	BaseClass.getDriver().navigate().back();
    	
    }
// 
//    @Then("User should be able to login successfully and new page open")
//    public void verifyLogin() {
// 
//        // Verify home page
//        Assert.assertTrue(objHomePage.getHomePageText().contains("Dashboard"));
// 
//    }
// 
//    @Then("User should be able to see error message {string}")
//    public void verifyErrorMessage(String expectedErrorMessage) {
// 
//        // Verify error message
//        Assert.assertEquals(objLogin.getErrorMessage(),expectedErrorMessage);
// 
//    }
// 
//    @Then("User should be able to see a message {string} below Username")
//    public void verifyMissingUsernameMessage(String message) {
// 
//        Assert.assertEquals(objLogin.getMissingUsernameText(),message);
//    }
// 
}