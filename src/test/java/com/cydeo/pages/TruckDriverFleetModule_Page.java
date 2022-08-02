package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TruckDriverFleetModule_Page {

    public TruckDriverFleetModule_Page(){
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "h1[class='oro-subtitle']")
    public WebElement quickLaunchpad;

    @FindBy(xpath = "(//span[@class='title title-level-1'])[1]")
    public WebElement fleetTab;

    @FindBy(xpath = "//li[@class='dropdown-menu-single-item first']/a/span[.='Vehicles']")
    public WebElement vehicleTab;




}
