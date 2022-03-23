package com.secondtask.testcases;

import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.secondtask.base.TestBase;
import com.secondtask.pages.AlleCloudwisersPage;
import com.secondtask.pages.CloudwisePage;
import com.secondtask.pages.CodeshakePage;

public class AlleCloudwisersPageTest extends TestBase {
	CodeshakePage codeshakePage;
	CloudwisePage cloudwisePage;
	AlleCloudwisersPage alleCloudwisersPage;

	public AlleCloudwisersPageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		initialization();
		codeshakePage = new CodeshakePage();
		cloudwisePage = codeshakePage.clickPayThemVisitLink();
		alleCloudwisersPage = cloudwisePage.clickAlleCloudwisersBtn();
	}

	@Test
	public void duplicateEmployeesNames() throws InterruptedException {
		alleCloudwisersPage.createDepartmentMap();
		alleCloudwisersPage.duplicateEmployees();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
