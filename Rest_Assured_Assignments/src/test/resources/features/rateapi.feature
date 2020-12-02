Feature: Foreign Exchange Reference Rate
Scenario: Get the latest foreign exchange reference rates
Given API for foreign exchange
When posted with correct information
Then validate positive response code received