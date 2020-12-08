Feature: Foreign Exchange API with various exchange rates, symbols and base currency.

Scenario: Validate response code for script and make use oflog() method

Given API for foreign exchange
When posted with correct information 
Then validate response for request using log method


Scenario: Validate response code and make use oflog() method

Given API for foreign exchange with incorrect URI
When posted with incorrect information 
Then validate response code for request using log method
