package erg.steps;

import static org.junit.Assert.assertEquals;
import static io.restassured.RestAssured.given;
import erg.base.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojo.*;

//import static io.restassured.RestAssured.given;
//import static io.restassured.RestAssured.when;


public class ErgastStepDefination extends BaseClass{	

	String resBody;
	int resCode;
	String resLine;
	Response response;
	GetMyResponse gmr;

	@Given("user hits the api with year as {int} and round as {int}")
	public void user_hits_the_api_with_year_as_and_round_as(Integer year, Integer round) {

		RestAssured.baseURI = "http://ergast.com/api/f1";
		response = given().
				pathParam("year", year).
				pathParam("round", round).
				expect().defaultParser(Parser.JSON).
				when().get("/{year}/{round}.json");

		
		//RequestSpecification httpres = RestAssured.given();		
		//Response response = httpres.request(Method.GET, "/2008/1.json");		
	}

	@Then("verify response status")
	public void verify_response_status() {
		assertEquals(200, response.getStatusCode());
	}

	@Then("verify response line")
	public void verify_response_line() {
		assertEquals("HTTP/1.1 200 OK", response.getStatusLine());
	}

	@Then("verify {string} in response body is {int}")
	public void verify_in_response_body_is(String keyName, Integer expectedValue){

		JsonPath js = new JsonPath(response.getBody().asString());
		assertEquals(expectedValue.toString(), js.get(keyName)); 
			
	}

	@Then("verify the json-schema of response")
	public void verify_the_json_schema_of_response() {
		checkJsonSchema(response, "ergast-schema.json");
		
	}
}
