Feature: Login actions

Scenario Outline: successful login with valid credentials 

Given The snapdeal website is opened.
When  The user moves to the Sign In button and Hold.
And   The User moves to the Sign In button and click.
And   The user enters valid "Email" and click continue.
And   The user enters the valid "Password" and click LOGIN.
Then  the user is logged in successfully 


Examples:
| Email | Password |
| shaimaa@test.com | P@ssw0rd |

