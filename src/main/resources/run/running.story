Scenario: Not all required fields was filled
Given user request site
When user fill in the form with userTest, , qwerty777
Then verify message is "can't be blank"

