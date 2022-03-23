package com.secondtask.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import com.secondtask.base.TestBase;
import com.secondtask.util.TestUtil;

public class AlleCloudwisersPage extends TestBase {
	TestBase base = new TestBase();

	// Page Factory - OR

	@FindBy(xpath = "//div[@id='fws_623a98579a83a']")
	WebElement departmentsRow1;
	
	@FindBy(xpath = "//div[@id='fws_623a98579bd8c']")
	WebElement departmentsRow2;
	
	@FindBy(xpath = "//div[@id='fws_623a98579d053']")
	WebElement departmentsRow3;
	

	Map<String, List<String>> employeeMap = new HashMap<String, List<String>>();
	List<String> employeeList = new ArrayList<String>();

	public AlleCloudwisersPage() throws IOException {
		super();
	}

	public void createDepartmentMap() throws InterruptedException {
		
		TestUtil.scrollDown(departmentsRow1);
		List<WebElement> departmentRow1 =driver.findElements(By.xpath("//div[@id='fws_623a98579a83a']"));
		
		TestUtil.scrollDown(departmentsRow2);
		List<WebElement> departmentRow2 = driver.findElements(By.xpath("//div[@id='fws_623a98579bd8c']"));
		
		TestUtil.scrollDown(departmentsRow3);
		List<WebElement> departmentRow3 = driver.findElements(By.xpath("//div[@id='fws_623a98579d053']"));
		
		List<WebElement> departments = Stream.of(departmentRow1, departmentRow2, departmentRow3)
                .flatMap(Collection::stream)
                .collect(Collectors.toList()); 
		
		
		Assert.assertEquals(departments.size(), 9);
		

		for (int i =1 ; i <= departments.size(); i++) {
			WebElement departmentElement = driver.findElement(By.xpath(
					"(//div[@id='core-features']/following-sibling::div[not(contains(@style,'bottom'))]//div[contains(@class,'column_container')])["
							+ i + "]"));
			TestUtil.moveToElement(departmentElement);
			departmentElement.click();
            
		    
			driver.findElement(By.xpath("(//span[contains(text(),'Wie zijn wij')])[" + i + "]")).click();

			List<WebElement> employeeElementList = driver.findElements(By.tagName("h3"));
			List<String> employeeNameList = new ArrayList<String>();
			String departmentName = driver.findElement(By.tagName("h1")).getText();

			for (WebElement employee : employeeElementList) {
				employeeNameList.add(employee.getText().trim());
			}
			employeeMap.put(departmentName, employeeNameList);
			TestUtil.navigateToPreviousPage();
		}
		
		
		for (Iterator<Entry<String, List<String>>> iterator = employeeMap.entrySet().iterator(); iterator.hasNext();) {
			Entry<String, List<String>> entry = iterator.next();
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
	

	public void duplicateEmployees() {
		for (List<String> value : employeeMap.values()) {
			employeeList.addAll(value);
		}
		
		Set<String> duplicateEmployees = new HashSet<String>();
		for (String employeeName : employeeList) {
			if (Collections.frequency(employeeList, employeeName) > 1) {
				duplicateEmployees.add(employeeName);
			}
		}
		System.out.println("Employee list: " + employeeList);
		System.out.println("Duplicate employee list: " + duplicateEmployees);
	}
}
