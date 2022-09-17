package pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {
	
	public WebDriver driver;
	public WebDriverWait wait;
		
	public void launchPage(String homeUrl) {
		driver.get(homeUrl);
		System.out.println("New Session");
	}
	
	public boolean isElementPresent(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	public WebElement getElement(By locator) {		
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));		
	}
	
	public void ClearBrowserCache()
	{
		driver.manage().deleteAllCookies();
		System.out.println("Cookies deleted");
		//((JavascriptExecutor) driver).executeScript("window.localStorage.clear()");
		//((JavascriptExecutor) driver).executeScript("window.sessionStorage.clear()");
	}
	
	public  void clickElement(By locator) {		
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(locator));
		ele.click();
	}
	
	public  void sendText(By locator, String inputText) {		
		WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		ele.clear();
		ele.sendKeys(inputText);		
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public void scrollToElement(By locator) throws Exception {
		
		 WebElement element = driver.findElement(locator);
	     ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	     Thread.sleep(500);
	}
	
	public void selectDropDown (By drpdwnLocator, String drpdwnValue) {
		
		driver.findElement(drpdwnLocator).click();
       driver.findElement(By.xpath("//div[text()='"+drpdwnValue+"']")).click();
	}
	
	public void navigateBack() {
		driver.navigate().back();
	}	
	
	public void closingDriver() {				
		driver.quit();
		//add extent reports flush.		
	}
	
	
	public void intiateBrowser() {		
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        //update to relative path instead of absolute path
        System.setProperty("webdriver.chrome.driver", "./resources/chromedriver/chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        ClearBrowserCache();
	}
	
	public void intiateWait() {		
		wait = new WebDriverWait(driver,Duration.ofSeconds(60));		
	}
	
	public void intiateReports() {
		
		// fill with reports code
	}
}
