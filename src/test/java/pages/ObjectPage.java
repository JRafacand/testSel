package pages;


import org.testng.asserts.SoftAssert;



public class ObjectPage extends BasedPage {
    private String yearSelect = "//li[@id='j_idt102_%s']";


    public ObjectPage() {
        super(driver);
    }

    public void navigateTo() {
        navigateTo("https://develop.galavail.com/galavail-web/login.xhtml");
    }

    public void enterUserAndPassword(String user, String password, String environment, String role) {
        SoftAssert soft = new SoftAssert();
        writeText("//input[@id='name']", user);
        clickElement("//span[@class='ui-button-text ui-c']");
        soft.assertFalse(isElementPresent("//span[@class='ui-message-error-detail']"), "Incorrect Email or Username");
        dropdownSelectValue("//select[@id='j_idt17']", environment);
        sleepForSeconds(5);
        dropdownSelectValue("//select[@id='rol']", role);
        writeText("//input[@id='password']", password);
        clickElement("//span[@class='ui-button-text ui-c']");
        soft.assertFalse(isElementPresent("//span[contains(text(),'Wrong password. Try again or click Forgot password')]"), "Incorrect Password");
        sleepForSeconds(10);
        soft.assertAll();
    }

    public void clickOnAvailability(String fleetName) {
        writeText("//input[@id='txtBuscarbarco']", fleetName);
        sleepForSeconds(2);
        clickElement("//a[@id='btnbuscarBarco']");
        sleepForSeconds(2);
        clickElement("//i[@class='fa fa-bars fa-2x dropButton']");
        sleepForSeconds(2);
        clickElemSelector("Availability");
        sleepForSeconds(2);
    }
    public long loadTtime;


    public void selectYear(String year, String month) {
        clickElement("//label[@id='j_idt102_label']");
        sleepForSeconds(5);
        if (year.equals("2024")) {
            String yearPath = String.format(yearSelect, 3);
            clickElement(yearPath);
            sleepForSeconds(5);
            clickMonth(month);
            } else if (year.equals("2025")) {
            String yearPath = String.format(yearSelect, 4);
            clickElement(yearPath);//año
            sleepForSeconds(5);
            clickMonth(month);
            } else if (year.equals("2026")) {
            String yearPath = String.format(yearSelect, 5);
            clickElement(yearPath);//año
            sleepForSeconds(5);
            clickMonth(month);
        }
    }
}


