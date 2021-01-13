package cog_stefdef;

import cog_pages.Deal_pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Deal_stefdef 
{

	Deal_pages dp=new Deal_pages();
	
	@Given("^User is on Cogmento Home Page$")
    public void user_is_on_cogmento_home_page() throws Throwable 
	{
      // dp.openurl();
    }

    @When("^User clicks on Deals present on left side bar$")
    public void user_clicks_on_deals_present_on_left_side_bar() throws Throwable 
    {
    	dp.LeftBar();
    }

    @Then("^Deals page is displayed$")
    public void deals_page_is_displayed() throws Throwable 
    {
    	dp.validate_dealspage();
    }
    
    
    @Given("^User is on Deals page$")
    public void user_is_on_deals_page() throws Throwable 
    {
    	dp.validate_dealspage();
    }

    @When("^User clicks on New$")
    public void user_clicks_on_new() throws Throwable 
    {
    	dp.click_new();
    }

    @Then("^Create New Page will be displyed$")
    public void create_new_page_will_be_displyed() throws Throwable 
    {
    	dp.new_dealspage();
    }
    
    @When("^User clicks on Save with empty titlefield$")
    public void user_clicks_on_save_with_empty_titlefield() throws Throwable 
    {
        dp.title_empty_and_save();
    }

    @Then("^Alert message should be displayed above Title$")
    public void alert_message_should_be_displayed_above_title() throws Throwable 
    {
    	dp.alerterrormsg();
    }

    @When("^User Enter valid (.+) and click save$")
    public void user_enter_valid_and_click_save(String title) throws Throwable 
    {	
    	dp.valid_title(title);
    }

    @Then("^New Deal should be displayed on deals home page with title$")
    public void new_deal_should_be_displayed_on_deals_home_page_with_title() throws Throwable 
    {
    	dp.new_deal_visible();
    }

    @When("^User wants to cancel the deal and clicks on cancel$")
    public void user_wants_to_cancel_the_deal_and_clicks_on_cancel() throws Throwable 
    {
        dp.click_new();
        dp.cancel();
    }

    @Then("^Deals home page should be displayed$")
    public void deals_home_page_should_be_displayed() throws Throwable 
    {
        dp.validate_dealspage();
    }

    @When("^User clicks on dustbin icon and clicks on delete$")
    public void user_clicks_on_dustbin_icon_and_clicks_on_delete() throws Throwable 
    {
        dp.click_trashicon();
    }

    @Then("^The record should be deleted$")
    public void the_record_should_be_deleted() throws Throwable 
    {
       System.out.println("The Deal is deleted");
    }
    

    @When("^User clicks on toggle button$")
    public void user_clicks_on_toggle_button() throws Throwable 
    {
    	dp.click_new();
    	System.out.println("clicked on new");
        dp.toggle_button();
    }

    @Then("^Toggle button should change the state$")
    public void toggle_button_should_change_the_state() throws Throwable 
    {
     System.out.println("Toggle Button is On");
    }
    
    @When("^User clicks on down arrow$")
    public void user_clicks_on_down_arrow() throws Throwable 
    {
       dp.downarrow();
    }

    @Then("^Select New Old Opportunity Priority from dropdown$")
    public void select_new_old_opportunity_priority_from_dropdown() throws Throwable 
    {
        dp.setStatus();
    }

}
