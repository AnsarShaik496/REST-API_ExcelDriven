
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

//import resources.*;
public class HashmapData {

	
	@Test
	public void addBook() throws IOException
	{
		PracticeExcelAnsar d=new PracticeExcelAnsar();
		ArrayList data=d.getData("testdata","DeleteProfile");
		
		
		HashMap<String, Object>  map = new HashMap<>();
		map.put("name", data.get(1));
		map.put("isbn", data.get(2));
		map.put("aisle", data.get(3));
		map.put("author", data.get(4));
		
	/*	HashMap<String, Object>  map2 = new HashMap<>();
		map.put("lat", "12");
		map.put("lng", "34");
		map.put("location", map2);*/
		
		
		RestAssured.baseURI="http://216.10.245.166";
		String resp=given().
				header("Content-Type","application/json").
		body(map).
		when().
		post("/Library/Addbook.php").
		then().assertThat().statusCode(200).
		extract().response().asString();
		
		 JsonPath js= HashmapData.stringToJson(resp);
		   String id=js.get("ID");
		   System.out.println(id);
		
	// Create a place =response (place id)
		
		// delete Place = (Request - Place id)	
		

	}
	
	public static JsonPath stringToJson(String resp) {
		JsonPath js=new JsonPath(resp);
		
		return js;
	}
	
	public static String GenerateStringFromResource(String path) throws IOException {

	    return new String(Files.readAllBytes(Paths.get(path)));

	}
}
