package stepDefination;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
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
	@Given("The snapdeal website is opened.")
	public void the_snapdeal_website_is_opened() {
		  driver.navigate().to("https://www.snapdeal.com/");
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
	}

	@When("The user moves to the Sign In button and Hold.")
	public void the_user_moves_to_the_sign_in_button_and_hold() {
		Actions action = new Actions(driver);
		WebElement LoginMenu = driver.findElement(By.className("accountInner"));
		action.moveToElement(LoginMenu).moveToElement(driver.findElement(By.className("accountInner"))).click().build().perform();
	}
	
	@When("The User moves to the Sign In button and click.")
	public void the_user_moves_to_the_sign_in_button_and_click() {
		WebElement Loginbtn= driver.findElement(By.xpath("//*[@id=\"sdHeader\"]/div[4]/div[2]/div/div[3]/div[3]/div/div/div[2]/div[2]/span[2]/a"));
		Loginbtn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("The user enters valid {string} and click continue.")
	public void the_user_enters_valid_and_click_continue(String Email) {
		
		WebElement email = driver.findElement(By.className("col-xs-24 clickOnceOnly"));
		email.sendKeys(Email);
		WebElement Continuebtn= driver.findElement(By.id("checkUser"));
		Continuebtn.click();	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("The user enters the valid {string} and click LOGIN.")
	public void the_user_enters_the_valid_and_click_login(String Password) {

		WebElement password = driver.findElement(By.xpath("//*[@id=\"userName\"]"));
		password.sendKeys(Password);
		WebElement LoginBtn= driver.findElement(By.id("checkUser"));
		LoginBtn.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("the user is logged in successfully")
	public void the_user_is_logged_in_successfully() {
		
	    
	}
	
}




