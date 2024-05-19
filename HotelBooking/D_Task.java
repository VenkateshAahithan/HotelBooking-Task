package com.HotelBooking;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class D_Task {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		
		//Login
		driver.get("https://www.omrbranch.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.id("email")).sendKeys("venkateshsel99@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("Selva@kamali1");
		driver.findElement(By.xpath("//button[@value='login']")).click();
	
				//Print Welcome UserName
				WebElement gettext = driver.findElement(By.xpath("//a[@data-testid='username']"));
				String text = gettext.getText();
				System.out.println(text);
				//Search Hotel
				WebElement State = driver.findElement(By.xpath("//select[@id='state']"));
				Select selectState=new Select(State);
				selectState.selectByValue("Tamil Nadu");
				driver.findElement(By.xpath("//span[text()='Select City *']")).click();
				WebElement Madurai = driver.findElement(By.xpath("//li[text()='Madurai']"));
				Madurai.click();
				String[] options = {"Standard"};
				WebElement dropdown = driver.findElement(By.xpath("//textarea[@type='search']"));
				for (String option : options) {
				dropdown.click();
				WebElement optionElement = driver.findElement(By.xpath("//li[text()='" + option + "']"));
				optionElement.click();
				}
				driver.findElement(By.xpath("//input[@name='check_in']")).click();
				driver.findElement(By.xpath("//a[text()='19']")).click();
				driver.findElement(By.xpath("//input[@name='check_out']")).click();
				driver.findElement(By.xpath("//a[text()='22']")).click();
				WebElement rooms = driver.findElement(By.xpath("//select[@id='no_rooms']"));
				Select selectrooms=new Select(rooms);
				selectrooms.selectByValue("3");
				WebElement Adult = driver.findElement(By.xpath("//select[@id='no_adults']"));
				Select SelectAdult=new Select(Adult);
				SelectAdult.selectByValue("3");
				driver.findElement(By.xpath("//input[@id='no_child']")).sendKeys("2");
				//Frame
				driver.switchTo().frame("hotelsearch_iframe");
				WebElement search = driver.findElement(By.xpath("//button[@class='btn filter_btn']"));
				search.click();
				
				//Print all Price elements
				List<WebElement> priceElements = driver.findElements(By.xpath("//strong[@class='total-prize']"));
				for (int i = 0; i < priceElements.size(); i++) {
					 WebElement priceElement = priceElements.get(i);
					 String price = priceElement.getText();
					 System.out.println("Price: " + price);
				}
				// Find all price elements
		        List<WebElement> priceElements1 = driver.findElements(By.xpath("//strong[@class='total-prize']"));

		        // Store prices in a list
		        List<Double> prices = new ArrayList<>();
		        for (WebElement priceElement : priceElements1) {
		            String priceText = priceElement.getText().replaceAll("[^0-9.]", ""); // Remove non-numeric characters
		            double price = Double.parseDouble(priceText);
		            prices.add(price);
		        }

		        // Sort prices in ascending order
		        Collections.sort(prices);

		        // Print sorted prices
		        System.out.println("Prices in ascending order:");
		        for (double price : prices) {
		            System.out.println(price);
		        }

	
	
	}}
