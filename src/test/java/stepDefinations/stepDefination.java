package stepDefinations;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resourses.APIResources;
import resourses.TestDataBuild;
import resourses.Utils;



public class stepDefination extends Utils {
	RequestSpecification res;
	ResponseSpecification resSpec;
	Response response;
	TestDataBuild data = new TestDataBuild();
	static String place_id;
	
	@Given("Add Place playload with {string} {string} {string}")
	public void add_place_playload_with(String name, String language, String address) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		//RestAssured.baseURI ="https://rahulshettyacademy.com";
	    res =given().spec(requestSpecification())
			   .body(data.addPlacePayload(name, language, address)); //.log().all();
	   
	}
	
	/*
	@Given("Add Place playload")
	public void add_place_playload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		//RestAssured.baseURI ="https://rahulshettyacademy.com";
				    res =given().spec(requestSpecification())
						   .body(data.addPlacePayload()).log().all();
	 
	}
	*/

	@When("user calls {string} with {string} https request")
	public void user_calls_with_https_request(String resource, String method) {
	    // Write code here that turns the phrase above into concrete actions
		// constructor will be called with value of resource which you pass
		APIResources resourceAPI= APIResources.valueOf(resource);
		System.out .println("This AddPlace Link: "+resourceAPI.getResource());
		
		resSpec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		if (method.equalsIgnoreCase("POST"))
		{
			response= res.when().log().all().post(resourceAPI.getResource());
		}
		else if(method.equalsIgnoreCase("GET"))
		{
			response= res.when().log().all().get(resourceAPI.getResource());
		}
		   
	}

	@Then("the API call got success with status code {int}")
	public void the_api_call_got_success_with_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(response.statusCode(), 200);
		
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String expectedValue) {
	    // Write code here that turns the phrase above into concrete actions
	   
	    assertEquals(getJsonPath(response,keyValue), expectedValue);
	  }
	
	// get detail of getPlaceAPI 
	
	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String nameExpected, String resource) throws IOException {

		// get API call 
		place_id= getJsonPath(response, "place_id");
		res =given().spec(requestSpecification()).queryParam("place_id", place_id);
		user_calls_with_https_request(resource, "GET");
		String actualName= getJsonPath(response, "name");
		assertEquals(actualName, nameExpected);
	}
	
	// Delete place API
	@Given("Deleteplace payload")
	public void deleteplace_payload() throws IOException {
	   
		res =given().spec(requestSpecification())
				.body(data.deletePlacePayload(place_id));
		
	}

}
