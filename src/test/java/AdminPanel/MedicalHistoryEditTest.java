package AdminPanel;//working

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.time.Duration;

public class MedicalHistoryEditTest {
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

        //Vitals Edit Check
        driver.findElement(By.xpath("//div[h3[contains(text(),'Vitals')]]//img[@alt='Edit']")).click();
        Thread.sleep(1000);
        WebElement vitals= driver.findElement(By.xpath("//input[@name='temperature']"));
        vitals.clear();
        vitals.sendKeys("100");
        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
      //dummy click for toast message stuck- that's y i added this line
        Actions actions = new Actions(driver);
        actions.moveByOffset(10, 10).click().perform();
        Thread.sleep(6000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        //Menstrual Edit
        driver.findElement(By.xpath("//div[h3[contains(text(),'Menstrual and obstetric history')]]//img[@alt='Edit']")).click();
        WebElement Menstrual=driver.findElement(By.xpath("//input[@name='obstetric_score']"));
        Menstrual.clear();
        Menstrual.sendKeys("38");
        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
        //dummy click for toast message stuck- that's y i added this line
        Actions actions1 = new Actions(driver);
        actions1.moveByOffset(10, 10).click().perform();
        Thread.sleep(6000);

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,500)");
        //Known Allergies
        driver.findElement(By.xpath("//div[h3[contains(text(),'Known Allergies')]]//img[@alt='Edit']")).click();
        WebElement drug=driver.findElement(By.xpath("//input[@name='drug']"));
        drug.clear();
        drug.sendKeys("Testing");
        WebElement food=driver.findElement(By.xpath("//input[@name='food']"));
        food.clear();
        food.sendKeys("Brinjall");
        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
        //dummy click for toast message stuck- that's y i added this line
        Actions actions2 = new Actions(driver);
        actions2.moveByOffset(10, 10).click().perform();
        Thread.sleep(6000);

        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,500)");
        //Family History
        driver.findElement(By.xpath("//div[h3[contains(text(),'Family History')]]//img[@alt='Edit']")).click();
        WebElement Relation=driver.findElement(By.xpath("//input[@name='relationship']"));
        Relation.clear();
        Relation.sendKeys("Uncle");
        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
        //dummy click for toast message stuck- that's y i added this line
        Actions actions3 = new Actions(driver);
        actions3.moveByOffset(10, 10).click().perform();
        Thread.sleep(6000);

        JavascriptExecutor js3 = (JavascriptExecutor) driver;
        js3.executeScript("window.scrollBy(0,500)");
        //Prior Medical/Psychiatric History
        driver.findElement(By.xpath("//div[h3[contains(text(),'Prior Medical/Psychiatric History')]]//img[@alt='Edit']")).click();
        WebElement hospital=driver.findElement(By.xpath("//input[@name='physician_hospital']"));
        hospital.clear();
        hospital.sendKeys("Gem");
        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
        //dummy click for toast message stuck- that's y i added this line
        Actions actions4 = new Actions(driver);
        actions4.moveByOffset(10, 10).click().perform();
        Thread.sleep(6000);

        JavascriptExecutor js4 = (JavascriptExecutor) driver;
        js4.executeScript("window.scrollBy(0,500)");
        //Current / Past Medication
        driver.findElement(By.xpath("//div[h3[contains(text(),'Current / Past Medication')]]//img[@alt='Edit']")).click();
        WebElement med =driver.findElement(By.xpath("//input[@name='medicine_name']"));
        med.clear();
        med.sendKeys("Paracetomal");
        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
        //dummy click for toast message stuck- that's y i added this line
        Actions actions5 = new Actions(driver);
        actions5.moveByOffset(10, 10).click().perform();
        Thread.sleep(6000);

        JavascriptExecutor js5 = (JavascriptExecutor) driver;
        js5.executeScript("window.scrollBy(0,500)");
        //Vaccination Record
        driver.findElement(By.xpath("//div[h3[contains(text(),'Vaccination Record')]]//img[@alt='Edit']")).click();
        WebElement vaccine=driver.findElement(By.xpath("//input[@name='vaccine_name']"));
        vaccine.clear();
        vaccine.sendKeys("Viral Fever");
        driver.findElement(By.xpath("//button[contains(text(),'Save')]")).click();
        //dummy click for toast message stuck- that's y i added this line
        Actions actions6 = new Actions(driver);
        actions6.moveByOffset(10, 10).click().perform();
        Thread.sleep(6000);



    }
}
