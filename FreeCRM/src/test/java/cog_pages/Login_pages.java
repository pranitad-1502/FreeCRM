/* Author: Sofia Khanam
 * Date: 09 Jan 2021
 * Description: below code to
 * 				open the url
 * 				Login with valid input
 * 				Validate login function with different input data(valid and invalid) */
package cog_pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import cog_base.TestBase_Cogmento;

public class Login_pages extends TestBase_Cogmento {
	
	static @FindBy(xpath="//span[text()='Log In']") WebElement login;
	static @FindBy(name="email") WebElement email;
	static @FindBy(name="password") WebElement pass;
	static @FindBy(xpath="//div[text()='Login']") WebElement login1;
	
	public void open_url()												//To open freecrm page
	{
		//initialize();
		PageFactory.initElements(driver, this);
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		login.click();
	}

	public void login() throws Exception								//To enter valid mail and password
	{
		
		//Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		email.sendKeys("s7380519@gmail.com");
		pass.sendKeys("Freecrm01");
		login1.click();
		//Added testNG code
		Thread.sleep(5000);
		String t=driver.getPageSource();
		Thread.sleep(2000);
		if(t.contains("Sofia Khanam"))
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

	public void validate_title()
	{
		String title=driver.getTitle();
		if(title.contains("Cogmento CRM"))
				System.out.println("Results as expected");
		else
			System.out.println("Results not correct");
		/*try {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//div[@role='listbox']")).click();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//div[@class='menu transition visible']/a[5]")).click();
			Thread.sleep(3000);
		}
		catch(Exception e) {};*/
	}
	public void validate_page()
	{
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://ui.freecrm.com/" );
	}
	
	public void invalidlogin() throws Exception {								//To check for invalid login
		
		email.sendKeys("1502@gmail.com");
		pass.sendKeys("Dorae");
		login1.click();
		
	}

	public void correctemail() throws Exception {
		
		email.sendKeys("s7380519@gmail.com");
		pass.sendKeys("addw");
		login1.click();
	}
	public void correctpass() throws Exception {
	
	email.sendKeys("502@gmail.com");
	pass.sendKeys("Freecrm01");
	login1.click();
	}
	public void onlyemail() throws Exception {								//To login using empty field
		
		email.sendKeys("s7380519@gmail.com");
		pass.sendKeys("");
		login1.click();
	}
	public void onlypassword() throws Exception{
		
		Thread.sleep(5000);
		email.sendKeys("");
		pass.sendKeys("Freecrm01");
		login1.click();
	} 
	public void bothno() throws Exception{
		
		Thread.sleep(5000);
		email.sendKeys("");
		pass.sendKeys("");
		login1.click();
	}
	public void cleardata() {												//To clear the data
	 String inputText = email.getAttribute("value");
     if( inputText != null ) {
         for(int i=0; i<inputText.length();i++) {
             email.sendKeys(Keys.BACK_SPACE);
         }
         String inputpwd = pass.getAttribute("value");
         if( inputText != null ) {
             for(int i=0; i<inputpwd.length();i++) {
                 pass.sendKeys(Keys.BACK_SPACE);
             }
         }
     }
	}	
}