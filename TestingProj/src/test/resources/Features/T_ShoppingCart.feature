Feature: feature to Test Shopping Cart

Scenario:Validate Shopping Cart workflo

Given User invokes TestPage
And User navigates to Shopping Cart
And User views "<product>" and adds to cart
When User checkout
And User login
Then User successful checkout and confirmation

Examples:
	|product|
	|Clockwork Doodad 3|