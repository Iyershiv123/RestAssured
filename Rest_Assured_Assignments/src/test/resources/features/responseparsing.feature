Feature: Foreign Exchange Reference Rate

Scenario: Get the latest foreign exchange reference rates
Given API for foreign exchange
When posted with correct information
Then validate positive response received

Scenario: Get the latest foreign exchange reference rates with base
Given API for foreign exchange with base
When posted with correct information on base
Then validate positive response received for given base

Scenario: Get the latest foreign exchange reference rates with symbols
Given API for foreign exchange with symbols
When posted with correct information on symbols
Then validate positive response received for given symbols

Scenario: Get the latest foreign exchange reference rates with symbols and bases
Given API for foreign exchange with symbols and base
When posted with correct information on symbols and base
Then validate positive response received for given symbols an base