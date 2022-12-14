package Helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.function.Function;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverHelper {
	public static Properties prop;
	public static WebDriver driver;
	public static WebDriverWait wait;

	static {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:\\Users\\mdandotiya\\eclipse-workspace\\AutomationProject\\Config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initialization1() {
		driver.navigate().to(prop.getProperty("url"));

	}

    public WebElement waitForExpectedElement(final By by) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }
    }
    
    public WebElement waitForExpectedElement(final By by, long waitTimeInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds));
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (NoSuchElementException | TimeoutException e) {
         
            return null;
        } catch (StaleElementReferenceException e) {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        }
    }
    
    
    public void clickByElementByQueryJSExecutor(final By by) {
        wait.until(ExpectedConditions.presenceOfElementLocated(by));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", waitForExpectedElement(by));
        jse.executeScript("arguments[0].click()",waitForExpectedElement(by));
    }
    
    public void selectValueFromDropDownByWebElement(WebElement ele, String text) {
        Select dropdown = new Select(ele);
        dropdown.selectByVisibleText(text);
    }
    
    public void hoverOnElement(By by) {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(by)).build().perform();
    }

    public void clickUsingJS(By by){
        WebElement element;
        try {
            element = driver.findElement(by);
        } catch (StaleElementReferenceException e) {
        	driver.navigate().refresh();
            element =  driver.findElement(by);
        }
        ((JavascriptExecutor)  driver).executeScript("arguments[0].click()", element);
    }
    public void waitForItemToBeClickableAndClick(By by,long waitTimeInSeconds){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(waitTimeInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(by));
        waitForExpectedElement(by).click();
    }
    
    public void selectValueFromDropDownByby(String itemToSelect, By by){
        Select ProductDropDown;
        try {
            ProductDropDown = new Select(waitForExpectedElement(by, 10));
        }
        catch(WebDriverException e){
            ProductDropDown = new Select(driver.findElement(by));
        }
        try{
            ProductDropDown.selectByVisibleText(itemToSelect);
        }catch (Exception e){
            ProductDropDown.selectByIndex(1);
        }
    }

    public void selectValueFromDropDownByIndex(int index, By by) {
        Select ProductDropDown;
        try {
            ProductDropDown = new Select(waitForExpectedElement(by, 20));
        }
        catch(WebDriverException e){
            ProductDropDown = new Select(driver.findElement(by));
        }
        ProductDropDown.selectByIndex(index);
    }

    public void selectOptionFromDropDownByValue(String value, By by) {
        Select ProductDropDown = new Select(waitForExpectedElement(by,20));
        ProductDropDown.selectByValue(value.trim());
    }
    
    public static void takeScreenshot() {
	
	TakesScreenshot scrshot= ((TakesScreenshot)driver);
	   
File scrfile=	scrshot.getScreenshotAs(OutputType.FILE);

File Destfile= new File("C:\\Users\\mdandotiya\\eclipse-workspace\\AutomationProject\\Screenshots\\"+System.currentTimeMillis()+".png");

try {
	FileUtils.copyFile(scrfile, Destfile);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}

	
    }
}
    
    
    
   
    
    
    


