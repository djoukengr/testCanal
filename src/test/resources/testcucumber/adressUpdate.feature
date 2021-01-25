#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template


Feature: update subscriber address
  
  Scenario Outline: Change address of a subscriber residing in France
    Given subscriber "<nom>" "<prenom>" is created with "<address>" in "<country>"
    And having "<numberof>" contracts 
    When subscriber address changes to "<newaddress>"
    Then check that all subscriber's contract address has changed to "<newaddress>"
    And check that new history entry is created with "<newaddress>"
    
    Examples: 
    |nom     |prenom |numberof |country |address                            |newaddress                       | 
    |DJOUKENG|Romeo  |2        |France  |Avenue Beaucour (75008)            |107 Boulevard de Mondetour 91400 |
    |VOGT    |FXavier|0        |France  |Avenue du Parc-des-Princes (75116) |10 Rue de Bretagne 92140         |
    
    Scenario Outline: Change address of a subscriber not residing in France
    Given  subscriber "<nom>" "<prenom>" is created with "<address>" in "<country>"
    And having "<numberof>" contracts 
    When subscriber address changes to "<newaddress>"
    Then check that only the first subscriber's contract address has changed to "<newaddress>"
    And check that new history entry is created with "<newaddress>"
    
    Examples: 
    |nom     |prenom   |numberof |country    |address     |newaddress            | 
    |ZEUFACK |Hermann  |2        |Cameroun   |Douala PK11 |Makepe Sainte Monique |
    