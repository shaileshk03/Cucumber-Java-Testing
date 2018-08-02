Feature: Registration to mercury website

 @tag1
 Scenario: Registration single user 
    When Registration page Displayed
    Then I enter valid data on page
      | FirstName       | Aditya     |	
      | LastName        | Roy        |
      | Phone           | 7501451189 |
      | Email           | a@test.com |
      | UserName        | aditya     |
      | Password        | test123    |
      | ConfirmPassword | test123    |
    Then Click on Submit Button
     And Thank you for registering: should be displayed
    Then Click on Signoff
     And Close the Browser
     
   @tag2
   Scenario: Registration 10 users 
   When Registration page Displayed
   Then I enter valid data on registration page and check if registration is successfull
      | Firstname | Lastname | Phone      | Email        | Username | Password | Confirmpassword |
      | Aditya    | Roy      | 7501451187 | a@text.com   | aditya91 | test123  | test123         |
      | Rakesh    | Sinha    | 7589866698 | b@rars.com   | rakesh90 | test123  | test123         |
      | Preety    | Sharma   | 8598745805 | preety@t.com | preety18 | test123  | test123         |
     And Close the Browser
     
     