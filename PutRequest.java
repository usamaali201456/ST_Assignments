package testcases;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class PutRequest {

	@Test
	public void UpdatevideoGame()
	{
		HashMap data=new HashMap();
		data.put("id","20");
		data.put("name","pacman");
		data.put("releaseDate","2019-11-8");
		data.put("reviewScore","4");
		data.put("category","Adventure");
		data.put("rating","Universal");
		
		Response res=
				given()
					.contentType("application/json")
					.body(data)
				.when()
					.put("http://localhost:8080/app/videogames/20")
				
				.then()
					.statusCode(200)
					.log().body()
					.extract().response();
		 			.body("videoGame.id",equalTo("20"))
		 			.body("VideoGame.name",equalTo("pacman"));
				
	}
}
