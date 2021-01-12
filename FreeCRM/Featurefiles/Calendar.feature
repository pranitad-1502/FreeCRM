#Author: Ashwini Jadhav
@CalendarTag
Feature: To verify Calendar page of FreeCRM Cogmento

  @tag1
	Scenario: Verify Calendar page is displayed or not
	Given User is on Cogmento Home Page
	When User clicks on Calendar present on side bar
	Then Calendar page is displayed
	
	@tag2
	Scenario: Verify Agenda Option
	Given User is on Calendar page	
	When User clicks on Agenda
	Then Agenda for the month will be displayed

	@tag3
	Scenario: Verify New Option
	When User clicks on New
	Then Create New Event Page will be displayed

	@tag4
	Scenario: Validate alert message for title and calendar field
	Given User is on Create New Event page
	When Title field is empty and Calendar field is empty
	Then Alert message should be displayed
 
	@tag5
	Scenario Outline: Create a new Event only with required fields
	When User Enter valid <title> and required details and click save
	Then New Event suumary should be displayed
	And New Event should be displayed on Calendar page
	
	Examples:
	|title | 
	|task	 |

	@tag6
	Scenario Outline: Create a new Event
	When User Enter valid <tle> valid details and click on save
	Then New Events suumary should be displayed
	And New Events should be displayed on Calendar page
	
	Examples:
	|tle 		|
	|event2 | 
	
	@tag7
	Scenario: Cancel the Event
	When User wants to cancel the Event and clicks on cancel
	Then Calendar page should be displayed





	

   