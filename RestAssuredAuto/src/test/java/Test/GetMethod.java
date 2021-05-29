package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class GetMethod {

	@Test(enabled=false)
	public void test_1()
	{
		Response response=get("https://reqres.in/api/users?page=2");

		System.out.println("response.getStatusCode()::::::   "+response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println("-Response body is ---"+response.getBody().asString());
		System.out.println("Statusline is -----------"+response.getStatusLine());
		System.out.println("Headers are--------" +response.getHeaders());

		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);

	}
	@Test(enabled=false)
	public void getmethod()
	{
		baseURI="https://reqres.in";
		given().get("/api/users?page=2").
		then().body("data[1].id", equalTo(8));

	}
	@Test
	public void getListResourse()
	{
		baseURI="https://reqres.in/";

		Response response = given().get("/api/unknown");
		System.out.println("Response status code   ------ "+response.getStatusCode());
		System.out.println("Body is ........" +response.getBody().asString());
		response.then().body("data[1].id", equalTo(2));
		response.then().body("data[0].name",equalToIgnoringCase("cerulean"));
		response.then().body("data[0].name",equalToIgnoringCase("cerulean")).log().all();
		System.out.println("header Content-Type is ----------"+response.getHeader("Content-Type"));
		System.out.println("headers are................."+response.getHeaders());
		Assert.assertEquals(response.getStatusCode(), 200);

	}

}
