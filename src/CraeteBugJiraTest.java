import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import java.io.File;

public class CraeteBugJiraTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI="https://rv80565.atlassian.net";
				
		String createIssueResponse 	= given()
		.header("Content-Type","application/json")
		.header("Authorization","Basic cnY4MDU2NUBnbWFpbC5jb21BVEFUVDN4RmZHRjBDcHltb1h0OWc4WjdRRWNCUlY3OVpGcFlBaWgzMWlEZkFLMV9KMWt1eVZtNVJrUEJlOXFPUi1DNDZBU3FQS2lGeHlVTmQzc1hLbGI0cTAzYzBxRE9QczhkdjlJZnNJM0tBSW1PVEF6S3hYeUU1UkJxREZJUFlabzlNNjI4WUVxSERBRldjVTQya2dkV3M3cGp0aUpwZFNZVXdoRDg4enF3U1Q2QXZkYjI5akE9Rjc3NDEwMTU=")
		.body("{\r\n"
				+ "    \"fields\": {\r\n"
				+ "        \"project\":\r\n"
				+ "        {\r\n"
				+ "            \"key\": \"SCRUM\"\r\n"
				+ "        },\r\n"
				+ "        \"summary\": \"DropDowns are not working Issue create via Automation\",\r\n"
				+ "        \"issuetype\": {\r\n"
				+ "        \"name\": \"Bug\"\r\n"
				+ "        }\r\n"
				+ "    }\r\n"
				+ "  }")
		.log().all()
		.post("rest/api/3/issue")
		.then().log().all().assertThat().statusCode(201).contentType("application/json")
		.extract().response().asString();
		JsonPath js = new JsonPath(createIssueResponse);
		String issueId = js.getString("id");
		System.out.println(issueId);	
		
		//Add attachment
		given()
		.header("X-Atlassian-Token","no-check")
		.pathParam("key", issueId)
		.header("Authorization","Basic cnY4MDU2NUBnbWFpbC5jb21BVEFUVDN4RmZHRjBDcHltb1h0OWc4WjdRRWNCUlY3OVpGcFlBaWgzMWlEZkFLMV9KMWt1eVZtNVJrUEJlOXFPUi1DNDZBU3FQS2lGeHlVTmQzc1hLbGI0cTAzYzBxRE9QczhkdjlJZnNJM0tBSW1PVEF6S3hYeUU1UkJxREZJUFlabzlNNjI4WUVxSERBRldjVTQya2dkV3M3cGp0aUpwZFNZVXdoRDg4enF3U1Q2QXZkYjI5akE9Rjc3NDEwMTU=")
        .multiPart("file", new File("C:\\Users\\Rahul Vishwakarma\\OneDrive\\Pictures\\Camera Roll.jpg"))
        .log().all()
        .post("rest/api/3/issue/{key}/attachments").then().log().all().assertThat().statusCode(200);
        

	}

}
