Feature: Account Page Feature

Background:
Given user has already logged in to application
|username|password|
|Bishnu_test@Test.com|Test@12345|

Scenario: Account page Title
Given user is on Account page
When user gets the title of the page
Then page title should be "My account - My Store"

Scenario: Account Section count
Given user is on Account page
Then user gets accounts section
|ORDER HISTORY AND DETAILS|
|MY CREDIT SLIPS|
|MY ADDRESSES|
|MY PERSONAL INFORMATION|
|MY WISHLISTS|
And accounts section count should be 5
