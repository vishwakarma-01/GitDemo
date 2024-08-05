import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import files.payLoad;
import io.restassured.RestAssured;

public class BasicEndToEndWithPayLoadDifferentPackage {
	public static void main (String [] arg) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		given().log().all().queryParam("key", "qaclick123")
		.header("Content-Type","application/json")
		.body(payLoad.addPlace())
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.52 (Ubuntu)");
	}

}
