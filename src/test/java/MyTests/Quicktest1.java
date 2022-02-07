package MyTests;

import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.PageObjects.Academy.radiobutton;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import resources.Base;

public class Quicktest1 extends Base{
	ExtentSparkReporter reporter;
	ExtentReports extent;
	ExtentTest Test;
	public WebDriver driver;

	@BeforeTest
	public void OpenBrowser() throws Exception
	{
		/*
		 * String path =System.getProperty("user.dir")+"\\reports\\index.html";
		 * 
		 * ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		 * 
		 * reporter.config().setReportName("Web Automation Results");
		 * 
		 * reporter.config().setDocumentTitle("Test Results");
		 * 
		 * extent =new ExtentReports();
		 * 
		 * extent.attachReporter(reporter);
		 * 
		 * extent.setSystemInfo("Tester", "Rahul Shetty");
		 */

		
				driver=initilizebrowser();
	}
	
	
	@Test(enabled=true)
	public void radioButtun() throws Exception
	{
		radiobutton r = new radiobutton(driver);
		
		if((r.getRadio1()).isDisplayed())
		{
		
			Assert.assertEquals(true, true,"Radio button 1 is Present");
			r.getRadio1().click();
		
		}
		if(r.getRadio2().isDisplayed())
		{
			Assert.assertEquals(true, true,"Radio button 2 is Present");
		r.getRadio2().click();
		}
		if(r.getRadio3().isDisplayed())
		{
			Assert.assertEquals(true, true,"Radio button 3 is Present");
		r.getRadio3().click();
		
		//Assert.assertFalse(true);
		
		}
	}
	
	@Test(enabled=true)
	public void suggestiveTestBox() throws Exception
	{
		
		if(driver.findElement(By.id("autocomplete")).isDisplayed())
		{
		driver.findElement(By.id("autocomplete")).sendKeys("IN");
		
		
		int size=driver.findElements(By.xpath("//div[@class='ui-menu-item-wrapper']")).size();
		
		for(int i=0;i<size;i++)
		{
			String Text=driver.findElements(By.xpath("//div[@class='ui-menu-item-wrapper']")).get(i).getText();
			if(Text.equalsIgnoreCase("Dominica"))
			{
				driver.findElements(By.xpath("//div[@class='ui-menu-item-wrapper']")).get(i).click();
			}
			
		}

		
		}
	}
	
	@Test(enabled=true)
	public void selectDropdown()
	{
		
		WebElement dd=driver.findElement(By.id("dropdown-class-example"));
		Select sel= new Select(dd);
		sel.selectByIndex(1);
		sel.selectByValue("option2");
		sel.selectByVisibleText("Option3");
		
	}
	
	@Test
	public void checkbox()
	{
		driver.findElement(By.id("checkBoxOption1")).click();
		
	}
@AfterTest
public void closbrowser()
{
	driver.close();
	//extent.flush();
	
}



}
