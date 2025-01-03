package AdminPanel;//working

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ApptListReschedule {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		driver=new ChromeDriver();
		driver.get("https://dev.ayoo.care/ayooadmin");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("username")).sendKeys("admin@ayoo.care");
		driver.findElement(By.id("password")).sendKeys("AdW!n@Ay00"); //AdW!n@Ay00 //ayoo-admin-uat!

		driver.findElement(By.id("loginbtn")).click();
		driver.findElement(By.xpath("(//span[contains(text(),'Appointments')])[1]")).click();
		driver.findElement(By.xpath("(//span[contains(text(),'Appointments')])[3]")).click();
		Select sel=new Select(driver.findElement(By.xpath("//select[@data-testid='filter-selector']")));
		//filter by-Reschedule
		sel.selectByIndex(0);
		
		WebElement filter=driver.findElement(By.xpath("((//div[@class='booking-status-container'])//select)[1]"));
		filter.click();
		Select sel1=new Select(filter);
		sel1.selectByIndex(3);
		//Appointment date
		driver.findElement(By.xpath("//input[@id='apptslot']")).click();
		driver.findElement(By.xpath("//div[contains(text(),'25')]")).click();
		//Time slot
		WebElement timeslot=driver.findElement(By.xpath("//select[@id='timeslot']"));
		timeslot.click();
		Select sel2=new Select(timeslot);
		sel2.selectByIndex(1);
		driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
		
}
}
