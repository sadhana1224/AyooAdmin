package AdminPanel;//working

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.time.Duration;

public class PatientDetailsMHistoryALL {
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

        //Medical History
        driver.findElement(By.xpath("//span[contains(text(),'Medical History')]")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

        //Known Allergies
        driver.findElement(By.xpath("//div[h3[contains(text(),'Known Allergies')]]//img[@alt='' and contains(@class, 'MedicalHistory-PlusIcon')]")).click();
        driver.findElement(By.xpath("//input[@name='drug']")).sendKeys("Test");
        driver.findElement(By.xpath("//input[@name='food']")).sendKeys("Brinjal");
        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
        //dummy click for toast message stuck- that's y i added this line
        Actions actions = new Actions(driver);
        actions.moveByOffset(10, 10).click().perform();

        //Family History
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,200)");

        driver.findElement(By.xpath("//div[h3[contains(text(),'Family History')]]//img[@alt='' and contains(@class, 'MedicalHistory-PlusIcon')]")).click();
        driver.findElement(By.xpath("//input[@name='relationship']")).sendKeys("Aunt");
        driver.findElement(By.xpath("//input[@name='condition']")).sendKeys("Sugar");
        driver.findElement(By.xpath("//input[@name='notes']")).sendKeys("Taking tablets");
        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
        //dummy click for toast message stuck- that's y i added this line
        Actions actions1 = new Actions(driver);
        actions1.moveByOffset(10, 10).click().perform();


        //Prior Medical/Psychiatric History
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,400)");

        driver.findElement(By.xpath("//div[h3[contains(text(),'Prior Medical/Psychiatric History')]]//img[@alt='' and contains(@class, 'MedicalHistory-PlusIcon')]")).click();

        driver.findElement(By.xpath("(//input[@name='condition'])[2]")).sendKeys("Thyroid");
        driver.findElement(By.xpath("//input[@name='date']")).sendKeys("1 Year");
        driver.findElement(By.xpath("//input[@name='physician_hospital']")).sendKeys("KMCH");
        driver.findElement(By.xpath("(//input[@name='notes'])[2]")).sendKeys("Taking tablets");
        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
        //dummy click for toast message stuck- that's y i added this line
        Actions actions3 = new Actions(driver);
        actions3.moveByOffset(10, 10).click().perform();

        //Current / Past Medication
        JavascriptExecutor js3 = (JavascriptExecutor) driver;
        js3.executeScript("window.scrollBy(0,400)");

        driver.findElement(By.xpath("//div[h3[contains(text(),'Current / Past Medication')]]//img[@alt='' and contains(@class, 'MedicalHistory-PlusIcon')]")).click();
        driver.findElement(By.xpath("//input[@name='medicine_name']")).sendKeys("Folic acid");
        driver.findElement(By.xpath("//input[@name='dosage']")).sendKeys("10mg");
        driver.findElement(By.xpath("//input[@name='frequency']")).sendKeys("1 time");
        driver.findElement(By.xpath("//input[@name='start_date']")).sendKeys("12/31/2024");
        driver.findElement(By.xpath("//input[@name='end_date']")).sendKeys("02/31/2025");
        driver.findElement(By.xpath("//input[@name='purpose']")).sendKeys("Test");
        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
        //dummy click for toast message stuck- that's y i added this line
        Actions actions4 = new Actions(driver);
        actions4.moveByOffset(10, 10).click().perform();


        //Vaccination Record
        JavascriptExecutor js4 = (JavascriptExecutor) driver;
        js4.executeScript("window.scrollBy(0,400)");

        driver.findElement(By.xpath("//div[h3[contains(text(),'Vaccination Record')]]//img[@alt='' and contains(@class, 'MedicalHistory-PlusIcon')]")).click();
        driver.findElement(By.xpath("//input[@name='vaccine_name']")).sendKeys("Covid");
        driver.findElement(By.xpath("(//input[@name='date'])[2]")).sendKeys("12/12/2019");
        driver.findElement(By.xpath("//input[@name='due_date']")).sendKeys("12/12/2027");

        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
        //dummy click for toast message stuck- that's y i added this line
        Actions actions5 = new Actions(driver);
        actions5.moveByOffset(10, 10).click().perform();

    }
}
