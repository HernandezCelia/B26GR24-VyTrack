Feature:  a truck driver I should be able to access Vehicle under Fleet module.

  Background:
    Given that truck driver logged in with valid username and password

  @wip
  Scenario: Truck driver should be able to see all Vehicle information
    //Given that truck driver logged in with valid username and password
    Then truck driver is able to see landing page
    When driver hover over Fleet module
    And driver click on Vehicles
    Then driver should be able to see below information for all the Vehicles displayed
      | Licence Plate        |
      | Tags                 |
      | Driver               |
      | Location             |
      | Chassis number       |
      | Model Year           |
      | Last Odometer        |
      | Immatriculation Date |
      | Frist Contract Date  |
      | CVVI                 |
      | Seats Number         |
      | Doors Number         |
      | Color                |
      | Transmission         |
      | Fuel Type            |
      | CO2 Emission         |
      | Horsepower           |
      | Horsepower Taxation  |
      | Power Kw             |


  Scenario: Verify that when user click on any car on the grid , system should display general information
  about the car
    Given that truck driver  is on Vehicle information page
    When driver clicks on any car on the grid
    Then driver should be able to see below general information about the car
      | Licence Plate             |
      | Tags                      |
      | Driver                    |
      | Location                  |
      | Chassis number            |
      | Model Year                |
      | Last Odometer             |
      | Immatriculation Date      |
      | First Contract Date       |
      | Catalog Value (VAT Incl.) |
      | Seats Number              |
      | Doors Number              |
      | Color                     |
      | Transmission              |
      | Fuel Type                 |
      | CO2 Emission              |
      | Horsepower                |
      | Horsepower Taxation       |
      | Power Kw                  |
      | Logo                      |
      | Vehicle Model             |
      | Vehicle Make              |
    When driver clicks on Add Event button
    Then Add Event window is displayed
    And driver enters event information
    When driver clicks on Save button
    Then driver should be able to see the created event under General tab
    When driver clicks on Activity tab
    Then driver should be able to see the created event
