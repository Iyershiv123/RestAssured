Feature: Negative Response code of incomplete url using assertions
Scenario: Validate response code of incomplete url using assertion
Given API for foreign exchange
When posted with incorrect information
Then validate response code received