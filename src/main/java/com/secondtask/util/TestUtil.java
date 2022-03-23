package com.secondtask.util;

import java.io.IOException;
import java.util.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import com.secondtask.base.TestBase;

public class TestUtil extends TestBase {

	public static final long PAGE_LOAD_TIMEOUT = 10;
	public static final long IMPLICIT_WAIT = 10;

	public TestUtil() throws IOException {
		super();
	}

	public static WebElement waitForElementToBeVisible(WebElement element) throws IOException {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).ignoring(StaleElementReferenceException.class)
				.ignoring(NoSuchElementException.class);

		try {
			// wait.until(ExpectedConditions.invisibilityOfElementLocated(element);
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			System.out.println("Element Not found trying again" + element.toString());
			e.printStackTrace();
		}
		return element;
	}

	public static void scrollDown(WebElement element) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
		Thread.sleep(4000);
	}

	public static void moveToElement(WebElement element) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(4000);
	}

	public static void navigateToPreviousPage() {
		driver.navigate().back();
	}
}
