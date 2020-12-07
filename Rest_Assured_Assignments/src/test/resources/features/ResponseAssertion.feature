Feature: Validate Response Code using Assertions
Scenario: Add assertions for response code
Given API for foreign exchange
When posted with correct information
Then validate positive response code received

Scenario: Get Specific Exchange Rate by setting he symbol parameter
Given API for foreign exchange with symbols
When posted with correct symbols
Then validate positive response code for given symbols


Scenario: Get the base currency for getting exchange rates
Given API for foreign exchange with base currency
When posted with correct base currency
Then validate positive response code for given base currency

Scenario: Get Specific exchange rate by setting the base and symbols parameter 
Given API for foreign exchange with base and symbols
When posted with correct base and symbols
Then validate positive response code for base currency and symbols