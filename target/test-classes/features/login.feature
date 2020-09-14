Feature: Login into application

Scenario Outline: Positive test validating login
Given Initialize the browser with chrome
And Navigate to "http:qaclickacademy.com" site
And Click on Login in home page to land on secure Sign in page
When User enters <username> and <password> and logs in
Then Verify that user is successfully loged in
And close browser

Examples:
|username			|password	|
|test99@gmail.com	|123456		|
|test123@gmail.com	|12345		|
