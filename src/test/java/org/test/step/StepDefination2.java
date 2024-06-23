package org.test.step;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.When;
import io.cucumber.messages.types.Hook;
import io.cucumber.java.en.Then;

	public class StepDefination2 {

	    public WebDriver driver = Hooksclass.getDriver();
	    private WebDriverWait wait;

	    @Given("I launch the Curry app")
	    public void i_launch_the_Curry_app() {
	        wait = new WebDriverWait(driver, 10);

	        driver.get("https://www.currys.co.uk/");
	        WebElement cookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Accept All Cookies']")));
	        cookiesButton.click();
	    }

	    @When("I navigate to the login screen")
	    public void i_navigate_to_the_login_screen() {
	        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='account-modal-login']")));
	        loginButton.click();
	    }

	    @When("I enter valid credentials")
	    public void i_enter_valid_credentials() {
	        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("slds-input")));
	        WebElement passwordField = driver.findElement(By.name("j_id0:customerLoginForm:j_id26"));
	        usernameField.sendKeys("bk@gmail.com");
	        passwordField.sendKeys("123456");
	    }

	    @When("I tap on the login button")
	    public void i_tap_on_the_login_button() {
	        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("slds-button")));
	        loginButton.click();
	    }

	    @Then("I should be logged in successfully")
	    public void i_should_be_logged_in_successfully() {
	        // Add verification steps
	    }

	    @Then("I should be directed to the home screen")
	    public void i_should_be_directed_to_the_home_screen() {
	        // Add verification steps
	    }
	}


