package Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class DeleteMethod {
	@Test
	public void deleteMethod()
	{
		baseURI="https://reqres.in/";
		
		given().
			delete("/api/users/2").
		then().
			statusCode(204);
		
	}
	

}
