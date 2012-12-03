import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONML;
import org.json.JSONObject;



 
 

public class MyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//{"stooge":"Shemp","map":null,"stooges":["Curly","Larry","Moe"],"collection":[],
		//"stoogearray":[["Curly","Larry","Moe"]],"array":[null,null]}
//{"stooge":"Shemp","stooges":["Curly","Larry","Moe"],"stoogearray":["Curly","Larry","Moe"],"array":[]}
		
       /* Collection<Object> collection = new ArrayList<Object>();
        Map<String, Object> map =  new HashMap<String, Object>();

        JSONObject jsonobject = new JSONObject(map);
        JSONArray jsonarray = new JSONArray(collection);
        jsonobject.put("stooge", "Joe DeRita");
        jsonobject.put("stooge", "Shemp");
        jsonobject.accumulate("stooges", "Curly");
        jsonobject.accumulate("stooges", "Larry");
        jsonobject.accumulate("stooges", "Moe");
        jsonobject.accumulate("stoogearray", jsonobject.get("stooges"));
        jsonobject.put("map", map);
        jsonobject.put("collection", collection);
        jsonobject.put("array", jsonarray);
        jsonarray.add(map);
        jsonarray.add(collection);
        
		System.out.println(jsonobject.toString());

		 String string = "<recipe name=\"bread\" prep_time=\"5 mins\" cook_time=\"3 hours\"> <title>Basic bread</title> <ingredient amount=\"8\" unit=\"dL\">Flour</ingredient> <ingredient amount=\"10\" unit=\"grams\">Yeast</ingredient> <ingredient amount=\"4\" unit=\"dL\" state=\"warm\">Water</ingredient> <ingredient amount=\"1\" unit=\"teaspoon\">Salt</ingredient> <instructions> <step>Mix all ingredients together.</step> <step>Knead thoroughly.</step> <step>Cover with a cloth, and leave for one hour in warm room.</step> <step>Knead again.</step> <step>Place in a bread baking tin.</step> <step>Cover with a cloth, and leave for one hour in warm room.</step> <step>Bake in the oven at 180(degrees)C for 30 minutes.</step> </instructions> </recipe> ";

        jsonobject = JSONML.toJSONObject(string);
       
		System.out.println(jsonobject.toString());
		System.out.println( JSONML.toString(jsonobject));
		
		jsonarray = JSONML.toJSONArray(string);
		System.out.println(jsonarray);*/
		JSONObject jsonobject = new JSONObject();
    	JSONObject localobj = new JSONObject();
    	localobj.put("a","old");
    	jsonobject.put("passre",localobj);
		localobj.put("b","new");
		System.out.println(jsonobject.toString());
	}

}
