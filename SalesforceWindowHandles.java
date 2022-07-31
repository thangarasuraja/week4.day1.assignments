package week4.day1assigments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesforceWindowHandles {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		//Launch the chrome browser
		ChromeDriver driver=new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Load the URL
		driver.get("https://login.salesforce.com/");

		//Maximize the window
		driver.manage().window().maximize();


		driver.findElement(By.id("username")).sendKeys(" ramkumar.ramaiah@testleaf.com ");


		driver.findElement(By.id("password")).sendKeys(" Password$123 ");


		driver.findElement(By.id("Login")).click();

		Thread.sleep(5000);

		//get the parent window

		String parentWindowHandle = driver.getWindowHandle();

		//click learn more option 

		driver.findElement(By.xpath("(//span[@class=' label bBody'])[2]")).click();

		//navigate to second window

		Set<String> windowHandles=driver.getWindowHandles();

		List<String> windowHandlesList=new ArrayList<String>(windowHandles);

		String secondWindowHandle=windowHandlesList.get(1);

		driver.switchTo().window(secondWindowHandle);
		
		
		//click confirm
		
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
		Thread.sleep(10000);
		
		//get the title
		
		String title=driver.getTitle();
		
		System.out.println(title);
		
		
		//navigate to the parent window
		
		driver.switchTo().window(parentWindowHandle);
		
		//close the browser
		
		driver.quit();

	}

}
