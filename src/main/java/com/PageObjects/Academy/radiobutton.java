package com.PageObjects.Academy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class radiobutton {
	
	public WebDriver driver;
	
	By radio1=By.xpath("//input[@value='radio1']");
	By radio2=By.xpath("//input[@value='radio2']");
	By radio3=By.xpath("//input[@value='radio3']");
	
	public radiobutton(WebDriver driver) {
		
		this.driver=driver;

	}

	public WebElement getRadio1() {
		return driver.findElement(radio1);
	}
	public WebElement getRadio2() {
		return driver.findElement(radio2);
	}
	public WebElement getRadio3() {
		return driver.findElement(radio3);
	}
	

}
