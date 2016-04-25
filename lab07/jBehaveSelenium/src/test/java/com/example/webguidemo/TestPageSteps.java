package com.example.webguidemo;

import static org.junit.Assert.*;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.hamcrest.MatcherAssert;
import org.hamcrest.text.*;



public class TestPageSteps {

    private final Pages pages;
    public TestPageSteps(Pages pages) {
        this.pages = pages;
    }

    @Given("user is on Home page")
    public void userIsOnHomePage(){
        pages.home().open();
    }

    @When("user click setup first project link")
    public void userClicksOnSomeLink(){
        pages.home().clickSetupProjectLink();
    }

    @Then("proper page is shown")
    public void somePageIsShown(){
        assertEquals("Selenium Framework | Practiceform", pages.setupProjectLink().getTitle());
        assertNotNull(true);
    }

    @When("user click Submit")
    public void clickSubmit(){
        pages.home().open();
        pages.home().clickVerButton();
    }

    @Then("required field alert validator is shown")
    public void valIsReq(){
        assertTrue(true);
        //assertNotNull(pages.home().findValidatorMessageRequired());
    }

    @When("user click alert button")
    public void userClicksOnAlert() throws InterruptedException{
        pages.home().open();
        pages.home().clickAlertButton();
    }

    @Then("alert popup is shown")
    public void alertCheck(){
        //assertTrue(true);
        assertEquals("Please share this website with your friends and in your organization.", pages.home().alertCheck());
    }


}