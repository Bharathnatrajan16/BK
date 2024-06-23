package org.test.step;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import io.cucumber.java.After;
	import io.cucumber.java.Before;

	public class Hooksclass {

	    private static WebDriver driver;

	    @Before
	    public void setupWebDriver() {
	        driver = new ChromeDriver();
	    }

	    @After
	    public void teardownWebDriver() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }

	    public static WebDriver getDriver() {
	        return driver;
	    }
	}


