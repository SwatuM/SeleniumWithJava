package basicTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utilities.BrowserOperations;

public class SampleTest extends BrowserOperations{
	static SampleTest obj_SampleTest;
	
	/**
	 * Test/Functionality to be executed.
	 * @throws InterruptedException 
	 */
	public void Login() throws InterruptedException {
		driver.get("https://www.saucedemo.com/v1/index.html");
		WebElement userName = driver.findElement(By.id("user-name"));
		WebElement password = driver.findElement(By.id("password"));
		WebElement loginBtn = driver.findElement(By.id("login-button"));
		
		userName.sendKeys("standard_user");
		password.sendKeys("secret_sauce");
		Wait();
		loginBtn.click();
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		obj_SampleTest = new SampleTest();
		obj_SampleTest.LaunchBrowser_Drivers();
		//obj_SampleTest.LaunchBrowser_WebDriverManager("chrome");
		obj_SampleTest.Login();
		obj_SampleTest.CloseBrowser();
	}

}
