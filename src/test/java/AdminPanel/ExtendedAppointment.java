package AdminPanel;//working

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.time.Duration;

public class ExtendedAppointment {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException, AWTException {
        driver = new ChromeDriver();
        driver.get("https://uat.ayoo.care/ayooadmin/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("username")).sendKeys("admin@ayoo.care");
        driver.findElement(By.id("password")).sendKeys("ayoo-admin-uat!");//AdW!n@Ay00 //ayoo-admin-uat!
        driver.findElement(By.id("loginbtn")).click();

        driver.findElement(By.xpath("(//span[contains(text(),'Patients')])[1]")).click();
        driver.findElement(By.xpath("//span[contains(text(),'All Patients ')]")).click();
        WebElement patientName = driver.findElement(By.xpath("//input[@placeholder='Enter Name']"));
        patientName.sendKeys("Yajo");
        Thread.sleep(2000);
        // we can change the name as per our need
        driver.findElement(By.xpath("//td[@data-testid='patientName']//a[contains(text(),'Yajo Y')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[contains(text(),'Appointments')])[4]")).click();

        //extended link- changes xpath as per the time
        driver.findElement(By.xpath("(//div//table//tbody//tr//td[contains(text(),'A927CZM')])[2]")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@class='promo-container']//input")).sendKeys("SAD300");
        driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'Confirm')]")).click();
    }
}
