package net.geeksforless.pageobject;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * InboxPage class where all methods that will be used on InboxPage are realized
 */
public class InboxPage {
	
	//Object of WebDriverWait
	WebDriverWait wait;
	
	/*
	 * Web Elements that made by @FindBy annotation
	 * @FindBy has all the methods that usual driver.findElement(By) construction	 
	 */
	@FindBy(linkText = "Light version")
	private WebElement lightVersionLink;
	
	/*
	 * Constructor that using PageFactory to initialize elements on page
	 * and initialize WebDriverWait
	 */
	public InboxPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 20);
	}	

	/*
	 * Realization of clickLightVersionLink() method
	 */
	public void clickLightVersionLink() throws NoSuchElementException {
		lightVersionLink.click();	
		wait.until(ExpectedConditions.urlToBe("https://mail.yandex.com/lite/inbox"));
	}

}
