package testcases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

public class DeleteRequest {

	@Test
	public void deletebyid()
	{
		Response res=
		 given()       //no prerequisite
			.when()
				.get("http://localhost:8080/app/10")
			.then()    //for validation
				.statusCode(200)
				.log().body()
				.extract().response();
		 
		 String jsonString=res.asString();
		 Assert.assertEquals(jsonString.contains(("Record Deleted Successfully"),true);
    }
}
