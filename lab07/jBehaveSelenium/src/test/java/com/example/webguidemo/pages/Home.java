package com.example.webguidemo.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Home extends WebDriverPage {

	private final static String PROJECT_LINK = " //*[@id='recent-posts-3']/ul/li[3]/a";
	private final static String PROJECT_LINK_TEXT = "Setup First Project";

	WebDriver driver;

	public Home(WebDriverProvider driverProvider) {
		super(driverProvider);
		driver = driverProvider.get();
	}


	public void open() {
		get("http://www.seleniumframework.com/Practiceform/");
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public void clickAlertButton() throws InterruptedException{
		findElement(By.xpath("//*[@id='alert']")).click();
		Thread.sleep(2000);
	}

	public String alertCheck(){
		Alert simpleAlert = driver.switchTo().alert();
		String alertText = simpleAlert.getText();
		simpleAlert.accept();
		return alertText;
	}

	public void clickVerButton(){
		findElement(By.xpath("//*[@id='presscore-contact-form-widget-3']")).click();  //*[@id="presscore-contact-form-widget-3"]
	}
	public boolean findValidatorMessageRequired(){
		WebElement pom = findElement(By.xpath("//*[contains(text(),'This field is required.')]"));
		if (pom != null){
			return true;
		}else {
			return false;
		}

	}

	public void clickSetupProjectLink(){
		//findElement(By.xpath(SPORT_LINK)).click();
		findElement(By.xpath("//*[@id='recent-posts-3']")).click();
	}
	
}
