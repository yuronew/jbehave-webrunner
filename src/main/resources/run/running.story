Scenario: Not all required fields was filled #2
Given user request site
When user fill in the form with userTest, , qwerty777
Then verify message is "can't be blank"

Scenario: There is an account registered on this email #1
Given user request site
When user fill in the form with userTest-1, usertesty8@gmail.com, qwerty777
Then verify message is "Email is already taken"

