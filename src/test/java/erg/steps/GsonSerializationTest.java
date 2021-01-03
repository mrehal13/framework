package erg.steps;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import pojo.GetMyResponse;

public class GsonSerializationTest {
	
	WebDriver driver;

	//@Test
	public void gsonDeserializeTest() throws Exception{

		System.out.println("inside test");
		String strResponse = given().when().get("http://ergast.com/api/f1/2008/1.json").then().extract().asString();
		
		Gson gson = new Gson();
		System.out.println("gson object created");
		GetMyResponse gmr = gson.fromJson(strResponse, GetMyResponse.class);
		System.out.println(gmr.getMRData().getRaceTable().getSeason());
		
		//code to serialize java object
		//given().body(gson.toJson(gmr)).log().all().when().get("http://ergast.com/api/f1/2008/1.json");

	}
	
	//@Test
	public void jacksonDesrializeTest() throws Exception{

		String strResponse1 = given().when().get("http://ergast.com/api/f1/2008/1.json").then().extract().asString();

		ObjectMapper objMapper = new ObjectMapper();
		GetMyResponse gmrJacksone = objMapper.readValue(strResponse1, GetMyResponse.class);
		System.out.println(gmrJacksone.getMRData().getLimit());
	}
}
