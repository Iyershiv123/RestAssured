Feature: Negative Response code of  uri using assertions

Scenario: Validate response code of incomplete url using assertion
Given API for foreign exchange
When posted with incorrect information
Then validate response code received

Scenario: Validate response code of incorrect symbols 
Given API for foreign exchange with symbols
When posted with incorrect symbols
Then validate response code for symbols

Scenario: Get the base currency for getting exchange rates
Given API for foreign exchange with base currency
When posted with incorrect base currency
Then validate response code for given base currency

Scenario: Get Specific exchange rate by setting the base and symbols parameter 
Given API for foreign exchange with base and symbols
When posted with incorrect base and symbols
Then validate response code for base currency and symbols