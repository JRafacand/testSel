package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
    }    public WebElement findElement(String locator) {
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

    public long loadTime;
    public void clickElementMonth(String locator, String month) {
        long startTime = System.currentTimeMillis();
        findElement(locator).click();
        long endTime = System.currentTimeMillis();
        loadTime = (endTime - startTime) / 1000;
        System.out.println("Load time: "+ loadTime + " segundos, Page Month: "+ month );
        Assert.assertFalse(loadTime > 10, "The page took more than 10 seconds to load");
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
            clickElementMonth("//a[normalize-space()='Jan']", "January");
            clickElementMonth("//a[normalize-space()='Mar']", "March");
            clickElementMonth("//a[normalize-space()='May']", "May"   );
            clickElementMonth("//a[normalize-space()='Jul']", "July");
        } else if (month.equals("Febreo, Abril, Junio, Agosto")) {
            clickElementMonth("//a[normalize-space()='Feb']", "February");
            clickElementMonth("//a[normalize-space()='Apr']", "April");
            clickElementMonth("//a[normalize-space()='Jun']", "June");
            clickElementMonth("//a[normalize-space()='Aug']", "August");
        } else if (month.equals("Septiembre, Octubre, Noviembre, Diciembre")) {
            clickElementMonth("//a[normalize-space()='Sep']", "September");
            clickElementMonth("//a[normalize-space()='Oct']", "October");
            clickElementMonth("//a[normalize-space()='Nov']", "November");
            clickElementMonth("//a[normalize-space()='Dec']", "December");

        }

    }
}