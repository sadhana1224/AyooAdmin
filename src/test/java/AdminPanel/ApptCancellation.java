package AdminPanel;//working

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ApptCancellation {
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
		//filter by-Cancellation
		sel.selectByIndex(1);
		
		WebElement filter=driver.findElement(By.xpath("((//div[@class='booking-status-container'])//select)[1]"));
		filter.click();
		Select sel1=new Select(filter);
		sel1.selectByIndex(1);
		
		//Select the reason
		WebElement reason=driver.findElement(By.xpath("//div[@class='reason-container']//select"));
		reason.click();
		Select sel2=new Select(reason);
		sel2.selectByIndex(8);
		//enter the reason
		driver.findElement(By.xpath("//div[@class='comments-container']//input")).sendKeys("Test");
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
		
	}
}
