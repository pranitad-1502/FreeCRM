#Author: your.email1@your.domain.com

@contact1tag
Feature: Contacts FreeCRM Cogmento
	
	@ya1
  Scenario: Verify the title of Contact page
    Given User is on Home Page
    When User clicks on Contact button
    Then Contact page is displayed and  verify the title in step
	
	@ya2
  Scenario: Verify New Option
		Given User is on contact page	
		When User clicks on new
		Then Create New contact Page will be displyed
    
   @ya3
   Scenario: Validate Valid Email
		Given User enter email id
		When User clicks on the cross sign
		Then Tick sign should be displayed
    
   @ya4
   Scenario: Validate the add more than one email
		Given Placeholder for email and type of email id
		When User clicks on plus sign 
		Then Enter More than one mail should be shaved
   
   @ya5
   Scenario: Validate status field
   	Given User is on status field
   	When User select one field
   	Then One field is selected