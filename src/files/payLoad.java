package files;

public class payLoad {
	public static String addPlace()
	{
		return "{\r\n"
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
				+ "}";
	}
	public static String courcesPrice()
	{
		// either you can directly return the entire string with return statement or
		return "{\r\n"
				+ "  \"dashboard\": {\r\n"
				+ "    \"purchaseAmount\": 90,\r\n"
				+ "    \"website\": \"rahulshettyacademy.com\"\r\n"
				+ "  },\r\n"
				+ "  \"cources\": [\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"Selenium Python\",\r\n"
				+ "      \"price\": 50,\r\n"
				+ "      \"copies\": 6\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"Cypress\",\r\n"
				+ "      \"price\": 40,\r\n"
				+ "      \"copies\": 4\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"title\": \"RPA\",\r\n"
				+ "      \"price\": 45,\r\n"
				+ "      \"copies\": 10\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";
	}
	public static String addBook()
	{
		// or this time we store a variable and return that variable
		String payload="{\r\n"
				+ "	\"name\": \"Lear Appium Automation with Java\", \r\n"
				+ "	\"isbn\": \"bczd\",\r\n"
				+ "	\"aisle\": \"2270\",\r\n"
				+ "	\"author\": \"John foe\"  \r\n"
				+ "}";
		return payload;
	}
	public static String addBook1(String isbn, String aisle)
	{
		// or this time we store a variable and return that variable
		String payload1="{\r\n"
				+ "	\"name\": \"Lear Appium Automation with Java\", \r\n"
				+ "	\"isbn\": \""+isbn+"\",\r\n"
				+ "	\"aisle\": \""+aisle+"\",\r\n"
				+ "	\"author\": \"John foe\"  \r\n"
				+ "}";
		return payload1;
	}
}
