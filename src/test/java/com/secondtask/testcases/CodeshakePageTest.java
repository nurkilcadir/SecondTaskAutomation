package com.secondtask.testcases;

import java.io.IOException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.secondtask.base.TestBase;
import com.secondtask.pages.CodeshakePage;

public class CodeshakePageTest extends TestBase {
	CodeshakePage codeshakePage;

	public CodeshakePageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		codeshakePage = new CodeshakePage();
	}

	@Test
	public void clickPayThemVisitLink() throws IOException, InterruptedException {
		codeshakePage.clickPayThemVisitLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
