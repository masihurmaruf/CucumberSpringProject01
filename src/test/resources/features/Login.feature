Feature: Paxotech Heatclinic Login Functionality

Background:
	Given As a not validated user
		When Browse to the application
		Then Paxotech Heatclinic home page should show



Scenario: 1. Valid user Valid password
		When User click login link
		And Enter "marufrahman1349@gmail.com" as email address
		And Enter "maruf" as password
		And Click login button
		Then Welcome message should display with "Masihur"
		
Scenario: 2. Valid user Invalid password
		When User click login link
		And Enter "marufrahman1349@gmail.com" as email address
		And Enter "maruf_invalid" as password
		And Click login button
		Then Invalid email or password message should display
		
Scenario: 3. Invalid user Valid password
		When User click login link
		And Enter "marufrahman_invalid1349@gmail.com" as email address
		And Enter "maruf" as password
		And Click login button
		Then Invalid email or password message should display
		
Scenario: 4. Valid user Invalid password
		When User click login link
		And Enter "marufrahman_invalid1349@gmail.com" as email address
		And Enter "maruf_invalid" as password
		And Click login button
		Then Invalid email or password message should display
		
Scenario Outline: 5. Valid user Invalid password
		When User click login link
		And Enter "<emailaddress>" as email address
		And Enter "<password>" as password
		And Click login button
		Then Invalid email or password message should display

Examples:

 |emailaddress							|password	  |
 |marufrahman1349@gmail.com				|maruf_invalid|
 |marufrahman1349@gmail.com				|			  |
		

		
