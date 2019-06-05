images.nasa.gov API Testing

https://images.nasa.gov/docs/images.nasa.gov_api_docs.pdf

In this testing application five endpoints are tested. 

API Root:
https://images-api.nasa.gov


API Endpoints:
/search
/asset/{nasa_id}
/metadata/{nasa_id}
/captions/{nasa_id}
/album/{album_name}

Tests are written with Java Spring Boot and JUnit5. In test classes possible scenarios are tested in methods. 

Test Classes: /src/test/java/com/automated/testapi
	AlbumEndpointTest
	AssetEndpointTest
	CaptionsEndpointTest
	MetadataEndpointTest
	SearchEndpointTest

Response Classes Returned From Nasa API: /src/main/java/com/automated/testapi/response
	JSONCollection
	JSONCollectionResponse

Response classes are used to check if the response returned from the api has some valid information or not. 
This is tested by null check or if the size of items field array is greated than zero.

Http Status Codes:
Code Explanation
200 ­ OK Everything worked as expected.
400 ­ Bad Request The request was unacceptable, often due to missing a requiredparameter.
404 ­ Not Found The requested resource doesn’t exist.
500, 502, 503, 504 ­ Server Errors Something went wrong on the API’s end. (These are rare.) 

PS: 5XX codes are not tested because not able to get these reponses currently. 
