package cog_stefdef;

import cog_pages.Calendar_pages;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Calendar_stepdef 
{
	Calendar_pages cp = new Calendar_pages();
	//tag1
	@Given("^User is on CogmentoHomePage$")
    public void user_is_on_cogmentohomepage() throws Throwable 
	{
		//cp.openurl();
		//cp.login();
		//System.out.println("Logged in");
    }

    @When("^User clicks on Calendar present on side bar$")
    public void user_clicks_on_calendar_present_on_side_bar() throws Throwable 
    {
    	cp.openCal();
    }

    @Then("^Calendar page is displayed$")
    public void calendar_page_is_displayed() throws Throwable 
    {
    	cp.validate_calpage();
    }
	
    //tag2
    @Given("^User is on Calendar page$")
    public void user_is_on_calendar_page() throws Throwable 
    {
    	cp.validate_calpage();
    }

    @When("^User clicks on Agenda$")
    public void user_clicks_on_agenda() throws Throwable 
    {
    	cp.click_agenda();
    }

    @Then("^Agenda for the month will be displayed$")
    public void agenda_for_the_month_will_be_displayed() throws Throwable 
    {
        cp.agenda();
        System.out.println("Agenda page is displayed");
    }
    
    //tag3
    @When("^User clicks on New event$")
    public void user_clicks_on_new_event() throws Throwable 
    {
    	cp.click_new();
    }

    @Then("^Create New Event Page will be displayed$")
    public void create_new_event_page_will_be_displayed() throws Throwable 
    {
       cp.new_eventpage();
    }
    
    //tag4
    @Given("^User is on Create New Event page$")
    public void user_is_on_create_new_event_page() throws Throwable 
    {
    	cp.new_eventpage();
    }

    @When("^Title field is empty and Calendar field is empty$")
    public void title_field_is_empty_and_calendar_field_is_empty() throws Throwable 
    {
    	cp.empty_title_cal();
    }

    @Then("^Alert message should be displayed$")
    public void alert_message_should_be_displayed() throws Throwable 
    {
    	System.out.println("Error Message: ");
    	cp.alerterrormsg();
    }
  
    //tag5
    @When("^User Enter valid (.+) and required details and click save$")
    public void user_enter_valid_and_required_details_and_click_save(String title) throws Throwable 
    {
    	cp.valid_title(title);
    	cp.valid_cal();
    	cp.other_details();
    	System.out.println("Entered Required details");
    	cp.click_save();
    }

    @Then("^New Event suumary should be displayed$")
    public void new_event_suumary_should_be_displayed() throws Throwable 
    {
      	cp.validate_save();
    }

    @And("^New Event should be displayed on Calendar page$")
    public void new_event_should_be_displayed_on_calendar_page() throws Throwable 
    {
    	cp.openCal();
    }
    
    //tag6
    @When("^User Enter valid (.+) valid details and click on save$")
    public void user_enter_valid_valid_details_and_click_on_save(String tle) throws Throwable 
    {
    	cp.click_new();
    	cp.new_event(tle);
        cp.valid_cal();
        cp.other_details();
     	cp.category();
     	System.out.println("Entered other details also");
     	cp.click_save();
    }

    @Then("^New Events suumary should be displayed$")
    public void new_events_suumary_should_be_displayed() throws Throwable 
    {
    	cp.validate_save();
    }

    @And("^New Events should be displayed on Calendar page$")
    public void new_events_should_be_displayed_on_calendar_page() throws Throwable 
    {
    	cp.openCal();
    }
    //tag7
    @When("^User wants to cancel the Event and clicks on cancel$")
    public void user_wants_to_cancel_the_event_and_clicks_on_cancel() throws Throwable 
    {
        cp.click_new();
        System.out.println("Clicked on Cancel");
        Thread.sleep(5000);
        cp.cancel();
    }

    @Then("^Calendar page should be displayed$")
    public void calendar_page_should_be_displayed() throws Throwable 
    {
        cp.validate_calpage();
        Thread.sleep(5000);
    }
 }
