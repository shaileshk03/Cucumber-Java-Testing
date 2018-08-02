Feature: Pizzahut user login feature
  I want to use this template for user login feature file

  @tag1
  Scenario: New user login scenario
    Given User navigate to url
    And User click on dine link
    And User select radio button
    And User select city "<Hyderabad>"
    And User select store "<Madhapur>"
    Then User click on next button
    And User enter customer Name "John"
    And User enter select gender as "Male"
    And User enter emailaddress as "alex123@gmail.com"
    And User enter phone number as "8888888888"
    And User select preferred time as "11-3 AM"
    And User enter Address as "Ram Nagar 123"
    And User select a date as "3"
    And User select time of visit
    And User enter your feedback as "I liked you pizza"
    And User options how often do you visit pizza hut
    And User upload picture
    And User select was restaurant clean
    And User select Was hospitable Friendly
    And User select did You Receive What Ordered
    And User select Was Restaurant Well Maintained
    And User select Was The Food You Liking
    And User select Were You Served Speedly
    And User select did You Feel Value For Money
    And User select will You visit Pizzahut In Near Future
    Then User click on sumbit button
    And User close the browser

    