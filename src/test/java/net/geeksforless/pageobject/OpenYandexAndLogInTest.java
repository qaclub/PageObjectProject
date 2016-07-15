package net.geeksforless.pageobject;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

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
	public void setUp() {
		//Initialized driver
		driver = new FirefoxDriver();
		
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
	public void openLogIn() {	
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
