Feature: hello
	user shoyuld be able to login


Scenario Outline: Verify response for api specific year multiple
Given user hits the api with year as <year> and round as <round>
Then verify response status
And verify response line
And verify "MRData.RaceTable.season" in response body is <year>
And verify "MRData.RaceTable.round" in response body is <round>
And verify the json-schema of response
Examples:
|year|round|
|2008|1|
|2010|1|