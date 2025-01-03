package AdminPanel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DoctorClinicMapping {

	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver=new ChromeDriver();
		driver.get("https://uat.ayoo.care/ayooadmin/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("username")).sendKeys("sadhana@ayoo.care");
		driver.findElement(By.id("password")).sendKeys("sadhana@ayoo");
		driver.findElement(By.id("loginbtn")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='wrapper']/div[@id='root']/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/nav[1]/ul[1]/li[6]/div[1]")));
		element.click();
		
		//view Mapping
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement ele = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class=\"pro-inner-item\"]/parent::li[@class='pro-menu-item'])[11]")));
	 ele.click();
		//driver.findElement(By.xpath("(//div[@class=\"pro-inner-item\"]/parent::li[@class='pro-menu-item'])[11]")).click();
	
	
		
		
	}

}
