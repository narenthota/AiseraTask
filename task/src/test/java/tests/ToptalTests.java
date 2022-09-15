package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.ToptalPage;

public class ToptalTests {
	
	ToptalPage tPage = new ToptalPage();
	
	@BeforeMethod
	public void intialize() {
		System.out.println("Initialize method");
		tPage.intiateBrowser();
		tPage.intiateWait();
		tPage.intiateReports();		
	}
		
	@Test (priority=1)
	public void verifying_presence_of_ApplyAsAFreeLancer_Links() {
		tPage.launchPage(tPage.url);
		tPage.acceptCookies();
		boolean isPresent = tPage.verifyApplyAsFreelancerLink();
		Assert.assertEquals(isPresent, true);	
	}
	
	@Test (priority=2)
	public void ApplyToToptal() {
		tPage.launchPage(tPage.url);
		tPage.acceptCookies();
		tPage.navigateToApplyPage();
		tPage.fillForm();
	}
	
	@AfterMethod
	public void closure() {				
		tPage.closingDriver();
		//add extent reports flush.		
	}
}
