import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import io.restassured.RestAssured;

public class StaticJsonPayLoadFromExternalFile {
	public static void main (String [] arg) throws IOException {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		given().log().all().queryParam("key", "qaclick123")
		.header("Content-Type","application/json")
		.body(new String(Files.readAllBytes(Path.of("C:\\Users\\Rahul Vishwakarma\\OneDrive\\Documents\\Json\\addPlace.json"))))
		.when().post("maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200).body("scope", equalTo("APP"))
		.header("Server", "Apache/2.4.52 (Ubuntu)");
	}

}
