package pages;

import org.openqa.selenium.By;

public class ToptalPage extends BasePage{
	
	public String url = "https://www.toptal.com/";
	private By AcceptcookiesButton = By.xpath("//div[@id='cookie-banner-host']//button");
	private By ApplyAsFreelancerLink = By.xpath("//a[text()='Apply as a Freelancer']");
	private By ApplyToJoinToptal = By.id("save_new_talent_create_applicant");
	private By FreelanceTypeDropDown = By.xpath("//div[@data-infield-label='I am a']");	
	private By FullNameTextBox = By.id("talent_create_applicant_full_name");
	private By EmailTextBox = By.id("talent_create_applicant_email");
	private By PasswordTextBox = By.id("talent_create_applicant_password");
	private By ConfirmPassword = By.id("talent_create_applicant_password_confirmation");
	
	
	public void acceptCookies() {
		clickElement(AcceptcookiesButton);
	}    		
    
	public boolean verifyApplyAsFreelancerLink() {
		return isElementPresent(ApplyAsFreelancerLink);
	}    

	public void navigateToApplyPage() {
		clickElement(ApplyAsFreelancerLink);
	}
	
	public void submitFreelanceApplicantForm() throws Exception {
		scrollToElement(ApplyToJoinToptal);
		selectDropDown(FreelanceTypeDropDown, "Designer");		
	}
	
	public void fillForm() {
		sendText(FullNameTextBox, "tester123");
		sendText(EmailTextBox, "tester123@test.com");
		sendText(PasswordTextBox, "password123");
		sendText(ConfirmPassword, "password123");
		clickElement(ApplyToJoinToptal);		
	}
    
    
}
