package AdminPanel;//working

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AllAppointment {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		driver=new ChromeDriver();
		driver.get("https://uat.ayoo.care/ayooadmin");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("username")).sendKeys("admin@ayoo.care");
		driver.findElement(By.id("password")).sendKeys("ayoo-admin-uat!"); //AdW!n@Ay00 //ayoo-admin-uat!

		driver.findElement(By.id("loginbtn")).click();
		driver.findElement(By.xpath("(//span[contains(text(),'Appointments')])[1]")).click();
		Thread.sleep(5);
			//All Appointments
		driver.findElement(By.xpath("(//span[contains(text(),'Appointments')])[2]")).click();
		Thread.sleep(5000);

		//Next day appointments
		driver.findElement(By.xpath("//button[contains(text(),'Next')]")).click();
		Thread.sleep(3000);
		//Previous days appointments
		driver.findElement(By.xpath("//button[contains(text(),'Prev')]")).click();

	}

}
