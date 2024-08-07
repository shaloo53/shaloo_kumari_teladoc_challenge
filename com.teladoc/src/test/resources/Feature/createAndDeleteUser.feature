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

Feature: Create and delete user

  Scenario: Create new user
 Given Launch url
 When Click on add user button
 Then Form will open
 And Enter the user details
 |FirstName|LastName|UserName|Password|Customer|Role|E-mail|CellPhone|
 |shaloo|Kumari|ShalooK|sh@loo|Company AAA|Sales Team|sk@yahoo.com|1234589890|
 And Click on Save button
 And Verify the user has been added to the table
 
  Scenario: Delete user
 Given Launch url
 When click on cross icon corresponding to user "novak"
 Then click on ok button of confirmation dialog box
 And Verify that user got deleted from the table
