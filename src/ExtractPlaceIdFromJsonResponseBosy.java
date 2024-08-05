import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import files.payLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class ExtractPlaceIdFromJsonResponseBosy {
	public static void main (String [] arg) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		//ADD POST
		String response =given().log().all().queryParam("key", "qaclick123")
		.header("Content-Type","application/json")
		.body(payLoad.addPlace())
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();
		System.out.println(response);
		JsonPath js =new JsonPath(response); // to parsing
		String placeID=js.getString("place_id");
		System.out.println(placeID);
		
		//UPDATE PUT
		String newAddress="Summer Walk, Africa";
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"place_id\": \""+placeID+"\",\r\n"
				+ "    \"address\":\""+newAddress+"\",\r\n"
				+ "    \"key\":\"qaclick123\"\r\n"
				+ "}")
         .when().put("maps/api/place/add/json")
         .then().log().all().assertThat().statusCode(200).body("msg", equalTo("Address successfully updated"));
		
		//GET PLACE
		String getPlaceResponse=given().log().all().queryParam("key", "qaclick123")
		.queryParam("place_id", placeID)
		.when().get("maps/api/place/get/json")
		.then().assertThat().statusCode(200).extract().response().asString();
		JsonPath js1 =new JsonPath(getPlaceResponse); // to parsing
		String actualAddress=js.getString("place_id");
		System.out.println(actualAddress);
		
	}
}
