package com.TestBase;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.common.io.Files;

public class TestBase {
	public static WebDriver driver;

	public static void initialization() {
		String browserName = "chrome";

		if (browserName.equals("chrome")) {
			// System.setProperty("webdriver.chrome.driver",
			// "/Users/naveenkhunteta/Downloads/chromedriver");
			driver = new ChromeDriver();
		} else if (browserName.equals("FF")) {
			// System.setProperty("webdriver.gecko.driver",
			// "/Users/naveenkhunteta/Documents/SeleniumServer/geckodriver");
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.saucedemo.com/v1/");

	}

	public static void takeScreenShot() throws IOException {
		Date currentDate = new Date();
		System.out.println(currentDate);
		String FileName = currentDate.toString().replace(":", "-").replace("  ", "").replaceAll(" IST", "").replace(" ",
				"-");
		File screenshotfile = ((TakesScreenshot) (driver)).getScreenshotAs(OutputType.FILE);
		Files.copy(screenshotfile, new File(".//screenshots//" + FileName + ".png"));
		System.out.println("Screen shot taken");
		driver.quit();
	}
}
