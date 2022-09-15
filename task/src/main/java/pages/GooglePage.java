package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GooglePage extends BasePage{
	
	private By AboutLink = By.xpath("//div/a[text()='About']");
	private By BusinessLink = By.xpath("//div/a[text()='Business']");
	public String url = "https://www.google.com";
	
	
	public boolean verifyLinksOnHomePage() {
		return isElementPresent(AboutLink) && isElementPresent(BusinessLink);
	}
	
	public void navigateToPage(String pageName) {
		clickElement(By.xpath("//div/a[text()='"+ pageName +"']"));		
	}
}
