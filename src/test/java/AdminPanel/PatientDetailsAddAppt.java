package AdminPanel;//working

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.time.Duration;

public class PatientDetailsAddAppt {
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
        patientName.sendKeys("Bakya");
        Thread.sleep(2000);
        // we can change the name as per our need
        driver.findElement(By.xpath("//td[@data-testid='patientName']//a[contains(text(),'Bakya Pandiarajan')]")).click();
        Thread.sleep(2000);

        //Appointments- Special Pricing
        driver.findElement(By.xpath("//a//span[contains(text(),'Appointments')]")).click();
        driver.findElement(By.xpath("(//button//span[contains(text(),'Add')])[1]")).click();
        //if we need Medical health use below 6 line otherwise comment it for mental health
        driver.findElement(By.xpath("//select[@name='cartype']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//option[@value='Medical Health']")).click();
        driver.findElement(By.xpath("//select[@name='apttype']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//option[@value='Virtual']")).click();

        driver.findElement(By.id("applyPromoCode")).sendKeys("SAD300");
        driver.findElement(By.xpath("//div//button[contains(text(),'Apply')]")).click();
        Thread.sleep(7000);
        driver.findElement(By.id("book-appointment-submit")).click();

    }
}
