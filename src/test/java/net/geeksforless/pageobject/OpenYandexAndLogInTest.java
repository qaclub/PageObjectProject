package net.geeksforless.pageobject;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

/*
 * Test class
 */
public class OpenYandexAndLogInTest {	
	
	//Driver object
	private WebDriver driver;
	
	//String that contain email and password for email box
	private final String email = "qateam.example@yandex.com";
	private final String password = "temp123";
	
	//Page objects
	private HomePage homePage;
	private LogInPage logInPage;
	private InboxPage inboxPage;

	/*
	 * Before method where all pre-testing settings are initialized
	 */
	@Before
	public void setUp() throws IOException {
		//Create file for Firebug extension
		File extension = new File("src/main/resources/firebug-2.0.17-fx.xpi");
		//Create new Firefox profile
		FirefoxProfile profile = new FirefoxProfile();		
		//Add extension to the profile
		profile.addExtension(extension);
		//Initialized driver with created profile
		 driver = new FirefoxDriver(profile);
		
		//Object of pages are initialized		
		homePage = new HomePage(driver);
		logInPage = new LogInPage(driver);
		inboxPage = new InboxPage(driver);
		
		//Driver settings
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.yandex.com");
	}
	
	/*
	 * Test method
	 */
	@Test
	public void openLogIn() throws InterruptedException {
		//Create new HashSet for cookies
		Set<Cookie> setOfCookies = new HashSet<>();
		
		//Get all the cookies
		setOfCookies = driver.manage().getCookies();
		
		//Print all the cookies names and values
		for (Cookie cookie : setOfCookies) {
			System.out.println("Cookie named - " + cookie.getName() + " has value - " + cookie.getValue());
		}
		
		//Set new cookie with name and value
		Cookie customCookie = new Cookie("gfl_cookie", "42");
		driver.manage().addCookie(customCookie);
		
		//Delete cookie by name
		driver.manage().deleteCookieNamed("gfl_cookie");
		
		//Delete all the cookies
		driver.manage().deleteAllCookies();
		
		//Click log in link on Home page
		homePage.clickLogInLink();
		
		//Log in to mail box
		logInPage.logIn(email, password);		
		
		//Click on 'Light version' link
		inboxPage.clickLightVersionLink();
		
	}
	
	/*
	 * After method where all post-testing settings are made
	 */
	@After
	public void tearDrop() {
		 //Quits the driver
		driver.quit();
	}
	
}
