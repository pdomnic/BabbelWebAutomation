Feature: Register new user test



Scenario Outline: New user registration

Given user is already in home page
When user select display language "<display_language>"
Then user click register button
Then user select language to learn "<language_to_learn>"
Then user click continue button after language to learn select
Then user enter "<first_name>" and "<email>"
Then user click continue button
Then user enter password "<password>"
Then user click confirm registration
Then user click latter email confirmation
Then verify user welcome dashboard message
Then verify welcome course dashboard message
Then check start lession is visible
Then user log out from the session


Examples:
	| display_language | language_to_learn | first_name | email 	 | password  |
	| ENG			   | French			   | Paul		| @gmail.com | Password1 |