package stepDefination;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefination {
	FirefoxDriver driver;
	
	public stepDefination() {System.setProperty("webdriver.gecko.driver", "C:\\Users\\smahmoud\\Desktop\\Selenium by java\\geckodriver.exe");
	DesiredCapabilities capabilities = DesiredCapabilities.firefox();
	capabilities.setCapability("marionette", true);
	driver= new FirefoxDriver();
	}
	
	@Given("^the login page is opened$")
	public void the_login_page_is_opened() throws Throwable {
		driver.navigate().to("http://the-internet.herokuapp.com/login");
		driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
	}

	@When("^view the login page$")
	public void view_the_login_page() throws Throwable {
		assertTrue(driver.getTitle().contains("The Internet"));
	} 

	@When("^the user enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void the_user_enter_and(String username, String password) throws Throwable {
		WebElement usernameTxtbox = driver.findElement(By.id("username"));
		usernameTxtbox.sendKeys(username);
		WebElement passwordTxtbox = driver.findElement(By.id("password"));
		passwordTxtbox.sendKeys(password);
		WebElement loginbtn= driver.findElement(By.className("radius"));
		loginbtn.click();
	}

	@Then("^the successful message is appeared$")
	public void the_successful_message_is_appeared() throws Throwable {
		WebElement successheader= driver.findElement(By.xpath("//*[@id=\"content\"]/div/h2"));
		assertTrue(successheader.isDisplayed());
		driver.close();
	}
}


