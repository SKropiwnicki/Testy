package com.example.seleniumdemo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SomeSiteTest {

	private static WebDriver driver;
	WebElement element;

	@BeforeClass
	public static void driverSetup() {
		// ChromeDrirver, FireforxDriver, ...
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void homePage(){
		driver.get("https://www.reddit.com/r/darksouls3/");
		
		element = driver.findElement(By.linkText("najnowsze"));
		assertNotNull(element);
	}
	
	@Test
	public void ds3Page(){
		driver.get("https://www.reddit.com/r/darksouls3/");
		driver.findElement(By.linkText("najnowsze")).click();
		element = driver.findElement(By.linkText("najnowsze"));
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    assertNotNull(screenshot);

		try {
			FileUtils.copyFile(screenshot, new File("/Users/Kasiunia/screenshots/reddit.png"));
		} catch (IOException e) {
			e.printStackTrace();
			assertTrue(false);
		}
		
	}

	@AfterClass
	public static void cleanp() {
		driver.quit();
	}
}
// http://nowedemo.mbank.pl/#/payments  tym sie pobaw potem w domu;