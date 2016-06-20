package com.example.webguidemo.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home extends WebDriverPage {

	private final static String PROJECT_LINK = " //*[@id='recent-posts-3']/ul/li[3]/a";
	private final static String PROJECT_LINK_TEXT = "Setup First Project";


	WebDriver driver;

	WebDriverWait wait;
	JavascriptExecutor js;


	public Home(WebDriverProvider driverProvider) {
		super(driverProvider);
		driver = driverProvider.get();
		wait = new WebDriverWait(driver, 3);
		js = ((JavascriptExecutor) driver);
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

	public void inputTwoDigits(){
			findElement(By.xpath("//*[@id='vfb-3']")).sendKeys("23");
	}

	public void clickSubmitForDigits(){
		//findElement(By.name("vfb-submit")).click();
		//findElement(By.xpath("//*[@id='vfb-4']")).click();
		WebElement element = driver.findElement(By.className("vfb-submit"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	//	wait.until(ExpectedConditions.presenceOfElement(By.id("ID")));
		findElement(By.className("vfb-submit")).click();
	}
	//*[@id="vfb-4"]
	//*[@id="vfb-4"]

	//*[@id="vfb-3"]
	public void clickVerButton(){
		findElement(By.xpath("//*[@id='presscore-contact-form-widget-3']")).click();  //*[@id="presscore-contact-form-widget-3"]
	}

	public boolean findThisFieldRequired(){
		WebElement pom = findElement(By.xpath("//*[@id='item-vfb-2']/ul/li[1]/span/label[1]"));
		if (pom != null){
			return true;
		}else {
			return false;
		}

	}

	public boolean isFormSubmitedMessage(){
		WebElement pom = findElement(By.xpath("//*[@id='form_success']"));
		if (pom != null){
			return true;
		}else {
			return false;
		}

	}

	//*[@id="form_success"]

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
		//findElement(By. linkText("<a href=\"http://www.seleniumframework.com/setup-first-project/\">Setup First Project</a>")).click();
		WebElement element = driver.findElement(By.className("vfb-submit"));
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		findElement(By.xpath("//*[@id='recent-posts-3']/ul/li[3]/a")).click();
		//*[@id="recent-posts-3"]/ul/li[3]/a
	}
	
}
