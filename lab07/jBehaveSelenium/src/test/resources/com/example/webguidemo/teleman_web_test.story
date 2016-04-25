Scenario: Test Practiceform page

Given user is on Home page
When user click setup first project link
Then proper page is shown

When user click Submit
Then required field alert validator is shown

When user click alert button
Then alert popup is shown