package basicTests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.BrowserOperations;

import java.util.Set;

public class Pg_HandleWindows extends BrowserOperations {
    static Pg_HandleWindows obj = new Pg_HandleWindows();
    static JavascriptExecutor js;

    /**
     * Switches between window.
     */
    static void SwitchWindows(){
        Set<String> windows = driver.getWindowHandles();
        for (String win:
                windows) {
            if (!win.equals(driver.getWindowHandle())){
                driver.switchTo().window(win);
                break;
            }
        }
    }

    /**
     * Executes routine procedure till actual functionality of window handling.
     */
    void Routine(){
        obj.LaunchBrowser_Drivers();
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

        WebElement browserWindowEle = driver.findElement(By.xpath("//ul[@class='menu-list']/descendant::span[text()='Browser Windows']"));
        js.executeScript("arguments[0].scrollIntoView();", browserWindowEle);
        browserWindowEle.click();
    }

    /**
     * Clicking on New Tab btn on https://demoqa.com/browser-window and switching between tabs
     */
    void SwitchTabs(){
        obj.Routine();
        WebElement newTabBtn = driver.findElement(By.id("tabButton"));
        System.out.println("************************************************************");
        newTabBtn.click();

        //storing window handles and switching window
        SwitchWindows();

        System.out.println("URL of new window: " + driver.getCurrentUrl());
        WebElement newTab = driver.findElement(By.id("sampleHeading"));
        System.out.println("Title of new Window: " + newTab.getText());

        //switching back to parent tab
        SwitchWindows();
        System.out.println(driver.getCurrentUrl());
        System.out.println("************************************************************");

        obj.CloseBrowser();
    }

    /**
     * Clicking on New Window btn on https://demoqa.com/browser-windows and switching between windows
     */
    void SwitchToNewWindow(){
        obj.Routine();
        WebElement newWindowBtn = driver.findElement(By.id("windowButton"));
        System.out.println("************************************************************");
        newWindowBtn.click();

        //storing window handles and switching window
        SwitchWindows();

        System.out.println("URL of new window: " + driver.getCurrentUrl());
        WebElement newWin = driver.findElement(By.id("sampleHeading"));
        System.out.println("Title of new Window: " + newWin.getText());

        //switching back to parent tab
        SwitchWindows();
        System.out.println(driver.getCurrentUrl());
        System.out.println("************************************************************");

        obj.CloseBrowser();
    }

    public static void main(String[] args) {
        obj.SwitchTabs();
        obj.SwitchToNewWindow();
    }
}
