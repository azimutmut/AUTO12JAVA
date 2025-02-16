package lesson17.task3;
import driver.DriverSetUp;
import driver.constants.URL;
import lesson17.task1.ChooseCourse;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterTest;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import java.time.Duration;
public class Alerts {
    private static class Locators {
        private static final By btn = By.id("AlertButton");
        private static final String alertText1 = "You have called alert!";
        private static final String getAlertText2 = "Are you sure you want to apply the discount?";
        private static final String getAlertText3 = "Here you may describe a reason why you are cancelling your registration (or leave this field empty).";
        private static final By doubleClickLocator = By.xpath("//button[text()='Get Discount']");
        private static final By checkTextTest = By.xpath("//button[@data-test-id='PromptButton']");
    }
    static WebDriver driver;
    static WebDriverWait wait;
    static Actions actions;

    @AfterTest
    public void close() {
        driver.quit();
    }

    @Test
    public void loginPage() throws InterruptedException {
        driver = DriverSetUp.driverInit();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        driver.get(URL.LOGIN.getUrl());

        Thread.sleep(1000);
        driver.findElement(By.name("email")).sendKeys("S.Iaffwnfeffdsorv@gmail.com");
        driver.findElement(By.name("password")).sendKeys("string123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(1000);

        wait.until(ExpectedConditions.visibilityOfElementLocated(ChooseCourse.Locators.techStack));
        actions.moveToElement(driver.findElement(ChooseCourse.Locators.techStack)).perform();
        driver.findElement(By.xpath("//div[text()='Actions, Alerts & Iframes']")).click();
        Thread.sleep(1000);

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[@title='Finish your registration']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.btn));
        WebElement btn = driver.findElement(By.id("AlertButton"));
        btn.click();
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.getText();
        assertEquals(alert.getText(), Locators.alertText1);
        alert.accept();
        WebElement actualText1Locator = driver.findElement(By.xpath("//span[text()='Congratulations, you have successfully enrolled in the course!']"));
        String expectedText = "Congratulations, you have successfully enrolled in the course!";
        String actualText = actualText1Locator.getText();
        Assert.assertEquals(actualText, expectedText, "The search result message is incorrect!");

        actions.doubleClick(driver.findElement(Locators.doubleClickLocator)).perform();
        alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.getText();
        assertEquals(alert.getText(), Locators.getAlertText2);
        alert.accept();
        WebElement actualDoubleClickTextLocator = driver.findElement(By.xpath("//span[contains(text(),'You received a 10% discount')]"));
        String expectedText2 = "You received a 10% discount on the second course.";
        String actualText2 = actualDoubleClickTextLocator.getText();
        Assert.assertEquals(actualText2, expectedText2, "The search result message is incorrect!");

        actions.contextClick(driver.findElement(Locators.checkTextTest)).perform();
        Alert alert3 = driver.switchTo().alert();
        alert3.getText();
        assertEquals(alert3.getText(), Locators.getAlertText3);
        String textTest = "Test";
        alert3.sendKeys(textTest);
        alert3.accept();
        WebElement locatorOfFulltext = driver.findElement(By.xpath("//span[text()='Your course application has been cancelled. Reason: Test']"));
        String actualText3 = locatorOfFulltext.getText();
        assertTrue(actualText3.contains(textTest));
    }
}