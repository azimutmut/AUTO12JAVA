package lesson16.task4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.driver.consts.DriverSetUp;
import java.time.Duration;
public class DataProviderTest {
    @Test(dataProvider = "loginData")
    public void invalidLoginTest(String email, String passwd){
        WebDriver driver = DriverSetUp.driverInit();
        driver.get("https://qa-course-01.andersenlab.com/login");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys(email);
        driver.findElement(By.name("password")).sendKeys(passwd);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        driver.quit();
    }

    @DataProvider(name = "loginData")
    public Object[][] createData(){
        return new Object[][]{
                {"S.Iaffwnfeffdsorv@gmail.com", "string123" },{"aza@meat.com", "qwerty123"},{"aza1@meat.com", "qwerty1234"},
        };
    }
}