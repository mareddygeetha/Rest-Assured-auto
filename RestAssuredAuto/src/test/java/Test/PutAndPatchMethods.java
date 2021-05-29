package Test;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PutAndPatchMethods {
	
	@Test
	public void putMethod()
	{
		JSONObject request= new JSONObject();
		
		
		request.put("name", "Geetha");

		request.put("job", "Engineer");
			
		baseURI = "https://reqres.in/";
		
		given().
			body(request.toJSONString()).
		when().
			put("/api/users/2").
		then().
		statusCode(200).log().all();
			
		
	}
	
	@Test 
	public void patchMethod()
	{
JSONObject request= new JSONObject();
		
		
		request.put("name", "Geetha");

		request.put("job", "Engineer");
			
		baseURI = "https://reqres.in/";
		
		given().
			body(request.toJSONString()).
		when().
			patch("/api/users/2").
		then().
		statusCode(200).log().all();

	}

}
