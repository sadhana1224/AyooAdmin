package AdminPanel;    //Working

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AyooAdminAddUser {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		driver=new ChromeDriver();
		driver.get("https://dev.ayoo.care/ayooadmin");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("username")).sendKeys("admin@ayoo.care");
		driver.findElement(By.id("password")).sendKeys("AdW!n@Ay00"); //AdW!n@Ay00 //ayoo-admin-uat!

		driver.findElement(By.id("loginbtn")).click();

		//Dashboard-- Add User
		driver.findElement(By.xpath("//button[contains(text(),'Add User')]")).click();
		driver.findElement(By.xpath("//input[@name ='firstname']")).sendKeys("sej");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("W");
		driver.findElement(By.xpath("//input[@placeholder='DD-MM-YYYY']")).sendKeys("05/25/1985");
		Select sel=new Select(driver.findElement(By.name("gender")));
		sel.selectByIndex(1);
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("sejore7579@datingel.com");
		driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys("5630094385");
		driver.findElement(By.xpath("//input[@name='address']")).sendKeys("Hsr");
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys("Karnataka");
		driver.findElement(By.xpath("//input[@name='pincode']")).sendKeys("566054");
		driver.findElement(By.xpath("//input[@name='country']")).sendKeys("India");


		driver.findElement(By.xpath("//button[contains(text(),'Add')]")).click();
		//Select sel1=new Select(driver.findElement(By.xpath("//select[@id='maritalstatus']")));
		//sel1.selectByIndex(1);






	}
}
