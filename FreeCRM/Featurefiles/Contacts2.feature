#Author: Aishwarya Jadhav

@contact2tag
Feature: Create New Contact
 @tag1
 Scenario:
 Given User is on New Contact page
 @aj1
 Scenario Outline: Validate First Name and Last name
         When user enters <firstname> and <lastname>
	       Then <firstname> and <lastname> should get saved
         Examples:
		         | firstname  | lastname |
	           | Aishwarya  | Jadhav   |
             | Aish2      | Jadh2    |

  @aj2
  Scenario: Validate the Invalid First Name and Last name
   When click on save with blank first and last name
	 Then error message should be displayed
	 
  @aj3
  Scenario: Validate the company field
      When clicking on text box initially
      Then no search found message should display
      
  @aj4     
  Scenario: Validate the Public and Private Access
      When user click on public or private button
      Then respective state of account should get change
      
  @aj5
  Scenario: Validate the dropdown for Category field
      When user click on down arrow
      Then user should able to select any value from list
      
  @aj6
  Scenario: Validate Do not Call Do not Email Do not Text On-Off button
      Given the Do not Call Do not Email Do not Text should be Off bydefault
	    When user click on the toggle button
	    Then On value should get saved
	         
  @aj7
  Scenario: Validate image upload
      When user click on browse button
      Then file should get uploaded
      
  
	    
 
