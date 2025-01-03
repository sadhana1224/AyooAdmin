package AdminPanel;//working

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;

public class PatientDetailsMHistoryVitals {
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
        //Vitals-- first time add vitals
     //   driver.findElement(By.xpath("(//div[@class='MedicalHistory Vitals']//div)[2]")).click();
        //Vitals- if you are adding second time use this line-- comment above line
        driver.findElement(By.xpath("(//div[@class='MedicalHistory Vitals']//img[@alt='' and contains(@class, 'MedicalHistory-PlusIcon')])[1]")).click();
        Thread.sleep(2000);
        //check cancel button is working or not
        driver.findElement(By.xpath("//button[contains(text(),'Cancel')]")).click();
        //Vitals-- first time add vitals
     //   driver.findElement(By.xpath("(//div[@class='MedicalHistory Vitals']//div)[2]")).click();
        //Vitals- if you are adding second time use this line-- comment above line
        driver.findElement(By.xpath("(//div[@class='MedicalHistory Vitals']//img[@alt='' and contains(@class, 'MedicalHistory-PlusIcon')])[1]")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='temperature']")).sendKeys("98");
        driver.findElement(By.xpath("//input[@name='pulse']")).sendKeys("132");
        driver.findElement(By.xpath("//input[@name='bp_systolic']")).sendKeys("155");
        driver.findElement(By.xpath("//input[@name='bp_diastolic']")).sendKeys("34");
        driver.findElement(By.xpath("//input[@name='weight']")).sendKeys("67");
        driver.findElement(By.xpath("//input[@name='height']")).sendKeys("170");
        driver.findElement(By.xpath("//input[@name='respiratory_rate']")).sendKeys("105");
        driver.findElement(By.xpath("//input[@name='pulse_ox']")).sendKeys("165");
        driver.findElement(By.xpath("//input[@name='blood_glucose']")).sendKeys("175");
        driver.findElement(By.xpath("//input[@name='waist_circum']")).sendKeys("32");
        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(text(),'Vitals added successfully')]")));

        System.out.println("Toast message disappeared. Proceeding with next steps...");
        Actions actions = new Actions(driver);
        actions.moveByOffset(10, 10).click().perform();


/*
        //Edit Vitals
        driver.findElement(By.xpath("//div[@class='MedicalHistory Vitals']//div//img[@alt='Edit']")).click();
        WebElement temperatureInput = driver.findElement(By.name("temperature"));
        temperatureInput.clear();
        temperatureInput.sendKeys("98.6");
        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();*/


    }
}
