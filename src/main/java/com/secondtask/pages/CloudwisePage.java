package com.secondtask.pages;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.secondtask.base.TestBase;
import com.secondtask.util.TestUtil;

public class CloudwisePage extends TestBase {

	TestBase base = new TestBase();
	Actions actions = new Actions(driver);

	// Page Factory - OR

	@FindBy(xpath = "//a[contains(text(), 'Dit is Cloudwise') and @class='sf-with-ul']")
	WebElement ditIsCloudwise;

	@FindBy(xpath = "//h3[text()='All Cloudwisers']")
	WebElement alleCloudwiser;

	@FindBy(xpath = "//span[text()='Meet our team']")
	WebElement meetOurTeamBtn;
	
	// Initializing the Page Objects
	public CloudwisePage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	// Actions
	
	public void clickDitIsCloudwise() throws IOException {
		TestUtil.waitForElementToBeVisible(ditIsCloudwise);
		ditIsCloudwise.click();
}
	

	public AlleCloudwisersPage clickAlleCloudwisersBtn() throws InterruptedException, IOException {
		
		TestUtil.scrollDown(alleCloudwiser);	
		TestUtil.waitForElementToBeVisible(alleCloudwiser);
		alleCloudwiser.click();
		TestUtil.waitForElementToBeVisible(meetOurTeamBtn);
		meetOurTeamBtn.click();
		
		return new AlleCloudwisersPage();
	}
}
