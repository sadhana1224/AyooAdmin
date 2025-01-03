package AdminPanel;//Working

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.time.Duration;

public class PatientDetilasSpecialPricing {
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
        patientName.sendKeys("Aaa1");
        Thread.sleep(2000);
        // we can change the name as per our need
        driver.findElement(By.xpath("//td[@data-testid='patientName']//a[contains(text(),'Aaa1 Aaa')]")).click();
        Thread.sleep(2000);

        //Appointments- Special Pricing
        driver.findElement(By.xpath("//a//span[contains(text(),'Appointments')]")).click();
        driver.findElement(By.xpath("//button//span[contains(text(),'Special pricing')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button//span[contains(text(),'Add')])[2]")).click();
        Select sel=new Select(driver.findElement(By.xpath("//select[@class='case-select']")));
        sel.selectByIndex(0);

        WebElement SplPrice= driver.findElement(By.xpath("//input[@value='1400']"));
        SplPrice.clear();
        SplPrice.sendKeys("1000");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='action-btn confirm']")).click();
        Thread.sleep(4000);
        //Edit Spl price
        driver.findElement(By.xpath("//div[@class='action-btn']//span[contains(text(),'Edit')]")).click();
        Thread.sleep(2000);
        //Check cancel Edit is working or Not
        driver.findElement(By.xpath("//button[@class='add-btn']//span[contains(text(),'Cancel Edit')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='action-btn']//span[contains(text(),'Edit')]")).click();
        driver.findElement(By.xpath("(//tr[@class='active']//td)[3]")).click();
        WebElement update=driver.findElement(By.xpath("//div[@class='value']//input"));
        update.clear();
        update.sendKeys("1100");
        driver.findElement(By.xpath("//button[@class='action-btn confirm']")).click();
        Thread.sleep(5000);
        //delete spl price
        driver.findElement(By.xpath("(//div[@class='action-btn']//img[@alt='Add'])[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='delete-container']")).click();
        Thread.sleep(3000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout if needed
        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Toastify__toast-body")));
        String actualMessage = toastMessage.getText();
        String expectedMessage = "Special Pricing removed";

        if (actualMessage.equals(expectedMessage)) {
            System.out.println("Test Passed: Special Pricing removed");
        } else {
            System.out.println("Test Failed: Incorrect toast message. Displayed: " + actualMessage);
        }

    }
}
