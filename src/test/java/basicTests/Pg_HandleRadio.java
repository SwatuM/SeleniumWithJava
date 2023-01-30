package basicTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.BrowserOperations;

import java.util.List;

public class Pg_HandleRadio extends BrowserOperations {

    static Pg_HandleRadio radio = new Pg_HandleRadio();

    /**
     * Handles radio btn.
     * @throws InterruptedException
     */
    void HandleRadioBtn() throws InterruptedException {
        radio.LaunchBrowser_Drivers();

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

        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement radioBtn = driver.findElement(By.xpath("//ul[@class='menu-list']/descendant::span[text()='Radio Button']"));
        js.executeScript("arguments[0].scrollIntoView();", radioBtn);
        radioBtn.click();
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//div[text()='Do you like the site?']")));
        List<WebElement> radioBtns = driver.findElements(By.xpath("//div[text()='Do you like the site?']/following-sibling::div/label"));
        for (WebElement btn:
             radioBtns) {
            btn.click();
            WebElement resultText = driver.findElement(By.className("mt-3"));
            System.out.println(resultText.getText());
            Wait();
        }

        radio.CloseBrowser();
    }

    public static void main(String[] args) throws InterruptedException {
        radio.HandleRadioBtn();
    }
}
