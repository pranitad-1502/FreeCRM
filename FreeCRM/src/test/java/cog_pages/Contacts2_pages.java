package cog_pages;

import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import cog_base.TestBase_Cogmento;

public class Contacts2_pages extends TestBase_Cogmento {

	static @FindBy(xpath="//span[text()='Log In']") WebElement login;
	static @FindBy(name="email") WebElement email;
	static @FindBy(name="password") WebElement pass;
	static @FindBy(xpath="//div[text()='Login']") WebElement login1;
	static @FindBy(xpath="//*[@id='dashboard-toolbar']/div[2]/div/a") WebElement newbutton;
	static @FindBy(name="first_name") WebElement fn;
	static @FindBy(name="last_name") WebElement ln;
	static @FindBy(xpath="//button[@class='ui linkedin button']") WebElement save;
	static @FindBy(xpath="//div[@class='ui header item mb5 light-black']") WebElement username;
	static @FindBy(xpath="//i[@class='edit icon']") WebElement edit;
	static @FindBy(xpath="//div[@name='company']/input[@aria-autocomplete='list']") WebElement company;
	static @FindBy(xpath="//div[@class='four wide field']/button/i") WebElement tog_button;
	static @FindBy(xpath="(//div[@name='category'])[1]/i[@class='dropdown icon']")WebElement category;
	static @FindBy(xpath="//div[@class='two fields'][11]/div/div/div") WebElement do_not_call;
	static @FindBy(xpath="//div[@class='two fields'][11]/div[2]/div/div") WebElement do_not_text;
	static @FindBy(xpath="//div[@class='two fields'][12]/div/div/div") WebElement do_not_email;
	
	
	
	public void click_new_contact() throws InterruptedException
	{   
		PageFactory.initElements(driver, this);
		newbutton.click();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
	}
	
	public void validate_new_contactspage() throws Exception
	{
		String URL = driver.getCurrentUrl();
		//Assert.assertEquals(URL, "https://ui.freecrm.com/contacts/new" );
		if(URL.contains("https://ui.freecrm.com/contacts/new"))
		   System.out.println("Create new contact page is opened");
		else
		   System.out.println("Create new contacts page did not open");
		System.out.println("========================================");
		Thread.sleep(3000);

	}
	public void firstlast(String str1, String str2) throws Exception
	{
		fn.sendKeys(str1);
		Thread.sleep(2000);
		ln.sendKeys(str2);
		Thread.sleep(2000);
	}
	
	
	public void validate_save() throws Exception
	{   save.click();
	    Thread.sleep(2000);
		edit.click();
	    Thread.sleep(3000);
	    fn.clear();
	    Thread.sleep(2000);
	    ln.clear();
	    Thread.sleep(3000);
	    System.out.println("Input has been taken");
		System.out.println("*********aj1***********");
		System.out.println("========================================");
    }
	
	public void blank_first_last() throws Exception
	{   
		driver.findElement(By.xpath("//span[text()='Contacts']")).click(); 
		Thread.sleep(3000);
		newbutton.click();
		Thread.sleep(5000);
		String textInsideFnBox = fn.getAttribute("value");
		String textInsideLnBox = ln.getAttribute("value");
		if(textInsideFnBox.isEmpty()&&textInsideLnBox.isEmpty())
		{
			save.click();
			Thread.sleep(2000);
		}
		
	}
	
	public void errormsg()
	{
		String msg1 = driver.findElement(By.xpath("//span[@class='inline-error-msg']")).getText();
		String msg2 = driver.findElement(By.xpath("(//span[@class='inline-error-msg'])[2]")).getText();
		System.out.println(msg1+"\n"+msg2);
		System.out.println("*********aj2***********");
		System.out.println("========================================");
		
	}
	
	public void company_textbox()
	{
		company.click();
		String val=company.getAttribute("value");
		if(val.isEmpty())
			System.out.println("empty value in company textbox");
		
	}
	
	public void msg_for_emptycompany() 
	{
		String emptymsg=driver.findElement(By.xpath("//div[@class='message']")).getText();
		System.out.println(emptymsg);
		System.out.println("*********aj3***********");
		System.out.println("========================================");
	}
	
	public void public_private_button() throws Exception
	{
		tog_button.click();
		Thread.sleep(5000);
	}
	
	public void chk_button_state() throws Exception
	{
		if((tog_button.getAttribute("class").contains("lock icon")))
            System.out.println("Account is Private");
		else
			System.out.println("Account is Public");
		
		System.out.println("*********aj4***********");
		System.out.println("========================================");
		Thread.sleep(2000);
		
	}
	String val;
	public void category_dropdown() throws Exception
	{
		category.click();
		Thread.sleep(2000);
		List<WebElement> options=driver.findElements(By.xpath("(//div[@name='category'])[1]/div[2]/div/span"));
		System.out.println(options.size());
	    options.get(1).click();
		Thread.sleep(2000);
		val=options.get(1).getAttribute("innerHTML");
	}
	public void display_category() throws Exception
	{
	    System.out.println(val);
	    
	    System.out.println("*********aj5***********");
	    System.out.println("========================================");
	    Thread.sleep(2000);
	}
	
	public void all_tog_button() throws Exception
	{   Point p=do_not_call.getLocation();
        JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo(0,"+p.getY()+")");
	    Thread.sleep(3000);
	    
		do_not_call.click();
		Thread.sleep(2000);
		do_not_text.click();
		Thread.sleep(2000);
		do_not_email.click();
		Thread.sleep(2000);
	}
	
	public void chk_all_tog_button_state()
	{
		if(((do_not_call.getAttribute("class")).contains("ui checked toggle checkbox"))&&((do_not_text.getAttribute("class")).contains("ui checked toggle checkbox"))&&((do_not_email.getAttribute("class")).contains("ui checked toggle checkbox")))
		    System.out.println("All toggle buttons are on");
		else
			System.out.println("All toggle buttons are off");
		System.out.println("*********aj6***********");
		System.out.println("========================================");
		
	}
	public void imageplaceholder() throws Exception
	{
		driver.findElement(By.name("image")).click();
		Thread.sleep(2000);
	
	}
	
	public void uploadimage() throws Exception
	{
		Runtime.getRuntime().exec("C:\\eclipsedemo\\aishwarya1.exe");
		Thread.sleep(2000);
		System.out.println("Image uploaded successfully");
		System.out.println("*********aj7***********");
		System.out.println("========================================");
		
		driver.navigate().back();
		Thread.sleep(5000);
		
	}

}


