package testcases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;



public class GetaParticularGame {

	@Test
	public void getagamebyid()
	{
        given()       //no prerequisite
		.when()
			.get("http://localhost:8080/app/10")
		.then()    //for validation
			.statusCode(200)
			.log().body()
        	.body("videoGame.id",equalTo("10"))
        	.body("VideoGame.name",equalTo("harrypoter"));
	}
}
