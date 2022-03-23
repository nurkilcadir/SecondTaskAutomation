package com.secondtask.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.annotations.BeforeMethod;
import com.secondtask.base.TestBase;
import com.secondtask.pages.CloudwisePage;
import com.secondtask.pages.CodeshakePage;

public class CloudwisePageTest extends TestBase {
	CodeshakePage codeshakePage;
	CloudwisePage cloudwisePage;

	public CloudwisePageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();
		codeshakePage = new CodeshakePage();
		cloudwisePage = codeshakePage.clickPayThemVisitLink();
	}

	@Test
	public void clickAlleCloudwisersPage() throws InterruptedException, IOException {
		cloudwisePage.clickAlleCloudwisersBtn();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
