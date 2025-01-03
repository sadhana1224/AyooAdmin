package AdminPanel;//Working

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ApptListPhNum {
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
		driver.findElement(By.xpath("(//span[contains(text(),'Appointments')])[3]")).click();
		Select sel=new Select(driver.findElement(By.xpath("//select[@data-testid='filter-selector']")));
		//filter by-Phonenumber
		sel.selectByIndex(4);
		driver.findElement(By.xpath("//input[@placeholder='Enter Mobile']")).sendKeys("6202878654");
		//Clear Filter
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//button[contains(text(),'Clear Filter')]")).click();

}
}
