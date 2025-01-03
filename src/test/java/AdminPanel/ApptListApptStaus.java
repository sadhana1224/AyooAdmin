package AdminPanel;//working

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ApptListApptStaus {
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
		//filter by-Appt status
		sel.selectByIndex(5);
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement DD=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("((//div[@class='appointment-filter-inputContainer'])//select)[2]")));
		Actions act=new Actions(driver);
		act.doubleClick(DD).perform();
		Select appt=new Select(DD);
		appt.selectByIndex(1); //change the number for filters--completed,cancelled,no show, booked
	}

}
