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
 
 @smoke
 Scenario Outline: Create new user using scenario outline
 Given Launch url
 When Click on add user button
 Then Form will open
 And I enter the first name "<FirstName>", last name "<LastName>", username "<UserName>", password "<Password>", customer "<Customer>", role "<Role>", email "<E-mail>", and cellphone "<CellPhone>"
 And Click on Save button
 And Verify the user has been added to the table
 Examples:
|FirstName|LastName|UserName|Password|Customer|Role|E-mail|CellPhone|
|shaloo|Kumari|ShalooK|sh@loo|Company AAA|Sales Team|sk@yahoo.com|1234589890|
 