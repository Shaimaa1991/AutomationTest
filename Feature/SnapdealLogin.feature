Feature: Login actions

Scenario Outline: successful login with valid credentials 

Given the login page is opened
When view the login page
And the user enter "<username>" and "<password>"
Then the successful message is appeared


Examples:
| username | password |
| tomsmith | SuperSecretPassword |

