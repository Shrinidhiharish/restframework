Feature: Validating the Place APIS
Scenario Outline:  Verify that the place is being successfully added using AddPlace API

Given Add Place Payload with "<name>"  "<language>" "<address>"
When user calls "AddPlaceAPI"  with "post" HTTP request 
Then the response call is success with status code 200
And "status" in response boby is "OK"
And "scope" in response body is "APP"

Examples:
|name 	 | language |address		   |
|AAhouse |  English |World cross center|
|BBhouse | Spanish  |Sea cross center  |

 	