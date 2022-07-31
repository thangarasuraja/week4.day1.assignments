package week4.day1assigments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundTask {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		//Launch the chrome browser
		ChromeDriver driver=new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Load the URL
		driver.get("http://www.leafground.com/pages/Window.html");

		//Maximize the window
		driver.manage().window().maximize();

		//get the parent window
		String parentWindowHandle = driver.getWindowHandle();

		//click the open home button

		driver.findElement(By.id("home")).click();

		//sleep

		Thread.sleep(5000);

		//Window navigation
		Set<String> windowHandles=driver.getWindowHandles();

		List<String> windowHandlesList=new ArrayList<String>(windowHandles);

		String secondWindowHandle=windowHandlesList.get(1);

		driver.switchTo().window(secondWindowHandle);


		//close the second window

		driver.close();

		//sleep

		Thread.sleep(5000);

		//navigate to parent window

		driver.switchTo().window(parentWindowHandle);

		//click the open mutiple window button

		driver.findElement(By.xpath("//button[text()='Open Multiple Windows']")).click();


		//sleep
		Thread.sleep(2000);



		//Count the number of windows


		Set<String> totalWindowHandles=driver.getWindowHandles();

		int totalWindows=totalWindowHandles.size();

		System.out.println("Total number of opened windows :" +totalWindows);

		//List<String> totalWindowHandlesList=new ArrayList<String>(totalWindowHandles);


		//close all the windows

		driver.quit();

		//sleep

		Thread.sleep(5000);

		//initiate the parent window again


		WebDriverManager.chromedriver().setup();
		//Launch the chrome browser
		ChromeDriver driver2=new ChromeDriver();

		driver2.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Load the URL
		driver2.get("http://www.leafground.com/pages/Window.html");

		//Maximize the window
		driver2.manage().window().maximize();

		//get the parent window
		String parentWindowHandle2 = driver2.getWindowHandle();

		//open do not close me window

		driver2.findElement(By.id("color")).click();

		//Window navigation
		Set<String> windowHandles3=driver2.getWindowHandles();

		List<String> windowHandlesList3=new ArrayList<String>(windowHandles3);

		System.out.println(windowHandlesList3.size());

		String secondWindowHandle3=windowHandlesList3.get(1);

		driver2.switchTo().window(secondWindowHandle3);

		//close the parent window

		driver2.close();

		//navigate to parent

		driver2.switchTo().window(parentWindowHandle2);


		//sleep to check the output


		Thread.sleep(5000);


		//Parent window close

		driver2.close();

		//sleep to check the output to check the output


		Thread.sleep(5000);

		//final quite

		driver2.quit();



		//Wait for 5 seconds task 




		//initiate the parent window again


		WebDriverManager.chromedriver().setup();
		//Launch the chrome browser
		ChromeDriver driver3=new ChromeDriver();

		driver3.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Load the URL
		driver3.get("http://www.leafground.com/pages/Window.html");

		//Maximize the window
		driver3.manage().window().maximize();
		
		//click the wait for 5 second button
		
		driver3.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();
		
		
		//sleep
		
		Thread.sleep(5000);
		
		//driver quite
		
		driver3.quit();







	}

}
