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
	WebElement ditIsCloudwiseMenu;

	@FindBy(xpath = "//li[@id='menu-item-6380']")
	WebElement alleCloudwiserSubItem;

	// Initializing the Page Objects
	public CloudwisePage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	// Actions

	public AlleCloudwisersPage clickAlleCloudwisersBtn() throws InterruptedException, IOException {
		
		TestUtil.waitForElementToBeVisible(ditIsCloudwiseMenu);
		actions.moveToElement(ditIsCloudwiseMenu).perform();
		TestUtil.waitForElementToBeVisible(ditIsCloudwiseMenu);
		actions.moveToElement(alleCloudwiserSubItem).perform();
		alleCloudwiserSubItem.click();

		return new AlleCloudwisersPage();
	}

}
