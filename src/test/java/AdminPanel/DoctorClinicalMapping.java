package AdminPanel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DoctorClinicalMapping {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		driver=new ChromeDriver();
		driver.get("https://uat.ayoo.care/ayooadmin");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("username")).sendKeys("admin@ayoo.care");
		driver.findElement(By.id("password")).sendKeys("ayoo-admin-uat!"); //AdW!n@Ay00 //ayoo-admin-uat!

		driver.findElement(By.id("loginbtn")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Doctor Clinic Mapping')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'View Mapping')]")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement doc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Select...')]")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Click using JavaScript
		js.executeScript("arguments[0].click();", doc);

		WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div//div[contains(text(),'Demo psyc')]")));
		js.executeScript("arguments[0].click();", option);
	}

}
