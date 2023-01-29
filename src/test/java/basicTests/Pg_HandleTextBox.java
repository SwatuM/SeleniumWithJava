package basicTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import utilities.BrowserOperations;

public class Pg_HandleTextBox extends BrowserOperations{
	static Pg_HandleTextBox tBox = new Pg_HandleTextBox();
	
	void HandleTextBox() throws InterruptedException {
		tBox.LaunchBrowser_Drivers();
		
		try {
			WebElement elementsSection = driver.findElement(By.xpath("//div[@class='card-body']/descendant::*[text()='Elements']"));
			//scroll till element is visible
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", elementsSection);
			elementsSection.click();
			
			WebElement elementsHdr = driver.findElement(By.xpath("//div[@class='main-header']"));
			String hdrText = elementsHdr.getText();
			if (hdrText.equals("Elements")) {
				System.out.println("Elements page displayed.");
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Elements section not found.");
		}
		
		WebElement textBox = driver.findElement(By.xpath("//ul[@class='menu-list']/descendant::span[text()='Text Box']"));
		textBox.click();
		
		WebElement fullName = driver.findElement(By.id("userName"));
		WebElement email = driver.findElement(By.id("userEmail"));
		WebElement currentAddr = driver.findElement(By.id("currentAddress"));
		WebElement permenantAddr = driver.findElement(By.id("permanentAddress"));
		WebElement submitBtn = driver.findElement(By.id("submit"));
		
		fullName.sendKeys("Narendra Modi");
		email.sendKeys("narendra.modi@gmail.com");
		currentAddr.sendKeys("Ahemadabad, Gujrat, India.");
		permenantAddr.sendKeys("Ahemadabad, Gujrat, India.");
		Wait();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", submitBtn);
		submitBtn.click();
		
		WebElement output = driver.findElement(By.id("output"));
		System.out.println(output.getText());
		tBox.CloseBrowser();
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		tBox.HandleTextBox();

	}

}
