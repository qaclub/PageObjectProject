package net.geeksforless.pageobject;

import java.io.IOException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * HomePage class where all methods that will be used on HomePage are realized
 */
public class HomePage {	
	
	/*
	 * Web Elements that made by @FindBy annotation
	 * @FindBy has all the methods that usual driver.findElement(By) construction	 
	 */
	@FindBy(linkText = "Log in")
	private WebElement logInLink;	
	
	//Object of WebDriver
	private WebDriver driver;
	
	/*
	 * Constructor that using PageFactory to initialize elements on page
	 */
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	/*
	 * Realization of clickLogInLink() method
	 */
	public void clickLogInLink() throws NoSuchElementException {
		//Creating screenshot
		try {
			ScreenshotMaker.makeNewScreenshot("home_page", driver);
		} catch (IOException e) {
			e.printStackTrace();
		}
		logInLink.click();			
	}

}
