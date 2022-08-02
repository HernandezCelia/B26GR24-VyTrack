package com.cydeo.step_definitions;

import com.cydeo.pages.DashboardPage;
import com.cydeo.pages.LogInPage;
import com.cydeo.pages.TruckDriverFleetModule_Page;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class TruckDriverFleetModule_StepDef {

    TruckDriverFleetModule_Page truckDriverFleetModulePage = new TruckDriverFleetModule_Page();
    LogInPage logInPage = new LogInPage();
    Actions actions = new Actions(Driver.getDriver());
    DashboardPage dashboardPage = new DashboardPage();

    @Given("that truck driver logged in with valid username and password")
    public void that_truck_driver_logged_in_with_valid_username_and_password() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));
        logInPage.login(ConfigurationReader.getProperty("truck.driver.username"), ConfigurationReader.getProperty( "truck.driver.password"));

        Thread.sleep(2000);
        System.out.println("Successfully logged in");

    }
    @Then("truck driver is able to see landing page")
    public void truck_driver_is_able_to_see_landing_page() throws InterruptedException {
        String actualFullName = dashboardPage.fullName.getText();
        System.out.println(actualFullName);
        if(actualFullName.contains("Bailee")){
            System.out.println("Landing Page was displayed");
        }


        Thread.sleep(2000);
    }
    @When("driver hover over Fleet module")
    public void driver_hover_over_fleet_module() throws InterruptedException {
        actions.moveToElement(truckDriverFleetModulePage.fleetTab).perform();
        System.out.println("hovered over the fleet tab");
        Thread.sleep(2000);

    }
    @When("driver click on Vehicles")
    public void driver_click_on_vehicles() throws InterruptedException {
    truckDriverFleetModulePage.vehicleTab.click();
        System.out.println("vehicle tab clicked");
        Thread.sleep(2000);

    }
    @Then("driver should be able to see below information for all the Vehicles displayed")
    public void driver_should_be_able_to_see_below_information_for_all_the_vehicles_displayed(List<String> dataTable) throws InterruptedException {

       List<WebElement> actualData =  Driver.getDriver().findElements(By.xpath("//thead//tr[@class='grid-header-row']//span[@class='grid-header-cell__label']"));

        for (int i = 0; i < dataTable.size(); i++) {
            String actualTabName = actualData.get(i).getText();
            Assert.assertEquals(dataTable.get(i), actualTabName);
            System.out.println(actualTabName);
        }

        Thread.sleep(2000);

    }

}
