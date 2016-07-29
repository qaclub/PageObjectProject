package net.geeksforless.pageobject;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * LogInPage class where all methods that will be used on LogInPage are realized
 */
public class LogInPage {	
	
	/*
	 * Web Elements that made by @FindBy annotation
	 * @FindBy has all the methods that usual driver.findElement(By) construction	 
	 */
	@FindBy(xpath = ".//*[@name='login']")
	private WebElement emailInput;
	
	@FindBy(xpath = ".//*[@name='passwd']")
	private WebElement passwordInput;
	
	@FindBy(xpath = "//span[text()='Log in']")
	private WebElement loginButton;
	
	//Object of WebDriver
	private WebDriver driver;
	
	/*
	 * Constructor that using PageFactory to initialize elements on page
	 */
	public LogInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);		
		this.driver = driver;
	}

	/*
	 * Realization of logIn() method
	 */
	public void logIn(String email, String password) throws NoSuchElementException {		
		emailInput.sendKeys(email);
		passwordInput.sendKeys(password);
		//Creating screenshot
		try {
			ScreenshotMaker.makeNewScreenshot("login_page", driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
		loginButton.click();		
	}

}
