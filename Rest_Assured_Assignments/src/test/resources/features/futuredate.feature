Feature: Assert the future date provided at specified date in Foreign  Exchange rates api

Scenario: Assert the Response of  Specific date foreign exchange rate api with future date
Given API with future date for foreign exchange rates
When posted with future date
Then Assert the response with current date