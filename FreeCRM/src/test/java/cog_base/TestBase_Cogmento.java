package cog_base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestBase_Cogmento 
{
	public static WebDriver driver; //for accessing package outside
	public static Properties prop;
	
	public static ExtentHtmlReporter htmlreport;
	public static ExtentReports ext;
	public static ExtentTest testlog;
	
	@BeforeSuite  						//for running suite (only once program)
	public void initialize()
	{
		prop = new Properties();
		try
		{
			prop.load(new FileInputStream("src/test/resources/config.properties"));
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		 htmlreport = new ExtentHtmlReporter(prop.getProperty("reportslocation")+"\\cogmento.html");
		 ext = new ExtentReports();
		 ext.attachReporter(htmlreport);
		 //ext.setSystemInfo("Host Name", "Yogita-sysname");
		 ext.setSystemInfo("Environment", "Test Env");
		 //ext.setSystemInfo("User Name", "Yogita-testername");
		   
		 htmlreport.config().setDocumentTitle("FreeCRM");
		 htmlreport.config().setReportName("FreeCRM Functional Testing");
		 htmlreport.config().setTestViewChartLocation(ChartLocation.TOP);
		 htmlreport.config().setTheme(Theme.STANDARD);	
		   
		   
		String browser=prop.getProperty("browser");
		if(browser.matches("firefox"))
		{
			driver=new FirefoxDriver();
		}
		if(browser.matches("chrome"))
		{
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	}
	
	public void takescreenshot(String imagename)
	{
		File f=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try
		{
		FileUtils.copyFile(f, new File(prop.getProperty("screens")+"\\"+imagename));
		testlog.addScreenCaptureFromPath(prop.getProperty("screens")+"\\"+imagename);
		}catch(Exception e) {}
	}
	
	@AfterSuite
	public void teardown()
	{	
		String browser=prop.getProperty("browser");
		ext.flush();//save the report
		driver.quit();//close if anyall browsers which are open
		
		if(browser.matches("firefox"))
		{
			try
			{	
			Runtime.getRuntime().exec("taskkill /f /im geckodriver.exe"); //kill the geckodriver process
			}catch(Exception e) {}
		}
		if(browser.matches("chrome"))
		{
			try
			{	
			Runtime.getRuntime().exec("taskkill /f /im chromeriver.exe"); //kill the chromedriver process
			}catch(Exception e) {}
		}
	}
}
