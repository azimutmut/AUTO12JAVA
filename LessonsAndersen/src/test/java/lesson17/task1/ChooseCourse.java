package lesson17.task1;
import driver.constants.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import driver.DriverSetUp;
import java.time.Duration;

public class ChooseCourse {
    public static class Locators{
        public static final By techStack = By.xpath("//div[text()='AQA Practice']");
        private static final By selectCountry =  By.xpath("//select[@data-lol='SelectCountry']");
    }
    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeMethod
    public void driverInit(){
        driver = DriverSetUp.driverInit();
        wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @AfterMethod
    public void close(){
        driver.quit();
    }
    @Test
    public void loginPage() throws InterruptedException {
        driver.get(URL.LOGIN.getUrl());
        Thread.sleep(1000);
        driver.findElement(By.name("email")).sendKeys("S.Iaffwnfeffdsorv@gmail.com");
        driver.findElement(By.name("password")).sendKeys("string123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(1000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.techStack));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(Locators.techStack)).perform();
        driver.findElement(By.xpath("//div[text()='Select']")).click();
        Thread.sleep(1000);

        WebElement countryDropdown = driver.findElement(By.xpath("//select[@title='Select country']"));
        Select select1 = new Select(countryDropdown);
        select1.selectByVisibleText("USA");

        WebElement languageDropdown = driver.findElement(By.id("SelectLanguage"));
        Select select2 = new Select(languageDropdown);
        select2.selectByVisibleText("English");

        WebElement typeDropdown = driver.findElement(By.xpath("//select[@data-doubtful-but-ok='SelectType']"));
        Select select3 = new Select(typeDropdown);
        select3.selectByVisibleText("Testing");

        WebElement calendar1 = driver.findElement(By.xpath("//input[@data-calendar='1']"));
        calendar1.sendKeys("17022025");

        WebElement calendar2 = driver.findElement(By.xpath("//input[@data-calendar='2']"));
        calendar2.sendKeys("03032025");

        WebElement coursesDropdown = driver.findElement(By.id("MultipleSelect"));
        Select select4 = new Select(coursesDropdown);
        select4.selectByVisibleText("AQA Java");
        select4.selectByVisibleText("AQA Python");
        driver.findElement(By.xpath("//button[@name='SelectPageSearchButton']")).click();
        Thread.sleep(1000);
        WebElement text = driver.findElement(By.xpath("//h2[@class='mb-[35px] text-[24px] leading-[28.13px]']"));
        String expectedText = "Unfortunately, we did not find any courses matching your chosen criteria.";
        String actualText = text.getText();
        Assert.assertEquals(actualText, expectedText, "The search result message is incorrect!");
    }
}