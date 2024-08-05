import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import files.payLoad;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class ParameterInPayLoad {

	@Test
	public void addBook() 
	{ 
				
		RestAssured.baseURI = "http://216.10.245.166";
		String response=given().log().all().header("Content-Type", "application/json")
		.body(payLoad.addBook1("adsfs", "646"))
		.when().post("/Library/Addbook.php")
		.then().assertThat().statusCode(200)
		.extract().response().asString();
		JsonPath js =new JsonPath(response);
		String id = js.get("ID");
		System.out.println(id);
		
	}



}
