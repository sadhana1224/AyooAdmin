package AdminPanel; //working

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Clinics {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {

		driver=new ChromeDriver();
		driver.get("https://uat.ayoo.care/ayooadmin/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("username")).sendKeys("sadhana@ayoo.care");
		driver.findElement(By.id("password")).sendKeys("sadhana@ayoo");
		driver.findElement(By.id("loginbtn")).click();
		Thread.sleep(30);
		driver.findElement(By.xpath("(//span[@class=\"pro-icon\"]/ancestor::div[@class='pro-inner-item'])[7]")).click();
		Thread.sleep(10);
		driver.findElement(By.xpath("(//span[@class=\"pro-item-content\"]/ancestor::li[@class='pro-menu-item'])[11]")).click();
        
        
        //Edit clinic(didn't complete)
       // Thread.sleep(25);
        //driver.findElement(By.xpath("//i[@class='fa fa-edit p-r-10']/ancestor::div[@class='float-right edtdiv']")).click();
	}

}		

