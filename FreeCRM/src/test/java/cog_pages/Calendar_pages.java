package cog_pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import cog_base.TestBase_Cogmento;

public class Calendar_pages extends TestBase_Cogmento
{

	static @FindBy(xpath="//span[text()='Log In']") WebElement login;
	static @FindBy(name="email") WebElement email;
	static @FindBy(name="password") WebElement pass;
	static @FindBy(xpath="//div[text()='Login']") WebElement login1;
	static @FindBy(xpath="//div[@name='calendar']") WebElement c;
	static @FindBy(xpath="//div[@name='category']") WebElement e;
	static @FindBy(xpath = "//button[@class='ui linkedin button']") WebElement s;
	public void openurl() throws Exception
	{	
		//initialize();
		PageFactory.initElements(driver, this);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	public void login() throws Exception
	{
		Thread.sleep(5000);
		email.sendKeys("ashwinij997@gmail.com");
		pass.sendKeys("Ashwini09");
		login1.click();
	}
	public void openCal() throws Exception
	{	
		driver.findElement(By.xpath("//span[text()='Calendar']")).click();
		Thread.sleep(2000);
	}
	public void validate_calpage() throws Exception
	{
		Thread.sleep(5000);
		String str=driver.getCurrentUrl();
		Thread.sleep(2000);
		if(str.contains("https://ui.freecrm.com/calendar"))                  
		{
			testlog=ext.createTest("Calendar-Homepage");
			testlog.log(Status.PASS,"Calendar home page is displayed to search");
			takescreenshot("calendarhomepage.png");
		}
		else
		{
			testlog=ext.createTest("Calendar-Homepage");
			testlog.log(Status.FAIL,"Calendar home page is displayed to search");
			takescreenshot("calendarhomepage.png");
		}
		Thread.sleep(3000);
	}
	public void click_agenda() throws Exception
	{
		driver.findElement(By.xpath("//span[text()='Agenda']")).click();
		Thread.sleep(5000);
		takescreenshot("agenda.png");
		Thread.sleep(5000);
	}
	public void agenda()
	{
		boolean str=driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div/div[2]/div/div[2]")).isDisplayed();
		if(str==true)
		System.out.println("Agenda page is displayed");
		else
		System.out.println("Agenda page is not displayed");
	}
	public void click_new()
	{
		driver.findElement(By.xpath("//*[@id=\"dashboard-toolbar\"]/div[2]/div/a")).click();
	}
	public void new_eventpage() throws Exception
	{
		String str=driver.getCurrentUrl();
		if(str.contains("https://ui.freecrm.com/calendar/new"))
		System.out.println("Create New Event page opened");
		else
		System.out.println(" Create New Event page did not open");
		Thread.sleep(5000);
	}
	public void empty_title_cal()
	{	
		System.out.println("Empty title and calendar");
	}

	public void alerterrormsg() throws Exception
	{
		s.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		//String str = driver.findElement(By.className("inline-error-msg")).getText();
		System.out.println("Required");
		//String str1 = driver.findElement(By.xpath("//*[@id=\"ui\"]/div[2]/div/div")).getText();
		//System.out.println(str1);
		Thread.sleep(3000);
	}
	public void valid_title(String Title) throws Exception
	{
		WebElement valid = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/form/div[1]/div[1]/div/div/input"));
		valid.sendKeys(Title);
		
	}
	public void valid_cal() throws Exception
	{
		c.click();
		Thread.sleep(2000);
		String statusXpath = ".//span[contains(text(),'" + "Panita Dorle" + "')]";
		c.findElement(By.xpath(statusXpath)).click();
		
		
	}
	public void other_details() throws Exception
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='react-datepicker-wrapper'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='20']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@class='react-datepicker-wrapper'])[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='21']")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("description")).click();
	}
	public void click_save() throws Exception
	{
		//driver.findElement(By.className("save icon"))
		//s.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='dashboard-toolbar']/div[2]/div/button[2]")).click(); //Click on save button
		Thread.sleep(5000);
	}
	public void validate_save() throws Exception
	{
		Thread.sleep(5000);
		takescreenshot("savedevent.png");
		Thread.sleep(5000);
		boolean str=driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div/div[1]/div")).isDisplayed();
		if(str==true)
		System.out.println("Event saved");
		else
		System.out.println("Event not saved");
	}
	public void new_event(String Title) throws Exception
	{
		WebElement valid = driver.findElement(By.name("title"));
		valid.sendKeys(Title);
		
	}
	public void cancel() throws Exception
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"dashboard-toolbar\"]/div[2]/div/button[1]")).click();
	}
	/*public void toggle() throws Exception 
	{
		Thread.sleep(5000);
		//driver.findElement(By.xpath("//input[@name='all_day']")).click();
		driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/form/div[5]/div[1]/div/div/input")).click();
		
	}
	public void toggle_state()
	{
		System.out.println("State changed to All Day");
	}*/
	public void category() throws Exception
	{
		Thread.sleep(3000);
		e.click();
		Thread.sleep(2000);
		String statusXpath = ".//span[contains(text(),'" + "Important" + "')]";
		Thread.sleep(2000);
		e.findElement(By.xpath(statusXpath)).click();
	}

}
