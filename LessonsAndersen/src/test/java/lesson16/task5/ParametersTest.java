package lesson16.task5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.driver.consts.URL;
import utils.driver.consts.DriverSetUp;
import java.time.Duration;
public class ParametersTest {
    WebDriver driver;
    @BeforeClass
    @Parameters({"browser"})
    public void driverSetUp(String browser) {
        switch (browser) {
            case "Edge" -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
                driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
            }
            case "Chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
                driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
            }
        }
    }
    @Test(dataProvider = "loginData")
    public void invalidLoginTest(String email, String passwd) throws InterruptedException {
        driver.get("https://qa-course-01.andersenlab.com/login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(passwd);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(1000);

        driver.quit();
    }
    @DataProvider(name = "loginData")
    public Object[][] createData(){
        return new Object[][]{
                {"S.Iaffwnfeffdsorv@gmail.com", "string123" },{"aza@meat.com", "qwerty123"},{"aza1@meat.com", "qwerty1234"},
        };
    }
}
