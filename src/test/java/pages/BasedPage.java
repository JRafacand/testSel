package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasedPage {
    protected static WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    static {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    public BasedPage(WebDriver driver) {
        BasedPage.driver = driver;

    }

    public WebElement findElement(String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public WebElement findElementS(String texto) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(texto)));
    }

    public WebElement findElementClass(String classname) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.className(classname)));
    }

    public static void navigateTo(String url) {
        driver.get(url);

    }

    public void writeText(String locator, String keysToSend) {
        findElement(locator).clear();
        findElement(locator).sendKeys(keysToSend);

    }

    public void clickElement(String locator) {
        findElement(locator).click();
    }

    public void clickElemSelector(String locator) {
        findElementS(locator).click();
    }

    public void dropdownSelectValue(String locator, String text) {
        Select dropdown = new Select(findElement(locator));
        dropdown.selectByValue(text);

    }

    public void dropdownSelectVisibleText(String locator, String text) {
        Select dropdown = new Select(findElement(locator));
        dropdown.selectByVisibleText(text);
    }

    public boolean isElementPresent(String locator) {
        try {
            findElement(locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void closeBrowser() {
        driver.quit();
    }

    public void sleepForSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickMonth(String month) {
        if (month.equals("Enero, Marzo, Mayo, Julio")) {
            clickElement("//a[normalize-space()='Jan']");
            clickElement("//a[normalize-space()='Mar']");
            clickElement("//a[normalize-space()='May']");
            clickElement("//a[normalize-space()='Jul']");
        } else if (month.equals("Febreo, Abril, Junio, Agosto")) {
            clickElement("//a[normalize-space()='Feb']");
            clickElement("//a[normalize-space()='Apr']");
            clickElement("//a[normalize-space()='Jun']");
            clickElement("//a[normalize-space()='Aug']");
        } else if (month.equals("Septiembre, Octubre, Noviembre, Diciembre")) {
            clickElement("//a[normalize-space()='Sep']");
            clickElement("//a[normalize-space()='Oct']");
            clickElement("//a[normalize-space()='Nov']");
            clickElement("//a[normalize-space()='Dec']");

        }

    }
}