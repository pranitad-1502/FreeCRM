package cog_stefdef;

import cog_pages.Tasks_pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Tasks_stefdef
{
	Tasks_pages tp=new Tasks_pages();
	@Given("^User is on Task Home Page$")
    public void user_is_on_task_home_page() throws Throwable
	{
       // tp.login();  
    }

    @When("^User clicks on tasks present on left side bar$")
    public void user_clicks_on_tasks_present_on_left_side_bar() throws Throwable 
    {
        tp.LeftBar();  
    }

    @Then("^tasks page is displayed$")
    public void tasks_page_is_displayed() throws Throwable 
    {
        tp.validate_taskspage();   
    }
    
    @Given("^User is on Tasks page$")
    public void user_is_on_tasks_page() throws Throwable 
    {
        tp.validate_taskspage();
    }

    @When("^User clicks on New for Task$")
    public void user_clicks_on_new_for_task() throws Throwable 
    {
        tp.click_new();
    }

    @Then("^Create New Task Page will be displyed$")
    public void create_new_task_page_will_be_displyed() throws Throwable
    {
         tp.new_taskspage();
    }
    
    @When("^User clicks on Save with empty titlefield$")
    public void user_clicks_on_save_with_empty_titlefield() throws Throwable
    {
        tp.title_empty_and_save();
    }

    @Then("^Alert message should be displayed above Title$")
    public void alert_message_should_be_displayed_above_title() throws Throwable
    {
        tp.alerterrormsg();
    }
    
    @When("^User Enter valid (.+) and click save$")
    public void user_enter_valid_and_click_save(String title) throws Throwable 
    {
        tp.valid_title(title);
    }

    @Then("^New Tasks should be displayed on deals home page$")
    public void new_tasks_should_be_displayed_on_deals_home_page() throws Throwable
    {
        tp.new_task_visible();
    }
    
    @When("^User wants to cancel the task and clicks on cancel$")
    public void user_wants_to_cancel_the_task_and_clicks_on_cancel() throws Throwable
    {
        tp.click_new();
        tp.cancel();
    }

    @Then("^task home page should be displayed$")
    public void task_home_page_should_be_displayed() throws Throwable
    {
        tp.validate_taskspage();
    }
    
       
    @When("^User clicks on toggle button$")
    public void user_clicks_on_toggle_button() throws Throwable 
    {
        tp.click_new();
        System.out.println("clicked on new"); 
        tp.setAccess();
    }

    @Then("^Toggle button should change the state$")
    public void toggle_button_should_change_the_state() throws Throwable
    {
    	System.out.println("Toggle Button is On");
    }
 }

    
   



    
    

    
		
	
	
	




