Feature: Login to website

Background:
Given validate the browser

@Smoke
Scenario: TC001 Verify successfull login 
Given User opens the browser and navigates to home page
When User enters username and password and click submit button
Then User logs in successfully and lands on dashboard

@Sanity
Scenario: TC002 Verify successfull login
Given User opens the browser and navigates to home page
When User enters username and password and click submit button
Then User logs in successfully and lands on dashboard

@Regression
Scenario: TC003 Verify successfull login
Given User opens the browser and navigates to home page
When User enters username and password and click submit button
Then User logs in successfully and lands on dashboard

@Smoke
Scenario: TC004 Verify successfull login
Given User opens the browser and navigates to home page
When User enters username and password and click submit button
Then User logs in successfully and lands on dashboard

@Sanity
Scenario: TC005 Verify successfull login
Given User opens the browser and navigates to home page
When User enters username and password and click submit button
Then User logs in successfully and lands on dashboard

@Regression
Scenario: TC006 Verify successfull login
Given User opens the browser and navigates to home page
When User enters username and password and click submit button
Then User logs in successfully and lands on dashboard