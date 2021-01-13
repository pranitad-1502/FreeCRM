package cog_stefdef;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cog_pages.Login_pages;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Login_stefdef {
	
		// TODO Auto-generated method stub
		Login_pages l= new Login_pages();
		 @Given("^User navigate to the freecrm website$")
		    public void user_navigate_to_the_freecrm_website() throws Throwable {
		     l.open_url();
		    }

		    @When("^freecrm is opened$")
		    public void freecrm_is_opened() throws Throwable {
		      System.out.println("Freecrm is opened");
		    }

		    @Then("^navigates to login webpage$")
		    public void navigates_to_login_webpage() throws Throwable {
		       System.out.println("Login webpage is opened");
		    }

		    @And("^login button is clicked$")
		    public void login_button_is_clicked() throws Throwable {
		    	
		    }

		    @Given("^User navigate to the login page$")
		    public void user_navigate_to_the_login_page() throws Throwable {
		    	 System.out.println(" ");
		    }
		
		    @When("^User gives input$")
		    public void user_gives_input() throws Throwable {
		       l.invalidlogin();
		       l.validate_page();
		       l.cleardata();
		       l.correctemail();
		       l.validate_page();
		       l.cleardata();
		      
		    }

		    @Then("^User should not see the Cogmento CRM homepage$")
		    public void user_should_not_see_the_cogmento_crm_homepage() throws Throwable {
		    	 l.correctpass();
			       l.validate_page();
			       l.cleardata();
		    }
		    @When("^User leaves field blank$")
		    public void user_leaves_field_blank() throws Throwable {
		    	 l.bothno();
			       l.validate_page();
			       l.cleardata();
			       l.onlyemail();
			       l.validate_page();
			       l.cleardata();
		    	l.onlypassword();
		    }

		    @Then("^User should not see the Cogmento CRM homepage and it display Invalid login$")
		    public void user_should_not_see_the_cogmento_crm_homepage_and_it_display_invalid_login() throws Throwable {
		       l.validate_page();
		       l.cleardata();
		    }
		    @When("^User enter correct (.+) and correct (.+)$")
		    public void user_enter_correct_and_correct(String email, String password) throws Throwable {
		    	l.login();
		    }

		    @Then("^User should see the Cogmento CRM homepage$")
		    public void user_should_see_the_cogmento_crm_homepage() throws Throwable {
		    	l.validate_title();
		    	 System.out.println("Cogmento crm");
		    	 Thread.sleep(3000);
		    }
		    }