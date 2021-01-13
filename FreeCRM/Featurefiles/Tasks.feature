#Author: Vaishnavi Kotgire

@taskstag
Feature:  Tasks FreeCRM Cogmento
  @vk1  
  Scenario:  Verify task page is displayed or not
	Given User is on Task Home Page
	When User clicks on tasks present on left side bar
	Then tasks page is displayed
  
  @vk2  
  Scenario: Verify New Option
	Given User is on Tasks page	
	When User clicks on New for Task
	Then Create New Task Page will be displyed
	
	@vk3  
	Scenario: Validate alert message for titlefield
	Given User is on Tasks page
	When User clicks on Save with empty titlefield in Tasks
	Then Alert message should be displayed above Title in Tasks
	
  @vk4   
  Scenario Outline: Create a new Task only with title
	When User Enter valid <title> and click save in Tasks
	Then New Tasks should be displayed on deals home page
	Examples:
	|title|
	|Cogmento FreeCRM Finance|
	
	@vk5  
  Scenario: Cancel the task
  When User wants to cancel the task and clicks on cancel
	Then task home page should be displayed
	
	@vk6   
	Scenario: Validate Toggle Button for Access
	When User perform on toggle button in Tasks
	
	
	
	
	
	
	
	
  
  