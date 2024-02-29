package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ObjectPage;

public class StepsGala {
    ObjectPage landingPage = new ObjectPage();


    @Given("Navigate to the login page")
    public void navigatorLogin() {
        landingPage.navigateTo();
    }
    @When("Enter user {string} password {string} environment {string} and role {string}")
    public void enterUserAndPassword(String user, String password, String environment, String role) {
        landingPage.enterUserAndPassword(user, password, environment, role);

    }
    @Then("Search fleet Alya later Click on Availability in the Action menu")
    public void clickOnAvailability() {
        landingPage.clickOnAvailability("Galapagos Horizon");
    }

    @Given ("Selection year {string} and click on the active {string}")
    public void selectYearMonth(String year, String month){
        landingPage.selectYear(year, month);
        ;
    }
}