package org.testng.suites;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FacebookPage extends Common{

	@Test
	public void google(){
		
		driver.get("https://www.facebook.com/");
		//driver.findElement(By.linkText("Forgotten accou")).click();
	}
}
