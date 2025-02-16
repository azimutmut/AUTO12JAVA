package lesson17.task2;
import driver.DriverSetUp;
import driver.constants.URL;
import lesson17.task1.ChooseCourse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class DragAndDrop {
    private static class Locators {
        private static final By manual1 = By.id("manual1");
        private static final By manual2 = By.id("manual2");
        private static final By auto1 = By.id("auto1");
        private static final By auto2 = By.id("auto2");
        private static final By targetManual1 = By.id("target-manual1");
        private static final By targetManual2 = By.id("target-manual2");
        private static final By targetAuto1 = By.id("target-auto1");
        private static final By targetAuto2 = By.id("target-auto2");
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
        driver.findElement(By.xpath("//div[text()='Drag & Drop']")).click();
        Thread.sleep(1000);
    }

    @Test
    public void manualDragAndDrop() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.manual2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(Locators.targetManual2));
        actions.clickAndHold(driver.findElement(Locators.manual1))
                .moveToElement(driver.findElement(Locators.targetManual1))
                .release()
                .build()
                .perform();
        actions.clickAndHold(driver.findElement(Locators.manual2))
                .moveToElement(driver.findElement(Locators.targetManual2))
                .release()
                .build()
                .perform();

        actions.dragAndDrop(driver.findElement(Locators.auto1), driver.findElement(Locators.targetAuto1))
                .perform();
        actions.dragAndDrop(driver.findElement(Locators.auto2), driver.findElement(Locators.targetAuto2))
                .perform();
        Thread.sleep(1000);

        WebElement text = driver.findElement(By.xpath("//div[contains(text(), \"Congratulations! Let's test for the best!\")]"));
        String expectedText = "Congratulations! Let's test for the best!";
        String actualText = text.getText();
        Assert.assertEquals(actualText, expectedText, "The search result message is incorrect!");
        Thread.sleep(1000);
    }
}