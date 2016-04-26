Scenario: Test Practiceform page

Given user is on Home page

When user click twoDigits Submit without any input
Then this field is required is shown

Given user is on Home page
When user click twoDigits Submit with 2 digits input
Then form submitted message is shown

Given user is on Home page
When user click setup first project link
Then proper page is shown


Given user is on Home page
When user click Submit
Then required field alert validator is shown

Given user is on Home page
When user click alert button
Then alert popup is shown