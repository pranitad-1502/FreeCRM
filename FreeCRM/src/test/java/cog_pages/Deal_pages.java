/* Author: Pranita Dorle
 * Date: 09 Jan 2021
 * Description: Validate Deals and new button
 * 				Validate fields in create new deal
 * 				Blank Title and Save
 * 				Valid title and Save
 * 				Toggle Button,drop-down
 * 				Delete the record
 * 				Validate Save and cancel button*/
package cog_pages;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.Status;

import cog_base.TestBase_Cogmento;

public class Deal_pages  extends TestBase_Cogmento
{
	static @FindBy(xpath="//span[text()='Log In']") WebElement login;
	static @FindBy(name="email") WebElement email;
	static @FindBy(name="password") WebElement pass;
	static @FindBy(xpath="//div[text()='Login']") WebElement login1;
	static @FindBy(xpath="//div[@name='type']") WebElement e;
	
	public void openurl() throws Exception
	{
		//initialize();
		PageFactory.initElements(driver, this);
		driver.get(prop.getProperty("url"));
		
		System.out.println("FreeCRM URL is opened");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		login.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		email.sendKeys("pranita1502@gmail.com");
		pass.sendKeys("DoraeMon@90");
		login1.click();
		System.out.println("User has successfully logged in into the FreeCRM Cogmento account");
		
		Thread.sleep(5000);
		String t=driver.getPageSource();
		Thread.sleep(2000);
		if(t.contains("Pranita Dorle"))
		{
			testlog=ext.createTest("Cogmento-Homepage");
			testlog.log(Status.PASS,"Cogmento home page is displayed to search");
			takescreenshot("cogmentohomepage.png");
		}
		else 
		{
			testlog=ext.createTest("Cogmento-Homepage");
			testlog.log(Status.FAIL,"Cogmento home page is not displayed to search");
			takescreenshot("cogmentohomepage.png");
		}
		Thread.sleep(3000);
	}
	
	public void LeftBar()
	{
		PageFactory.initElements(driver, this);
		driver.findElement(By.xpath("//span[text()='Deals']")).click();   //Click on Deals on leftside bar                         
	}
	
	public void validate_dealspage() throws Exception                     //To validate whether Deals homepage is opened or not
	{
		Thread.sleep(5000);
		String str=driver.getCurrentUrl();
		Thread.sleep(2000);
		if(str.contains("https://ui.freecrm.com/deals"))                  
		{
			testlog=ext.createTest("Deals-Homepage");
			testlog.log(Status.PASS,"Deals home page is displayed to search");
			takescreenshot("dealshomepage.png");
		}
		else
		{
			testlog=ext.createTest("Deals-Homepage");
			testlog.log(Status.FAIL,"Deals home page is displayed to search");
			takescreenshot("dealshomepage.png");
		}
		Thread.sleep(3000);
	}
	
	public void click_new()
	{
		driver.findElement(By.xpath("//*[@id=\"dashboard-toolbar\"]/div[2]/div/a[3]")).click(); //Click on New
		System.out.println("User has clicked on New");
	}
	
	public void new_dealspage() throws Exception //To validate whether Create New Deals page is open
	{
		Thread.sleep(5000);
		String str=driver.getCurrentUrl();
		Thread.sleep(2000);
		if(str.contains("https://ui.freecrm.com/deals/new"))                  
		{
			testlog=ext.createTest("Create New Deals-Homepage");
			testlog.log(Status.PASS,"Create New Deals home page is displayed to search");
			takescreenshot("CreateNewdealshomepage.png");
		}
		else
		{
			testlog=ext.createTest("Create New Deals-Homepage");
			testlog.log(Status.FAIL,"Create New Deals home page is displayed to search");
			takescreenshot("CreateNewdealshomepage.png");
		}
		Thread.sleep(3000);
	}
	
	public void title_empty_and_save()
	{
		WebElement inputBox = driver.findElement(By.name("title"));
		String textInsideInputBox = inputBox.getAttribute("value");

		// Check whether input field is blank
		if(textInsideInputBox.isEmpty())
		{
		   System.out.println("Input field is empty");
		   driver.findElement(By.xpath("//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]")).click(); //Click on save button
		}
	}
	
	public void alerterrormsg()
	{
		String str = driver.findElement(By.xpath("//span[@class='inline-error-msg']")).getText();
		System.out.println(str);
		driver.navigate().back();
	}
	
	public void valid_title(String Title) throws Exception
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"dashboard-toolbar\"]/div[2]/div/a[3]")).click();  //click on new
		Thread.sleep(2000);
		WebElement validtitle = driver.findElement(By.name("title"));
		validtitle.sendKeys(Title);
		driver.findElement(By.xpath("//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]/i")).click(); //click on save to create new deal
		Thread.sleep(5000);   
		driver.findElement(By.xpath("//span[text()='Deals']")).click();
		Thread.sleep(5000);
	}
	
	public void new_deal_visible() 
	{
		if(driver.getPageSource().contains("Cogmento FreeCRM Finance"));
		{
		System.out.println("New deal is added");
		}
		System.out.println("New Deal is not added");
		
	}
	
	public void cancel() throws Exception
	{
		driver.findElement(By.xpath("//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[1]/i")).click();  //Click on Cancel
	}
	
	public void click_trashicon() throws Exception
	{
		Thread.sleep(2000);
		takescreenshot("beforedelete.png");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div[2]/table/tbody/tr/td[8]/div/button")).click();    //trashicon
		driver.findElement(By.xpath("/html/body/div[3]/div/div[3]/button[2]")).click();
		
		Thread.sleep(2000);//delete
		driver.navigate().refresh();
		Thread.sleep(2000);
		takescreenshot("afterdelete.png");
	}
	
	public void toggle_button() throws Exception
	{
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/form/div[7]/div[2]/div/div")).click();
	}
	
	public void downarrow() 
	{
		System.out.println("User has clicked on down arrow of Tasks");
	}
	
	public void setStatus() throws Exception
	{
		e.click();
		String statusXpath = ".//span[contains(text(),'" + "New" + "')]";
		e.findElement(By.xpath(statusXpath)).click();
		System.out.println("New selected from dropdown");
		driver.navigate().back();
		Thread.sleep(5000);
	}
}
