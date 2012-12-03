import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;



 
 

public class MyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//{"stooge":"Shemp","map":null,"stooges":["Curly","Larry","Moe"],"collection":[],
		//"stoogearray":[["Curly","Larry","Moe"]],"array":[null,null]}
//{"stooge":"Shemp","stooges":["Curly","Larry","Moe"],"stoogearray":["Curly","Larry","Moe"],"array":[]}
		
        Collection<Object> collection = new ArrayList<Object>();
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

	}

}
