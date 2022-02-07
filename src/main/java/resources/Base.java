package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

		public Properties prop;
		public WebDriver driver;
		public WebDriver initilizebrowser() throws Exception
		{
			
			prop=new Properties();
			FileInputStream fis = new FileInputStream("./src/main/java/resources/data.properties");
			prop.load(fis);
			String browserStringName=prop.getProperty("Browser");
			System.out.println(browserStringName);
			
			if(browserStringName.equals("chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver= new ChromeDriver();
				driver.get(prop.getProperty("Url"));
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				
			}
			return driver;
		}
		
		public String CaptureScreenShot(String TestMethodname,WebDriver driver) throws Exception
		{
			System.out.println(" In Screenshot method "+TestMethodname);
			TakesScreenshot ts = (TakesScreenshot)driver;
			File file= ts.getScreenshotAs(OutputType.FILE);
			
			String ScreenshotPath=System.getProperty("user.dir")+"\\Screenshot\\"+TestMethodname+".png";
			System.out.println("------------------" + ScreenshotPath);
			FileUtils.copyFile(file, new File(ScreenshotPath));
			System.out.println("------------After screenshot taken Path");

			return ScreenshotPath;
				
			
		}
}
