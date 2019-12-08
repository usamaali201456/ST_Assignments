package testcases;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetAllVideogames {

	@Test
	public void getallgames()
	{
		given()       //no prerequisite
		
		.when()
			.get("http://localhost:8080/app/videogames")
		.then()    //for validation
			.statusCode(200);
	}
}
