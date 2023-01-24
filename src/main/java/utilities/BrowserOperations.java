package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserOperations {
	
	public static WebDriver driver;
	
	/**
	 * Launches browser using drivers.
	 */
	public void LaunchBrowser_Drivers() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\IC0N\\eclipse-workspace\\MySelenium\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	/**
	 * Launches browser without using drivers.
	 */
	public void LaunchBrowser_WebDriverManager(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
	}

	/**
	 * Close the browser.
	 */
	public void CloseBrowser() {
		driver.close();
		driver.quit();
	}
	
	/**
	 * Waits for the specified time.
	 * @throws InterruptedException
	 */
	public void Wait() throws InterruptedException {
		Thread.sleep(2000);
	}
}
