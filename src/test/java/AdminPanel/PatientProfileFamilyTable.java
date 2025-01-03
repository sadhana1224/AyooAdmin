package AdminPanel;//working

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PatientProfileFamilyTable {

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
        WebElement patientName = driver.findElement(By.xpath("//input[@placeholder='Enter Name']"));
        patientName.sendKeys("Aditiya");
        Thread.sleep(2000);
        // we can change the name as per our need
        driver.findElement(By.xpath("//td[@data-testid='patientName']//a[contains(text(),'Aditiya Rao')]")).click();
        Thread.sleep(2000);

        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,1000)");

        //Family and Relationship Table
        //if person have no family memners- use this code- working
    // driver.findElement(By.xpath("//div[@class='familyIcons']")).click();
        //if person has already relative use this line of code
        driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='root']/div[2]/div[3]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/form[1]/div[1]/div[1]/img[1]")).click();
        driver.findElement(By.xpath("//input[@placeholder='first name']")).sendKeys("San");
        driver.findElement(By.xpath("//input[@placeholder='last name']")).sendKeys("S");
        WebElement gen=driver.findElement(By.xpath("(//td[@class='familyEditMode']//select)[1]"));
        gen.click();
        Select gender=new Select(gen);
        gender.selectByIndex(1);

        WebElement rel=driver.findElement(By.xpath("(//td[@class='familyEditMode']//select)[2]"));
        rel.click();
        Select relation=new Select(rel);
        relation.selectByIndex(3);
        driver.findElement(By.xpath("(//input[@type='date'])[2]")).sendKeys("12/18/1996");

        driver.findElement(By.xpath("//input[@class='FamilyDetails-mobile_Input']")).sendKeys("5630047890");

        driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys("jocaccso1170@kelenson.com");

        //Emergency contact
        WebElement ec=driver.findElement(By.xpath("(//td[@class='familyEditMode']//select)[3]"));
        ec.click();
        Select emer=new Select(ec);
        emer.selectByIndex(1);

        WebElement save = driver.findElement(By.xpath("//img[@title='Save']")); // Replace with the element locator
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", save);
        save.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Adjust timeout if needed
        WebElement toastMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("Toastify__toast-body")));

       // Toast Message Verification- if any failure coming OR if the person already has this family member
        String actualMessage = toastMessage.getText();
        String expectedMessage = "Failed to add family member";

        if (actualMessage.equals(expectedMessage)) {
            System.out.println("Test Passed: Correct toast message displayed.");
        } else {
            System.out.println("Test Failed: Incorrect toast message. Displayed: " + actualMessage);
        }

       Thread.sleep(5000);
        driver.quit();

    }
}
