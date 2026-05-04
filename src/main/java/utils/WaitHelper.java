package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class WaitHelper {
	
	private WebDriver driver;

    // Constructor to receive the driver from your Step Definitions
    public WaitHelper(WebDriver driver) {
        this.driver = driver;
    }
    
    public WebElement waitForElementClickable(By locator, int timeout) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (Exception e) {
            System.out.println("LOG: Element not found: " + locator);
            return null;
        }
    }

    // UPDATED: Now returns the WebElement after clicking it via JS
    public WebElement jsClick(By locator, int timeout) {
        try {
            WebElement element = waitForElementClickable(locator, timeout);
            if (element != null) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
                return element; // Return the element so the script doesn't break
            }
        } catch (Exception e) {
            System.out.println("LOG: JS Click failed: " + e.getMessage());
        }
        return null;
    }
    
    public void jsClick(WebElement element, int timeout) {
    	try {
            // Wait for the specific object to be visible before clicking
            new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.visibilityOf(element));
            
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        } catch (Exception e) {
            System.out.println("JS Click failed: " + e.getMessage());
        }
    }
  
    //Scrolls to the element and click
    public void forceClick(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
        js.executeScript("arguments[0].click();", element);
    }

}
