package org.testng.suites;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class GooglePage extends Common{
	
	@Test
	public void google() {
		driver.get("https://www.google.com/");
		try{
		Thread.sleep(5000);
		}
		catch(InterruptedException e){
			
		}
	}
	
}
