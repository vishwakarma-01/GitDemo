import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class BasicEndToEnd {
	public static void main (String [] arg) {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		given().log().all().queryParam("key", "qaclick123")
		.header("Content-Type","application/json")
		.body("{\r\n"
				+ "  \"location\": {\r\n"
				+ "		\"lat\": -38.383494,\r\n"
				+ "		\"lng\": 33.4227362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\":50,\r\n"
				+ "  \"name\": \"Rahul Shetty Academy\",\r\n"
				+ "  \"phone_number\" : \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\":\"29, side layout, cohen09\",\r\n"
				+ "  \"type\" : [\r\n"
				+ "            \"shoe park\",\r\n"
				+ "			\"shop\"\r\n"
				+ "		  ],\r\n"
				+ "   \"website\": \"http://rahulshettyacademy.com\",\r\n"
				+ "   \"language\" : \"French-IN\"   \r\n"
				+ "}")
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.52 (Ubuntu)");
	}

}
