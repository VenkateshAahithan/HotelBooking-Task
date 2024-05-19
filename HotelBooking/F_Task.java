package com.HotelBooking;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class F_Task {
	
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
			WebElement gt = driver.findElement(By.xpath("//a[@data-testid='username']"));
			String tt = gt.getText();
			System.out.println(tt);
			
			//Print Explore Hotel
			WebElement gettext = driver.findElement(By.xpath("//h5[text()='Explore Hotels']"));
			String text = gettext.getText();
			System.out.println(text);
			
			//Search Hotel
			WebElement State = driver.findElement(By.xpath("//select[@id='state']"));
			Select selectState=new Select(State);
			selectState.selectByValue("Tamil Nadu");
			driver.findElement(By.xpath("//span[text()='Select City *']")).click();
			WebElement Madurai = driver.findElement(By.xpath("//li[text()='Madurai']"));
			Madurai.click();
			driver.findElement(By.xpath("//textarea[@type='search']")).click();
			driver.findElement(By.xpath("//li[text()='Standard']")).click();
			driver.findElement(By.xpath("//textarea[@type='search']")).click();
			driver.findElement(By.xpath("//li[text()='Deluxe']")).click();
			driver.findElement(By.xpath("//textarea[@type='search']")).click();
			driver.findElement(By.xpath("//li[text()='Suite']")).click();
			driver.findElement(By.xpath("//textarea[@type='search']")).click();
			driver.findElement(By.xpath("//li[text()='Luxury']")).click();
			driver.findElement(By.xpath("//textarea[@type='search']")).click();
			driver.findElement(By.xpath("//li[text()='Studio']")).click();
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
	
			
			
			//click
			driver.findElement(By.xpath("//label[@for='value_phtol']")).click();
			
			List<WebElement> priceElements = driver.findElements(By.xpath("//strong[@class='total-prize']"));

			// Retry logic
			int maxAttempts = 3;
			int attempt = 0;
			while (attempt < maxAttempts) {
			    try {
			        // Find all price elements again
			        List<WebElement> priceElements1 = driver.findElements(By.xpath("//strong[@class='total-prize']"));

			        // Store prices in a list
			        List<Double> originalPrices = new ArrayList<>();
			        for (WebElement priceElement : priceElements1) {
			            String priceText = priceElement.getText().replaceAll("[^0-9.]", ""); // Remove non-numeric characters
			            double price = Double.parseDouble(priceText);
			            originalPrices.add(price);
			        }

			        // Sort prices in descending order
			        List<Double> sortedPrices = new ArrayList<>(originalPrices);
			        sortedPrices.sort(Collections.reverseOrder());

			        // Check if prices are sorted in descending order
			        boolean isSortedDescending = originalPrices.equals(sortedPrices);

			        // Print original prices
			        System.out.println("Original Prices:");
			        for (double price : originalPrices) {
			            System.out.println("Price: " + price);
			        }

			        // Print whether prices are sorted in descending order or not
			        System.out.println("Prices are sorted in descending order: " + isSortedDescending);
			        
			        // Exit the loop if everything succeeded
			        break;
			    } catch (StaleElementReferenceException e) {
			        // Refresh price elements
			        priceElements = driver.findElements(By.xpath("//strong[@class='total-prize']"));
			        attempt++;
			    }
			}

			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
}}
