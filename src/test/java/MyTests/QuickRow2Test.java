package MyTests;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.Base;

public class QuickRow2Test extends Base{
	public WebDriver driver;
	
	
	
	
	
	  @BeforeTest public void OpenBrowser() throws Exception {
	  driver=initilizebrowser(); }
	 
	 
	
	
	@Test(enabled=true)
	public void openwindow()
	{
		driver.findElement(By.id("openwindow")).click();
		String parent=driver.getWindowHandle();
		Set<String> allwindows=driver.getWindowHandles();
		
	System.out.println("Total window - "+allwindows.size());
	

	
	for(String child:allwindows)
	{
		
		if(!parent.equalsIgnoreCase(child)) {
			driver.switchTo().window(child);

			driver.findElement(By.xpath("//a[contains(text(),'Videos')]")).click();
			driver.manage().window().maximize();
			
		}
			
	}
		
		
		
		
	}
	
	@Test
	public void Alerts()
	{
		driver.findElement(By.id("alertbtn")).click();
		String text=driver.switchTo().alert().getText();
		System.out.println(text);
		driver.switchTo().alert().accept();
	}

	
	  @AfterTest public void closbrowser() { 
		  driver.quit(); //extent.flush();
	  
	  }
	 
}
