package org.testng.suites;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryLogic extends Common implements IRetryAnalyzer{

	int count=0;
	int retryLimit=3;
	@Override
	public boolean retry(ITestResult result) {
		if(count<retryLimit){
			count++;
			return true;
		}
		else{
			
			DateFormat df=new SimpleDateFormat("dd-MMM-YY hh-mm-ss");
			Date dt=new Date();
			File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File path=new File("F:\\Selenium\\Screenshots\\"+df.format(dt)+".png");
			try {
				FileUtils.copyFile(screenshot, path);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			// OR
			//screenShot();
			return false; 

		}

	}

}
