package tests;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GooglePage;
import config.configManager;

public class GoogleTests {
	
	GooglePage gPage = new GooglePage();
	
	
	@BeforeMethod
	public void intialize() {
		System.out.println("Initialize method");
		gPage.intiateBrowser();
		gPage.intiateWait();
		gPage.intiateReports();
	}
	
	@Test
	public void verifying_presence_of_About_and_Business_Links() {
		gPage.launchPage(gPage.url);		
		boolean isPresent = gPage.verifyLinksOnHomePage();
		Assert.assertEquals(isPresent, true);		
	}
		
	@Test
	public void verifying_Navigation_to_About_by_Url() {
		gPage.launchPage(gPage.url);	
		gPage.navigateToPage("About");//convert to properties file
		String currentUrl = gPage.getCurrentUrl();
		Assert.assertEquals(currentUrl, "https://about.google/?utm_source=google-IN&utm_medium=referral&utm_campaign=hp-footer&fg=1", "About page is loaded");
		gPage.navigateBack();
		//convert to properties file
	}
	
	@Test
	public void verifying_Navigation_to_Business_by_Url() {
		gPage.launchPage(gPage.url);	
		gPage.navigateToPage("Business");//convert to properties file
		String currentUrl = gPage.getCurrentUrl();
		Assert.assertEquals(currentUrl, "https://www.google.com/intl/en_in/business/", "Business page is loaded");
		gPage.navigateBack();
		//convert to properties file
	}
	
	
	
	@AfterMethod
	public void closure() {				
		gPage.closingDriver();
		//add extent reports flush.		
	}
	

}
