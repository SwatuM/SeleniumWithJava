package basicTests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BrowserOperations;

import java.time.Duration;
import java.util.List;

public class Pg_HandleAlerts extends BrowserOperations {

    static Pg_HandleAlerts handleAlert = new Pg_HandleAlerts();
    static JavascriptExecutor js;
    void HandleAlert(){
        handleAlert.LaunchBrowser_Drivers();
        js = (JavascriptExecutor) driver;
        try {
            WebElement framesAndWindowsSection = driver.findElement(By.xpath("//div[@class='card-body']/descendant::*[text()='Alerts, Frame & Windows']"));
            //scroll till element is visible
            js.executeScript("arguments[0].scrollIntoView();", framesAndWindowsSection);
            framesAndWindowsSection.click();

            WebElement elementsHdr = driver.findElement(By.xpath("//div[@class='main-header']"));
            String hdrText = elementsHdr.getText();
            if (hdrText.equals("Alerts, Frame & Windows")) {
                System.out.println("Alerts, Frame & Windows page displayed.");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Alerts, Frame & Windows section not found.");
        }

        WebElement alertsEle = driver.findElement(By.xpath("//ul[@class='menu-list']/descendant::span[text()='Alerts']"));
        js.executeScript("arguments[0].scrollIntoView();", alertsEle);
        alertsEle.click();

        List<WebElement> alertBtn = driver.findElements(By.xpath("//button[text()='Click me']"));
        alertBtn.get(0).click();
        //simple alert accepted
        Alert simpleAlert = driver.switchTo().alert();
        String simpleAlertText = simpleAlert.getText();
        simpleAlert.accept();
        System.out.println("Simple alert text: " + simpleAlertText);
        System.out.println("Simple alert accepted.");

        //delayed simple alert accepted
        alertBtn.get(1).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert delayedAlert = driver.switchTo().alert();
        String delayedAlertText = delayedAlert.getText();
        System.out.println("Delayed alert text: " + delayedAlertText);
        delayedAlert.accept();
        System.out.println("Delayed alert accepted.");

        //confirmation alert accepted
        alertBtn.get(2).click();
        Alert confirmationAlert = driver.switchTo().alert();
        String confirmationAlertText = confirmationAlert.getText();
        System.out.println("Confirmation alert text: " + confirmationAlertText);
        confirmationAlert.accept();
        System.out.println("Confirmation alert accepted.");
        WebElement confirmationAlertResult = driver.findElement(By.xpath("//span[@id='confirmResult']"));
        System.out.println(confirmationAlertResult.getText());

        //confirmation alert dismissal
        alertBtn.get(2).click();
        confirmationAlert = driver.switchTo().alert();
        confirmationAlertText = confirmationAlert.getText();
        System.out.println("Confirmation alert text: " + confirmationAlertText);
        confirmationAlert.dismiss();
        System.out.println("Confirmation alert dismissed.");
        System.out.println(confirmationAlertResult.getText());

        //prompt alert accepted
        alertBtn.get(3).click();
        Alert promptAlert = driver.switchTo().alert();
        String promptAlertText = promptAlert.getText();
        System.out.println("Prompt alert text: " + promptAlertText);
        promptAlert.sendKeys("My mission RBI");
        promptAlert.accept();
        System.out.println("Prompt alert accepted.");
        WebElement promptAlertResult = driver.findElement(By.xpath("//span[@id='promptResult']"));
        System.out.println(promptAlertResult.getText());

        handleAlert.CloseBrowser();
    }
    public static void main(String[] args) {
        handleAlert.HandleAlert();
    }
}
