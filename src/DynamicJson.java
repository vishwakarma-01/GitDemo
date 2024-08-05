import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;
import files.payLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
public class DynamicJson {
	@Test
	public void addBook() 
	{ 
				
		RestAssured.baseURI = "http://216.10.245.166";
		String response=given().log().all().header("Content-Type", "application/json")
		.body(payLoad.addBook())
		.when().post("/Library/Addbook.php")
		.then().assertThat().statusCode(200)
		.extract().response().asString();
		JsonPath js =new JsonPath(response);
		String id = js.get("ID");
		System.out.println(id);
		
	}

}
