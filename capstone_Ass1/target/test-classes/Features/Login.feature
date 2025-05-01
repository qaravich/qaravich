
Feature: Selenium with Java concepts (Implement BDD Framework)

#@SmokeTest
Scenario: Launch a below URL and verify the title of the Page
    Given Launch the Url
    When Open the URL
    Then verify the title of the Page
 
#@SmokeTest
Scenario: Click on another Link and verify the text the Page using TestNg Assertion
    Given given the  AB Testing link
    When Click on the Link
    Then verify text on the Page    
    
#@SmokeTest
Scenario: Navigate back to Home page and click on dropdown link
    Given Navigate back to Home page
    When  click on dropdown link 
    Then  Select Option1 value form drop down verify that its selected or not
    
#@SmokeTest    
Scenario: Verify the below hyperlinks are presented on the Frames Page    
    Given Navigate backto HomePage 
    When  Click on Frames
    Then Verify the hyperlinks are presented on the Frames Page

