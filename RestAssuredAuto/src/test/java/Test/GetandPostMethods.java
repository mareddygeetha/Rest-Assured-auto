package Test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;



public class GetandPostMethods {

	@Test
	public void getMethod()
	{
		baseURI="https://reqres.in/";
		
		given().
			get("/api/users?page=2").
		then().
			body("data[1].first_name",equalTo("Lindsay")).
			statusCode(200);
		
	}
	
	@Test
	public void postMethod()
	{
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("name", "Geetha");
//		map.put("job", "engineer");
//		System.out.println(map);
		
		JSONObject request=new JSONObject();
		request.put("name", "Geetha");
		request.put("job", "Engineer");
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/";
		
		given().
			header("content-Type","application/json").
			body(request.toJSONString()).
		when().
		 post("/api/users").
		then().
			statusCode(201).log().all();
		
		
		
		
	}
	
	public void testPutMethod()
	{
	
		JSONObject request = new JSONObject();
		request.put("email", "test@gmail.com");
		request.put("password", "xyzzz");
		
		
		baseURI = "https://reqres.in/";
		given().
		body(request).
		header("content-Type","application/json").
	when().
	post("/api/register").
	then().
	statusCode(201).log().all();
		
		
	
	}
}
