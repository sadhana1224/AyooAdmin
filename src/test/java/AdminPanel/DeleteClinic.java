package AdminPanel;// Working

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteClinic {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver=new ChromeDriver();
		driver.get("https://uat.ayoo.care/ayooadmin/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("username")).sendKeys("sadhana@ayoo.care");
		driver.findElement(By.id("password")).sendKeys("sadhana@ayoo");
		driver.findElement(By.id("loginbtn")).click();

		driver.findElement(By.xpath("(//span[@class=\"pro-icon\"]/ancestor::div[@class='pro-inner-item'])[7]")).click();
		driver.findElement(By.xpath("(//span[@class=\"pro-item-content\"]/ancestor::li[@class='pro-menu-item'])[11]")).click();
		Thread.sleep(60);
		//delete new clinic
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i[@class='fa fa-trash-o p-r-10']/parent::a)[2]")));
		element.click();
		
		Alert alert = driver.switchTo().alert();
		Thread.sleep(5);
		alert.dismiss(); //change to accept-->if need

	}

}
