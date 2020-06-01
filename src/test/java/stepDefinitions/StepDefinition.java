package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resorces.APIResources;
import resorces.TestDataBuild;
import resorces.Utils;

public class StepDefinition extends Utils{
	RequestSpecification res;
	ResponseSpecification resspec;
	Response response;
	@Given("Add Place Payload with {string}  {string} {string}")
	public void add_Place_Payload_with(String name, String language, String address) throws IOException {
		TestDataBuild tb=new TestDataBuild();
		
	 res = given().spec(requestSpecification()).body(tb.addPlacePlayLoad(name,language,address));
	}

	@When("user calls {string}  with {string} HTTP request")
	public void user_calls_with_HTTP_request(String resource, String method)  {
		//constructor will be called with value of resource which you pass
				APIResources resourceAPI=APIResources.valueOf(resource);
				System.out.println(resourceAPI.getResource());
		
		 resspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		 response=res.when().post("/maps/api/place/add/json").
				then().spec(resspec).extract().response();
	}

	@Then("the response call is success with status code {int}")
	public void the_response_call_is_success_with_status_code(Integer int1) {
		assertEquals(response.getStatusCode(),200);
	}

	@Then("{string} in response boby is {string}")
	public void in_response_boby_is(String keyvalue, String expectedvalue) {
	 String resp= response.getBody().asString();
	 System.out.println(resp);
	JsonPath js= new JsonPath (resp);
System.out.println(js.get(keyvalue).toString());
	// assertEquals(js.get(keyvalue).toString(),expectedvalue);
	 
	}
	@Then("{string} in response body is {string}")
	public void in_response_body_is(String string, String string2) {
	    System.out.println("its done");
	}
}
