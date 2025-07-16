Feature: Lead Creation in Salesforce Application

Scenario: Verifying the Update in Accounts

When the user enters the Username as "bhuvanesh.moorthy@testleaf.com"
  And the user enters the Password as "Leaf@2025"
  And the user clicks the login button
  Then the user should be navigated to the home page
  When the user clicks the App Launcher Icon
  And the user clicks on View All
  And the user clicks on the Accounts
  And the user searches the name in Search as "pmadhu"
    And the user clicks the dropdown icon for corresponding name as "pmadhu"
  And the user clicks on Edit
  And the user select type as "Technology Partner"
  And the user select Industry as "Healthcare"
  And the user enters the billing address "ABC Street"
  And the user enters the shipping address "XYZ Street"
  And the user sets the Customer Priority to "Low"
  And the user sets the SLA to "Silver"
  And the user sets the Active to "No"
  And the user enters phone number
  And the user sets the Upsell oppurtunity "No"
  And the user clicks the Update
  Then the user verifies the phone number
  
  
  
  
 