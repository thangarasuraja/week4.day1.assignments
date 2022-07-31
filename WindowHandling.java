package week4.day1assigments;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		//Launch the chrome browser
		ChromeDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Load the URL
		driver.get("http://leaftaps.com/opentaps/control/login");

		//Maximize the window
		driver.manage().window().maximize();

		//Enter the user name
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");

		//Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		//Click the Login button
		driver.findElement(By.className("decorativeSubmit")).click();

		//click the CRM/SFA link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//click the Leads tab
		driver.findElement(By.linkText("Contacts")).click();
		
		//click Merge contact
		
		driver.findElement(By.xpath("//div[@class='frameSectionBody']/ul/li[4]/a")).click();
		
		//get the parent window
		
		String parentWindowHandle = driver.getWindowHandle();
		
		//click the widget
		
		driver.findElement(By.xpath("//span[text()='From Contact']/following::img")).click();
		
		//navigate to second window
		
		Set<String> windowHandles=driver.getWindowHandles();
		
		List<String> windowHandlesList=new ArrayList<String>(windowHandles);
		
		String secondWindowHandle=windowHandlesList.get(1);
		
		driver.switchTo().window(secondWindowHandle);
		
		//click the first contact
		
		driver.findElement(By.xpath("//a[@class='linktext']")).click();
		
		//switch to parent window
		
		driver.switchTo().window(parentWindowHandle);
		
		//click the Widget of To Contact
		
		driver.findElement(By.xpath("//span[text()='To Contact']/following::img")).click();
		
		//navigate to second window 2
		
		Set<String> windowHandles2=driver.getWindowHandles();
		
		List<String> windowHandlesList2=new ArrayList<String>(windowHandles2);
		
		String secondWindowHandle2=windowHandlesList2.get(1);
		
		driver.switchTo().window(secondWindowHandle2);
		
		//click the second contact
		
		driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a)[2]")).click();
		
		//switch to parent window
		
		driver.switchTo().window(parentWindowHandle);
		
		//click the Merge button
		
		driver.findElement(By.className("buttonDangerous")).click();
		
		//Alert
		
		//switch the screen
		Alert alert = driver.switchTo().alert();
		
		//accept the alert
		alert.accept();
		
		//verify the title 
		
		String title = driver.getTitle();
		
		//print the title
		
		System.out.println(title);
		
		//close the browser
		
		driver.close();
		
		
		
		
		
		

	}

}
