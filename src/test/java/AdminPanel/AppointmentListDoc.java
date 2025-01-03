package AdminPanel;//working

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppointmentListDoc {

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
		//filter by-Doctor name
		sel.selectByIndex(1);
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		WebElement DD=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//div[@class='appointment-filter-inputContainer'])//select)[2]")));
		DD.click();
		Select docname=new Select(DD);
		docname.selectByIndex(1);

		//Clear Filter
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//button[contains(text(),'Clear Filter')]")).click();

		Thread.sleep(5000);
		//driver.quit();
	}

}
