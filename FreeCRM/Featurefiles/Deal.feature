#Author: your.email@your.domain.com

@dealtag
Feature: Deals FreeCRM Cogmento

@pd1
Scenario: Verify Deals page is displayed or not
	Given User is on Cogmento Home Page
	When User clicks on Deals present on left side bar
	Then Deals page is displayed

@pd2
Scenario: Verify New Option
	Given User is on Deals page	
	When User clicks on New
	Then Create New Page will be displyed

@pd3
Scenario: Validate alert message for titlefield
	Given User is on Deals page
	When User clicks on Save with empty titlefield
	Then Alert message should be displayed above Title

@pd4
Scenario Outline: Create a new deal only with title
	When User Enter valid <title> and click save
	Then New Deal should be displayed on deals home page with title 
	
	Examples:	
		|title|
		|Cogmento FreeCRM Finance|
		|Finance|
		
@pd5
Scenario: Cancel the deal

	When User wants to cancel the deal and clicks on cancel
	Then Deals home page should be displayed

@pd6
Scenario: Delete the deal
	When User clicks on dustbin icon and clicks on delete
	Then The record should be deleted

@pd7
Scenario: Validate Toggle Button for Closed fielde
	When User clicks on toggle button
	Then Toggle button should change the state

@pd8
Scenario: Validate drop down for Type field
	When User clicks on down arrow 
	Then Select New Old Opportunity Priority from dropdown
      