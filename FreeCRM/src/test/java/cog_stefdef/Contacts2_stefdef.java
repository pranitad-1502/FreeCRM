package cog_stefdef;

import cog_pages.Contacts2_pages;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Contacts2_stefdef {

	Contacts2_pages c2=new Contacts2_pages();
	
	@Given("^User is on New Contact page$")
	public void user_is_on_new_contact_page1() throws Throwable 
	{
		 //c2.openurl();
	     //c2.login();
	     //c2.LeftBar();
	     c2.click_new_contact();
	     c2.validate_new_contactspage();
	        
	 }

	 @When("^user enters (.+) and (.+)$")
	    public void user_enters_and(String firstname, String lastname) throws Throwable
	 {
	     c2.firstlast(firstname, lastname);
	 }
	 
	 @Then("^(.+) and (.+) should get saved$")
	    public void and_should_get_saved(String firstname, String lastname) throws Throwable
	 {
	     c2.validate_save();
	 }

    @When("^click on save with blank first and last name$")
    public void click_on_save_with_blank_first_and_last_name() throws Throwable 
    {    
         c2.blank_first_last();
    }

    @Then("^error message should be displayed$")
    public void error_message_should_be_displayed() throws Throwable 
    {
        c2.errormsg();
    }
    
    
    @When("^clicking on text box initially$")
    public void clicking_on_text_box_initially() throws Throwable 
    {
       c2.company_textbox();
    }

    @Then("^no search found message should display$")
    public void no_search_found_message_should_display() throws Throwable 
    {
        c2.msg_for_emptycompany();
    }

    @When("^user click on public or private button$")
    public void user_click_on_public_or_private_button() throws Throwable 
    {
        c2.public_private_button();
    }

    @Then("^respective state of account should get change$")
    public void respective_state_of_account_should_get_change() throws Throwable
    {
        c2.chk_button_state();
    }

    
    @When("^user click on down arrow$")
    public void user_click_on_down_arrow() throws Throwable 
    {
    	c2.category_dropdown();
    }

    @Then("^user should able to select any value from list$")
    public void user_should_able_to_select_any_value_from_list() throws Throwable 
    {
        c2.display_category();
    }
    
    
    @Given("^the Do not Call Do not Email Do not Text should be Off bydefault$")
    public void the_do_not_call_do_not_email_do_not_text_should_be_off_bydefault() throws Throwable 
    {
    	c2.all_tog_button();
        
    }

    @When("^user click on the toggle button$")
    public void user_click_on_the_toggle_button() throws Throwable
    {
        c2.chk_all_tog_button_state();
    }

    @Then("^On value should get saved$")
    public void on_value_should_get_saved() throws Throwable {
        
    }
    
    @When("^user click on browse button$")
    public void user_click_on_browse_button() throws Throwable 
    {
        c2.imageplaceholder();
    }

    @Then("^file should get uploaded$")
    public void file_should_get_uploaded() throws Throwable 
    {
        c2.uploadimage();
    }

}
