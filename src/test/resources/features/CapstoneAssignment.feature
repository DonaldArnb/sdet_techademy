Feature: Login to the given website

  Background:
    Given User is on the assigned website page "https://the-internet.herokuapp.com/"
 
  @Title
  Scenario: Validate title of the page
    Then Verify the title of the page
    
   
  @ABTestingLink
  Scenario: Validate A/B Testing Link works fine
    When user clicks on AB testing link
    Then Verify the presence of "A/B Test Variation 1" in the page
    Then Go back to the previous page
    
  @Dropdown
  Scenario: Validate Dropdown works fine
    When user clicks on dropdown link
    Then user clicks on "Option 1"
    Then validate if "Option 1" is selected
    Then Go back to the previous page
    
    
  @Frames
  Scenario: Validate Frames works fine
    When user clicks on frames link
    Then validate the following hyperlinks are present "Nested Frames", "iFrame"
    
 
 