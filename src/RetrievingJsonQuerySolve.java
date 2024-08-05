import files.payLoad;
import io.restassured.path.json.JsonPath;

public class RetrievingJsonQuerySolve {

	public static void main(String[] args) {
		
		JsonPath js = new JsonPath(payLoad.courcesPrice());
		//print no of courses return by API
		int courcesSize =js.getInt("cources.size()");
        System.out.println(courcesSize);
        
        // Print purchase amount
        int purchaseAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println(purchaseAmount);
        
        //Print title of first course
       String firstCourse = js.get("cources[0].title").toString();
       System.out.println(firstCourse);
       
       // Print all cources and their respective prices
       
       for(int i=0; i<courcesSize; i++)
       {
    	 String courcesTitles =  js.get("cources["+i+"].title");
    	 System.out.println(courcesTitles);
    	 String courcesPrices =  js.get("cources["+i+"].price").toString();
    	 System.out.println(courcesPrices);	 
       }
       
     //no of copy sold by rpa 
       for(int i=0; i<courcesSize; i++)
       {
    	 String courcesTitleRPA =  js.get("cources["+i+"].title");
    	 if(courcesTitleRPA.equalsIgnoreCase("RPA"))
    	 {
    		int copies = js.get("cources["+i+"].copies");
    	 System.out.println(copies);
    	 break;
    	 }
    	}
       
       //
	}
}










