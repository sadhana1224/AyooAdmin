package AdminPanel;//working

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class ResetPwdLink {

    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://uat.ayoo.care/ayooadmin/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("username")).sendKeys("admin@ayoo.care");
        driver.findElement(By.id("password")).sendKeys("ayoo-admin-uat!");//AdW!n@Ay00 //ayoo-admin-uat!
        driver.findElement(By.id("loginbtn")).click();
        driver.findElement(By.xpath("(//span[contains(text(),'Patients')])[1]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'All Patients ')]")).click();
        //filter by Email
        Select email=new Select(driver.findElement(By.xpath("//select[@data-testid='filter-selector']")));
        email.selectByVisibleText("Email");
        //we can change the email and name as per our need
        driver.findElement(By.xpath("//input[@placeholder='Enter Email']")).sendKeys("fiboy69971@mowline.com");
        driver.findElement(By.xpath("(//td//a[@title='Fiboy F'])[1]")).click();
   //     WebElement patientName = driver.findElement(By.xpath("//input[@placeholder='Enter Name']"));
   //     patientName.sendKeys("Sadhana");
        // we can change the name as per our need
  //      driver.findElement(By.xpath("//td[@data-testid='patientName']//a[contains(text(),'Sadhana')]")).click();
     //   Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@class='ResetPassButton']")).click();
        driver.findElement(By.xpath("//div//button[contains(text(),'Send')]")).click();
    }
}
