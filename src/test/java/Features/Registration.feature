Feature: Registration

@test1
Scenario: Verify login funtionality with fdgsdvalid credenatils
And user launch site URL
And select allow all from cookie popup and select over 18 age confirmation option
Then user signs in to the site credentials details 'loginValidEmail.key' 'loginValidPassword.key'
And user navigates to Cart page and empty basket


