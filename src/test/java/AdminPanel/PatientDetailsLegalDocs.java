package AdminPanel;//working

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class PatientDetailsLegalDocs {
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
        patientName.sendKeys("Adhi");
        Thread.sleep(2000);
        // we can change the name as per our need
        driver.findElement(By.xpath("//td[@data-testid='patientName']//a[contains(text(),'Adhi A')]")).click();
        Thread.sleep(2000);

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,1000)");

        //Upload Document- once opened check we are able to close the pop up or not
        driver.findElement(By.xpath("//button[text()='Upload Document'][1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='OtherLegalPopUpContainer-close']")).click();

        //upload document - Specify the Request- check Special characters
        driver.findElement(By.xpath("//button[text()='Upload Document'][1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//input[@type='text'])[10]")).sendKeys("@#$!");
        WebElement errorMsg=driver.findElement(By.xpath("//span[@class='OtherLegalPopUp-Input_error']"));
        String actualErrorMessage = errorMsg.getText();
        String expectedErrorMessage = "Only - , _ , ( , ) special characters are allowed";
        if (actualErrorMessage.equals(expectedErrorMessage)) {
            System.out.println("Validation Passed: Only - , _ , ( , ) special characters are allowed");
        } else {
            System.out.println("Validation Failed: Incorrect error message displayed.");
        }
        Thread.sleep(2000);
        //Specify the Request

        driver.findElement(By.xpath("(//input[@type='text'])[10]")).sendKeys("CC Report");
        Thread.sleep(2000);
        WebElement fileInput = driver.findElement(By.xpath("//input[@class='Input']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].removeAttribute('disabled');", fileInput);
        fileInput.sendKeys("C:\\Users\\sadha\\OneDrive\\图片\\icon.png");

        System.out.println("File uploaded successfully.");
        Thread.sleep(6000);
        //once uploaded - we can check that uploaded file is Opening or Not
        driver.findElement(By.xpath("(//td[@class='fileName uploaded'])[1]")).click();
        Thread.sleep(3000);
        //once document is opened - we can close the Document/image
        driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
        Thread.sleep(3000);

        //ReQuest Document - Test case
        driver.findElement(By.id("dropdown-basic")).click();
        //four options are there- 1- ID card, we can change the number[] here in next line
        //ID Card
        //Consent Form
        //Waiver Form
        //Other
        driver.findElement(By.xpath("(//div[@aria-labelledby='dropdown-basic']//a)[1]")).click();
        Thread.sleep(7000);
        //as per before code- we need place the correct value down line- like ID card
        WebElement fileInput1 = driver.findElement(By.xpath("//td[@class='fileName ' and text()='ID Card']/following-sibling::td//button[contains(@class, 'HealthRecords-upload_button')]"));
        fileInput1.click();
        WebElement filepath = driver.findElement(By.id("fileUpload"));

        filepath.sendKeys("C:\\Users\\sadha\\OneDrive\\图片\\admin.png");






    }
}
