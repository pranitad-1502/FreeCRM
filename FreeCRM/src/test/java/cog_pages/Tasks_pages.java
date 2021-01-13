package cog_pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import cog_base.TestBase_Cogmento;

public class Tasks_pages  extends TestBase_Cogmento
{
	static @FindBy(xpath="/html/body/div[1]/header/div/nav/div[2]/div/div[2]/ul/a/span[1]") WebElement login;
	static @FindBy(name="email") WebElement email;
	static @FindBy(name="password") WebElement pass;
	static @FindBy(xpath="//div[text()='Login']") WebElement login1;
	static @FindBy(xpath="//div[@name='type']") WebElement e;

public void login() throws Exception
	{
		//initialize();
		PageFactory.initElements(driver, this);
		driver.get(prop.getProperty("url"));
	    Thread.sleep(2000);
		login.click();
	    //driver.findElement(By.xpath("//html/body/div[1]/header/div/nav/div[2]/div/div[2]/ul/a/span[1]")).click();
		Thread.sleep(2000);
		email.sendKeys("vaishnavikotgire1998@gmail.com");
		pass.sendKeys("Kotgire@1998");
		login1.click();
		System.out.println("Login Successfull");
		Thread.sleep(5000);

		String t=driver.getPageSource();
		Thread.sleep(2000);
		if(t.contains("Vaishnavi Kotgire"))
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
		driver.findElement(By.xpath("//span[text()='Tasks']")).click();                            
	}
	
	public void validate_taskspage() throws Exception
	{
		Thread.sleep(5000);
		String str=driver.getCurrentUrl();
		Thread.sleep(2000);
		if(str.contains("https://ui.freecrm.com/tasks"))                  
		{
			testlog=ext.createTest("Tasks-Homepage");
			testlog.log(Status.PASS,"Tasks home page is displayed to search");
			takescreenshot("taskshomepage.png");
		}
		else
		{
			testlog=ext.createTest("Tasks-Homepage");
			testlog.log(Status.FAIL,"Tasks home page is displayed to search");
			takescreenshot("Taskshomepage.png");
		}
		Thread.sleep(3000);
		
	}
	
	public void click_new()
	{
		driver.findElement(By.xpath("//*[@id=\"dashboard-toolbar\"]/div[2]/div/a/button/i")).click();
	}
	
	public void new_taskspage() throws Exception
	{
		String str=driver.getCurrentUrl();
		if(str.contains("https://ui.freecrm.com/tasks/new"))
		System.out.println("Create New Tasks Homepage is open");
		else
		System.out.println(" Create New Tasks Homepage did not open");
		Thread.sleep(5000);
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
		    //driver.navigate().back();
	    }
	public void valid_title(String Title) throws Exception
		{
			WebElement validtitle = driver.findElement(By.name("title"));
			Thread.sleep(5000);
			validtitle.sendKeys(Title);
			driver.findElement(By.xpath("//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[2]")).click();
			Thread.sleep(5000);   
			driver.findElement(By.xpath("//span[text()='Tasks']")).click();
			Thread.sleep(5000);
		}
		
	public void new_task_visible() 
		{
			if(driver.getPageSource().contains("Cogmento FreeCRM Finance"));
			{
			
	            System.out.println("New task is added");
			}
		}
	public void cancel() throws Exception
	{
		driver.findElement(By.xpath("//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[1]")).click();
		
	}
	
	
	public void setAccess()
	{
		String existingValue;
		String access="Private";
		WebElement accessElement=driver.findElement(By.xpath ("//button[@class='ui small fluid positive toggle button']"));
		if (accessElement.getText().contains("Public")) 
		{
			existingValue = "Public";
		}
		else
		{
			existingValue = "Private";
		}
		if (!access.equalsIgnoreCase(existingValue))
		{
			accessElement.click();// this will toggle between public and private
		}
	}
	
	
	
}
	
