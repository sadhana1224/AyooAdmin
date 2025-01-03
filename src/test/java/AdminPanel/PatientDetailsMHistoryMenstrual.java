package AdminPanel;//working

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;

public class PatientDetailsMHistoryMenstrual {
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
        patientName.sendKeys("Aewq1");
        Thread.sleep(2000);
        // we can change the name as per our need
        driver.findElement(By.xpath("//td[@data-testid='patientName']//a[contains(text(),'Aewq1 Aweq1')]")).click();
        Thread.sleep(2000);

        //Medical History
        driver.findElement(By.xpath("//span[contains(text(),'Medical History')]")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");

        //Menstrual and obstetric History--- If patient is Female
        WebElement element = driver.findElement(By.xpath("//div[h3[contains(text(),'Menstrual and obstetric history')]]//img[@alt='' and contains(@class, 'MedicalHistory-PlusIcon')]"));
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='obstetric_score']")).sendKeys("32");
        driver.findElement(By.xpath("(//input[@type='date'])[3]")).sendKeys("12/18/2018");
        driver.findElement(By.xpath("//input[@name='disturbances']")).sendKeys("Stomach pain");
        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();

        Actions actions = new Actions(driver);
        actions.moveByOffset(10, 10).click().perform();
    }
}
