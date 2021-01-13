/* Author: Yogita Arora
 * Date: 09-Jan-2021
 * Description: below code to
 * 					open the url
 * 					login with valid input
 * 					validate contact and new page
 * 					validate email and 
 * 					validate drop-down field on new contact page
 */

package cog_pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import cog_base.TestBase_Cogmento;

public class Contact1_pages extends TestBase_Cogmento
{	
	static @FindBy(xpath="//span[text()='Log In']") WebElement login;			//page factory elements
	static @FindBy(name="email") WebElement email;
	static @FindBy(name="password") WebElement pass;
	static @FindBy(xpath="//div[text()='Login']") WebElement login1;
	static @FindBy(xpath="//span[text()='Contacts']") WebElement contact;
	static @FindBy(xpath="//*[@id='dashboard-toolbar']/div[2]/div/a") WebElement newbutton;
	static @FindBy(xpath="//*[@id=\"main-content\"]/div/div[2]/form/div[4]/div[1]/div/div/div/div[1]/div/input") WebElement emailbox;
	static @FindBy(xpath="//*[@id=\"main-content\"]/div/div[2]/form/div[4]/div[1]/div/div/div/div[1]/div/input") WebElement checkmark;
	static @FindBy(xpath="//*[@id=\"main-content\"]/div/div[2]/form/div[4]/div[1]/div/div/div/div[1]/div/div/i") WebElement tickbox;
	static @FindBy(xpath="//*[@id=\"main-content\"]/div/div[2]/form/div[4]/div[1]/div/div/div/div[2]/div/input") WebElement eType;
	static @FindBy(xpath="//div[@name='status']") WebElement statusbox;
	
	public void clickContact() throws Exception  //click on contact
	{	
		PageFactory.initElements(driver,this);
		Thread.sleep(1000);
		contact.click();
		Thread.sleep(3000);
		takescreenshot("HomePage.png");
	}
	
	public void validate_title() //validate title
	{
		String title=driver.getTitle();
		if(title.contains("Cogmento CRM"))
		{
			System.out.println("Results as expected");
			testlog=ext.createTest("Validate Title");
			testlog.log(Status.PASS,"Title is same as expected");
			takescreenshot("ContactPage.png");
		}
		else
		{
			System.out.println("Results not correct");
			testlog=ext.createTest("Validate Title");
			testlog.log(Status.FAIL,"Title is same as expected");
			takescreenshot("ContactPage.png");
		}
	}
	
	public void clickNew() //click on new
	{
		newbutton.click();
	}
	
	public void newPage() //validate create new contact page is displayed
	{
		String URL = driver.getCurrentUrl();
		if(URL.contains("https://ui.freecrm.com/contacts/new"))			//to validate new page url
		{
			System.out.println("Results as expected");
			testlog=ext.createTest("New Page URL validate");
			testlog.log(Status.PASS,"Title is same as expected");
			takescreenshot("NewPage.png");
		}
		else
		{
			System.out.println("Results are not correct");
			testlog=ext.createTest("New Page URL validate");
			testlog.log(Status.FAIL,"Title is same as expected");
			takescreenshot("NewPage.png");
		}
	}
	
	
	public void input_email() throws Exception //enter email
	{
		emailbox.clear();
		emailbox.sendKeys("yogiarora173@gmail.com");	 //to give input to email field in new page 
		Thread.sleep(3000);
	}
	
	public void click_checkmark() //click on checkmark
	{
		checkmark.click();
	}
	
	public void validate_email() throws Exception  //to valiadte email
	{	
		
		if(tickbox.getAttribute("class").contains("checkmark icon"))
		{
			System.out.println("Correct Email");
			testlog=ext.createTest("Email field validate");    //to validate email is valid
			testlog.log(Status.PASS,"Given Valid Email");
			takescreenshot("EmailField1.png");
		}
		else
		{
			System.out.println("Invalid email");
			testlog=ext.createTest("Email field validate");
			testlog.log(Status.FAIL,"Given Valid Email");
			takescreenshot("EmailField1.png");
		}
		
		emailbox.clear();
		emailbox.sendKeys("yogiarora173gmail.com");	
		Thread.sleep(3000);
		checkmark.click();
		
		if(tickbox.getAttribute("class").contains("remove icon"))
		{	
			System.out.println("InCorrect Email");
			testlog=ext.createTest("Email field validate with invalid");			//to validate email is invalid
			testlog.log(Status.PASS,"Given Invalid Email");
			takescreenshot("EmailField2.png");
		}
		else
		{
			System.out.println("Correct Email");
			testlog=ext.createTest("Email field validate with invalid");
			testlog.log(Status.FAIL,"Given Invalid Email");
			takescreenshot("EmailField2.png");
		}
	}
	
	public void place_email() throws Exception  //enter email
	{
		emailbox.clear();
		emailbox.sendKeys("yogiarora173@gmail.com");	
		Thread.sleep(3000);
		tickbox.click();
		eType.sendKeys("Personal");
		Thread.sleep(3000);
	}
	
	public void toAddmore()
	{	
		takescreenshot("OneEmail.png");
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/form/div[4]/div[1]/div/div/div/div[3]/button/i")).click();
	}
	
	public void newMail() throws Exception					//to add one more email
	{
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/form/div[4]/div[1]/div/div/div[2]/div[1]/div/input")).sendKeys("yogitaarora760@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/form/div[4]/div[1]/div/div/div[2]/div[2]/div/input")).sendKeys("Personal");
		takescreenshot("MoreEmail.png");
	}
	
	public void setStatus() throws Exception
	{
		statusbox.click();
		String priorityXpath = ".//span[contains(text(),'" + "New" + "')]";
		statusbox.findElement(By.xpath(priorityXpath)).click();
		testlog=ext.createTest("Status Update");						//to set status
		testlog.log(Status.PASS,"Given Status Field");
		takescreenshot("Status.png");
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(5000);
		//teardown();
	}
}
