Feature: Register user with Facebook or Google account
Register user with Facebook or Google account

Scenario Outline: New user registration through Facebook or Google

Given enter the babbel url
Then click register button
Then select language to learn "<language_to_learn>"
Then click continue button after language to learn select
Then click auth provider "<auth_provider>"

Examples:
	| display_language | language_to_learn | auth_provider 	|
	| ENG			   | French			   | google			|
	| ENG			   | French			   | facebook		|