package com.secondtask.pages;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.secondtask.base.TestBase;
import com.secondtask.util.TestUtil;

public class CodeshakePage extends TestBase {

	// Page Factory - OR
	@FindBy(xpath = "//*[@id=\"comp-knd6ow3j\"]/a/span")
	WebElement payThemVisitLink;

	// Initializing the Page Objects
	public CodeshakePage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	// Actions
	public CloudwisePage clickPayThemVisitLink() throws IOException, InterruptedException { 
		
		TestUtil.waitForElementToBeVisible(payThemVisitLink);
		payThemVisitLink.click();
		
     	return new CloudwisePage();
	}
}
