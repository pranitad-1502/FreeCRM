@tag
Feature:  Freecrm login
	@sk1
	Scenario: Verify login button
	Given User navigate to the freecrm website
	When freecrm is opened 
	And login button is clicked
	Then navigates to login webpage 
	
	@sk2
	Scenario:
	Given User navigate to the login page 
		
	@sk3
	Scenario Outline: Login with invalid credentials
	When User gives input
	Then User should not see the Cogmento CRM homepage
	Examples:
	|e1			     |p1	  |
	|sofiakh12ail.com|@23456  |

	@sk4
	Scenario Outline: Login with blank field
	When User leaves field blank 
	Then User should not see the Cogmento CRM homepage and it display Invalid login
	Examples:
	|e2				|p2		  |
	|				|		  |

	@sk5
	Scenario Outline: Login with valid credentials
	When User enter correct <email> and correct <password>
	Then User should see the Cogmento CRM homepage
	Examples:
	|email			   |password |
	|s7380519@gmail.com|Freecrm01|