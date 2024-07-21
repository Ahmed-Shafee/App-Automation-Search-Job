package search.job.gui;

import java.awt.desktop.PrintFilesEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MainProgramTests 
{

	
	  public static void main(String[] args) throws Exception 
	  {
	  
			  // TODO Auto-generated method stub
			/*
			 * CreatSearchOpt creatSearch=new CreatSearchOpt(); SearchJob
			 * searchjob=creatSearch.getSearchOption(); searchjob.search();
			 * 
			 * 
			 * 
			 */
		  	System.setProperty("webdriver.chrome.driver", "Drivers//chromedriver.exe");
		  	WebDriver driver = null;
		   try {
			  	 driver = new ChromeDriver();

		} catch (Exception e) {
			// TODO: handle exception
		}

	       try {
			    driver.get("https://www.google.com");

		} catch (Exception e) {
			// TODO: handle exception
		}

			/*
			 * driver.getTitle();
			 * 
			 * driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
			 * 
			 * WebElement textBox = driver.findElement(By.name("my-text")); WebElement
			 * submitButton = driver.findElement(By.cssSelector("button"));
			 * 
			 * textBox.sendKeys("Selenium"); submitButton.click();
			 * 
			 * WebElement message = driver.findElement(By.id("message")); message.getText();
			 */
	        driver.wait(10000000);
	        driver.quit();
			  	 	
	  
	  }
	 	  	
	 
}




	


