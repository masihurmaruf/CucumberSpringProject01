Feature: Paxotech Heatclinic Home page Links

@smoke
Scenario: 1. Verify Register Page Link
	Given As a not validated user
		When Browse to the application
		Then Paxotech Heatclinic home page should show
		When User Click the Register Page Link
		Then Register Page Should Show
@smoke
Scenario: 2. Verify Login Page Link
	Given As a not validated user
		When Browse to the application
		Then Paxotech Heatclinic home page should show
		When User click login link
		Then Login Page Should Show		
@smoke		
Scenario: 3. Verify Heatclinic Logo
	Given As a not validated user
		When Browse to the application
		Then Paxotech Heatclinic home page should show
		When User Click the Heatclinic Logo
		Then Paxotech Heatclinic home page should show
@smoke		
Scenario: 4. Verify Home link
	Given As a not validated user
		When Browse to the application
		Then Paxotech Heatclinic home page should show
		When User Click the Home link
		Then Paxotech Heatclinic home page should show
		
Scenario: 5. Verify Hot Sauces link
	Given As a not validated user
		When Browse to the application
		Then Paxotech Heatclinic home page should show
		When User Click the Hot Sauces link
		Then Paxotech Heatclinic Hot Sauces page should show
		
Scenario: 6. Verify Merchandise link
	Given As a not validated user
		When Browse to the application
		Then Paxotech Heatclinic home page should show
		When User Click the Merchandise link
		Then Paxotech Heatclinic Merchandise page should show