package AdminPanel;//working

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AyooClinicInfo {
    static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        driver = new ChromeDriver();
        driver.get("https://uat.ayoo.care/ayooadmin");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.id("username")).sendKeys("admin@ayoo.care");
        driver.findElement(By.id("password")).sendKeys("ayoo-admin-uat!"); //AdW!n@Ay00 //ayoo-admin-uat!

        driver.findElement(By.id("loginbtn")).click();
        driver.findElement(By.xpath("//span[contains(text(),'Facilities')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'AYOO Clinics ')]")).click();
        Thread.sleep(2000);

        //click on the clinic
        driver.findElement(By.xpath("(//tr//a)[2]")).click();
        //Edit Clinic details- we can check edit is working or not

        driver.findElement(By.xpath("(//div//img[@alt='Edit'])[1]")).click();
        WebElement address=driver.findElement(By.xpath("//textarea[@name='address']"));
        address.clear();
        address.sendKeys("Madurai Fourr");

        WebElement Num=driver.findElement(By.xpath("//input[@name='mobile']"));
        Num.clear();
        Num.sendKeys("4563217890");
        driver.findElement(By.xpath("//button[contains(text(),'save')]")).click();
        Thread.sleep(3000);

        //Edit contact detaails
        driver.findElement(By.xpath("(//div//img[@alt='Edit'])[2]")).click();
        WebElement Name=driver.findElement(By.xpath("//input[@name='contact_person_name']"));
        Name.clear();
        Name.sendKeys("Mani");

        //input[@name='contact_person_phone']
        WebElement Phnum=driver.findElement(By.xpath("//input[@name='contact_person_phone']"));
        Phnum.clear();
        Phnum.sendKeys("9566991218");
        driver.findElement(By.xpath("//button[contains(text(),'save')]")).click();
        Thread.sleep(3000);

        //Clinic Doctor add
        driver.findElement(By.xpath("(//div//img[@alt='add'])[1]")).click();
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement doctorDropdown = driver.findElement(By.xpath("//input[@id='react-select-2-input']"));
        js.executeScript("arguments[0].click();", doctorDropdown);

// Send keys after clicking
        doctorDropdown.sendKeys("Anam");
        doctorDropdown.sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//div[contains(text(),'Add')]")).click();

        //delete doctor
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//div//img[@alt='Edit'])[3]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div//img[@alt='Delete']")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[contains(text(),'cancel')]")).click();


    }
}
