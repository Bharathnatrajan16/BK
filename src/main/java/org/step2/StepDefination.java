package org.step2;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefination{
	
	WebDriver driver;
	@Given("I launch the Curry app")
	public void i_launch_the_Curry_app() throws IOException {

         driver=new ChromeDriver();
	    driver.get("https://www.currys.co.uk/");
	   WebElement button=driver.findElement(By.xpath("//button[text()='Accept All Cookies']")); 
	   button.click();
	    
	}

	@When("I navigate to the login screen")
	public void i_navigate_to_the_login_screen() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
	    WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Accept All Cookies']")));
        button.click();
	    
	}

	@When("I enter valid credentials")
	public void i_enter_valid_credentials() {
		//WebDriverWait wait = new WebDriverWait(driver, 10)
		WebElement usernameField = driver.findElement(By.className("slds-input focus-input-box pswrd"));
        WebElement passwordField = driver.findElement(By.name("j_id0:customerLoginForm:j_id26"));
        usernameField.sendKeys("bk@gmail.com");
        passwordField.sendKeys("123456");
		   		}



	@When("I tap on the login button")
	public void i_tap_on_the_login_button() {
		WebElement buton2 = driver.findElement(By.className("slds-button slds-button_brand submit btn"));
		buton2.click();
	   
	}

	@Then("I should be logged in successfully")
	public void i_should_be_logged_in_successfully() {
	   
	}

	@Then("I should be directed to the home screen")
	public void i_should_be_directed_to_the_home_screen() {
	    
	}

}
