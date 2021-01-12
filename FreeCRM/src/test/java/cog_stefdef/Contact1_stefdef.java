package cog_stefdef;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cog_pages.Contact1_pages;

public class Contact1_stefdef
{
	Contact1_pages c1=new Contact1_pages();
	
	@Given("^User is on Home Page$")
    public void user_is_on_home_page() throws Throwable 
	{
		System.out.println("User open URL and login");
		//c1.openurl();
    }

    @When("^User clicks on Contact button$")
    public void user_clicks_on_contact_button() throws Throwable 
    {	
    	System.out.println("User click on Contact");
    	c1.clickContact();
    	
    }

    @Then("^Contact page is displayed and  verify the title in step$")
    public void contact_page_is_displayed_and_verify_the_title_in_step() throws Throwable 
    {
    	System.out.println("User validate the title");
    	c1.validate_title();
    }
    
   @Given("^User is on Deals page$")
    public void user_is_on_deals_page() throws Throwable 
    {
	   System.out.println("User is on Deal Page");
    }

    @When("^User clicks on New$")
    public void user_clicks_on_new() throws Throwable 
    {
    	System.out.println("User clicks on New to create new contact");
    	c1.click_new();
    }

    @Then("^Create New Page will be displyed$")
    public void create_new_page_will_be_displyed() throws Throwable 
    {
    	System.out.println("User validate New Page");
    	c1.newPage();
    }
    
    @Given("^User enter email id$")
    public void user_enter_email_id() throws Throwable 
    {	
    	System.out.println("User enter Email");
    	c1.input_email();
    }

    @When("^User clicks on the cross sign$")
    public void user_clicks_on_the_cross_sign() throws Throwable 
    {
    	System.out.println("User tick the mark");
    	c1.click_checkmark();
        
    }

    @Then("^Tick sign should be displayed$")
    public void tick_sign_should_be_displayed() throws Throwable 
    {
    	System.out.println("Email validate");
    	c1.validate_email();
    }

    
    @Given("^Placeholder for email and type of email id$")
    public void placeholder_for_email_and_type_of_email_id() throws Throwable 
    {
    	System.out.println("User add one more Email");
    	c1.place_email();   
    }

    @When("^User clicks on plus sign$")
    public void user_clicks_on_plus_sign() throws Throwable 
    {
        c1.toAddmore();
    }
  

    @Then("^Enter More than one mail should be shaved$")
    public void more_than_one_mail_should_be_shaved() throws Throwable 
    {
    	c1.newMail();
    }
    
    @Given("^User is on status field$")
    public void user_is_on_status_field() throws Throwable 
    {
       System.out.println("User click on status field");
    }

    @When("^User select one field$")
    public void user_select_one_field() throws Throwable 
    {
       c1.setStatus();
    }

    @Then("^One field is selected$")
    public void one_field_is_selected() throws Throwable
    {
       System.out.println("User selected one status");
    }
}
