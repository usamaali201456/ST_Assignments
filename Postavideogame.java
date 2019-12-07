package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.util.HashMap;


public class Postavideogame {

	@Test
	public void test_addnewvideogame()
	{
		HashMap data=new HashMap();
		data.put("id","10");
		data.put("name","harrypoter");
		data.put("releaseDate","2019-11-8");
		data.put("reviewScore","4");
		data.put("category","Adventure");
		data.put("rating","Universal");
		
		Response res=
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("http://localhost:8080/app/videogames")
		
		.then()
			.statusCode(200)
			.log().body()
			.extract().response();
		
		String jsonString=res.asString();
		Assert.assertEquals(jsonString.concat("Record Added Successfully"),true);
		
	}
	
}
