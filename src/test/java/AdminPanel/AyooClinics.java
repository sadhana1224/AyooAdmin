package AdminPanel; //working

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AyooClinics {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		driver = new ChromeDriver();
		driver.get("https://uat.ayoo.care/ayooadmin");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("username")).sendKeys("admin@ayoo.care");
		driver.findElement(By.id("password")).sendKeys("ayoo-admin-uat!"); //AdW!n@Ay00 //ayoo-admin-uat!

		driver.findElement(By.id("loginbtn")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Facilities')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'AYOO Clinics ')]")).click();
		Thread.sleep(2000);

		//Add Clinic Details
		driver.findElement(By.xpath("(//div//img)[2]")).click();
		Thread.sleep(2000);
		//check Pop up is cancelled or not
		driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div//img)[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div//input)[1]")).sendKeys("Ayoo Care New");
		driver.findElement(By.xpath("//input[@type='number']")).sendKeys("4563217890");
		//we can change the City value bengaluru/Mumbai
		driver.findElement(By.xpath("//select//option[@value='bengaluru']")).click();
		driver.findElement(By.xpath("//div//textarea")).sendKeys("HBR Layout, Bangalore");

		//Clinic Contact Person Details
		driver.findElement(By.xpath("(//div//input)[3]")).sendKeys("Anushree");
		driver.findElement(By.xpath("(//div//input)[4]")).sendKeys("hejahe4542@evnft.com");
		driver.findElement(By.xpath("(//div//input)[5]")).sendKeys("8945612375");

		driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();


	}

}		

