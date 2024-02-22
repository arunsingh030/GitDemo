Feature: Validating Place API


@AddPlace
Scenario Outline: Verify if place is being succesfully added using AddPlaceAPI
	Given Add Place playload with "<name>" "<language>" "<address>"
	When user calls "addPlaceAPI" with "POST" https request
	Then the API call got success with status code 200
	And "status" in response body is "OK"
	And "scope" in response body is "APP"
	And verify place_id created maps to "<name>" using "getPlaceAPI"
	
Examples:
	|name		|language	|address							|
	|houseAA|english	|world cross center		|
	|houseBB|Hindi		|Second cross center	|
	|houseCC|Telgu		|sea cross center			|
	
@DeletePlace	
Scenario: Verify if delete place functionality is working
Given Deleteplace payload
When user calls "deletePlaceAPI" with "POST" https request
Then the API call got success with status code 200
And "status" in response body is "OK"