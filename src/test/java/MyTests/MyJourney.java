package MyTests;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyJourney {
	public static void main(String[] args) throws InterruptedException, IOException {
		
		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		  driver.get("https://www.cleartrip.com/");
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 	
		  driver.findElement(By.xpath("//h4[contains(text(),'From')]/parent::*/div//input")).sendKeys("BOM");
			 driver.findElement(By.xpath("//h4[contains(text(),'From')]/parent::*/div//input")).sendKeys(Keys.TAB);
			
			
			int size=driver.findElements(By.xpath("//li[@class='ls-reset br-4 w-100p px-2 dropdown__item c-neutral-900 fs-3 hover:bg-secondary-500 hover:c-white c-pointer']")).size();
			System.out.println("Size is "+size);
			for(int i=0;i<size;i++)
			{
				String text=driver.findElements(By.xpath("//li[@class='ls-reset br-4 w-100p px-2 dropdown__item c-neutral-900 fs-3 hover:bg-secondary-500 hover:c-white c-pointer']")).get(i).getText();
				System.out.println("Text is "+text);
				if(text.equalsIgnoreCase("Mumbai, IN - Chatrapati Shivaji Airport (BOM)"))
				{
					driver.findElements(By.xpath("//li[@class='ls-reset br-4 w-100p px-2 dropdown__item c-neutral-900 fs-3 hover:bg-secondary-500 hover:c-white c-pointer']")).get(i).click();
				}
					
		
			}
		
		
		
		driver.findElement(By.xpath("//h4[contains(text(),'To')]/parent::*/div//input")).sendKeys("Del");
		driver.findElement(By.xpath("//h4[contains(text(),'To')]/parent::*/div//input")).sendKeys(Keys.TAB);
		
		int size1=driver.findElements(By.xpath("//p[@class='to-ellipsis o-hidden ws-nowrap c-inherit fs-3']")).size();
		System.out.println("Size is "+size1);
		for(int j=0;j<size1;j++)
		{
			String text1=driver.findElements(By.xpath("//p[@class='to-ellipsis o-hidden ws-nowrap c-inherit fs-3']")).get(j).getText();
			System.out.println("Text is "+text1);
			if(text1.equalsIgnoreCase("New Delhi, IN - Indira Gandhi Airport (DEL)"))
			{
				driver.findElements(By.xpath("//p[@class='to-ellipsis o-hidden ws-nowrap c-inherit fs-3']")).get(j).click();
			}
				
	
		}
		

	
		
		
		
	
		
		
		
		
	}

}
