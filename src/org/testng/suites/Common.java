package org.testng.suites;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Common {

	public static WebDriver driver;
	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser){

		if(browser.equals("firefox")){
			driver=new FirefoxDriver();
		}
		else if(browser.equals("chrome")){

			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\Selenium\\chrome driver\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

	}
	@AfterMethod
	public void tearDown() throws Exception{
		Thread.sleep(5000);
		//driver.quit();
	}
	public static void screenShot() {

		DateFormat df=new SimpleDateFormat("dd-MMM-YY hh-mm-ss");
		Date dt=new Date();
		File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File path=new File("F:\\Selenium\\Screenshots\\"+df.format(dt)+".png");
		try{
			FileUtils.copyFile(screenshot, path);
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
}
