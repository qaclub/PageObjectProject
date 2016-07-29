package net.geeksforless.pageobject;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/*
 * Class that has only one static method for creating screenshots
 */
public class ScreenshotMaker {
	/*
	 * Static method for creating screenshots
	 */
	public static void makeNewScreenshot(String name, WebDriver driver) throws IOException {
		//Creating new object for date
		Date date = new Date();
		/*
		 * Creating simple date format for making pattern of date format. 
		 * "MM.dd.yyyy_HH-mm-ss" - will be look like 07.28.2016_18-50-23
		 */
		SimpleDateFormat sdf = new SimpleDateFormat("MM.dd.yyyy_HH-mm-ss");
		//Creating directory where all screenshots will be stored. If directory doesn't exist it will be created
		File pathFolder = new File("src/main/resources/screenshot");
		//Name of the screenshot. Date with applied format is added to the beginning
		String fileName = sdf.format(date) + "-" + name + ".png";
		//This line is creating screenshot itself
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//Creating new file with using declared path and name
		File output = new File(pathFolder, fileName);
		//Copy screenshot to the src/main/resources/screenshot with name for example 07.28.2016_18-50-23-inbox_page.png
		FileUtils.copyFile(screenshot, output);
	}

}
