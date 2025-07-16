Feature: Lead Creation in Salesforce Application

Scenario Outline: Verifying the Update in Accounts

When the user enters the Username as "bhuvanesh.moorthy@testleaf.com"
  And the user enters the Password as "Leaf@2025"
  And the user clicks the login button
  Then the user should be navigated to the home page
  When the user clicks the App Launcher Icon
  And the user clicks on View All
  And the user clicks on the Accounts
  And the user searches the name in Search as <Account Name> 
    And the user clicks the dropdown icon for corresponding name as <Account Name> 
  And the user clicks on Edit
  And the user select type as <Type>
  And the user select Industry as <Industry>
  And the user enters the billing address <Billing Address>
  And the user enters the shipping address <Shipping Address>
  And the user sets the Customer Priority to <Customer Priority>
  And the user sets the SLA to <SLA>
  And the user sets the Active to <Active>
  And the user enters phone number
  And the user sets the Upsell oppurtunity <Upsell>
  And the user clicks the Update
  Then the user verifies the phone number
  
  
  
  
  Examples: 
|Account Name|Type| Industry | Billing Address | Shipping Address | Customer Priority | SLA | Active  | Upsell|
|pmadhu|Technology Partner|Healthcare|ABC Street|XYZ Street|Low|Silver|No|No|  
|varun|Technology Partner|Energy|DEF Street|UVW Street|Low|Silver|No|No|
|sathish|Technology Partner|Retail|DEF Street|UVW Street|Low|Silver|No|No|