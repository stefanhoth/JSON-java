package org.json.tests;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class EmptyObject {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		   Collection<Object> collection = new ArrayList<Object>();
           Map<String, Object> map = new HashMap<String, Object>();
           JSONObject  jsonobject = null;// new JSONObject(string);
           jsonobject = new JSONObject(map);
           JSONArray jsonarray = new JSONArray(collection);
           jsonobject.append("stooge", "Joe DeRita");
           jsonobject.append("stooge", "Shemp");
           jsonobject.accumulate("stooges", "Curly");
           jsonobject.accumulate("stooges", "Larry");
           jsonobject.accumulate("stooges", "Moe");
           jsonobject.accumulate("stoogearray", jsonobject.get("stooges"));
           jsonobject.put("map", map);
           jsonobject.put("collection", collection);
           jsonobject.put("array", jsonarray);
           jsonarray.put(map);
           jsonarray.put(collection);
           
		System.out.println(jsonobject.toString());
		
		HashMap hm = new HashMap();
		ArrayList ar = new ArrayList();
		ar.add("sam");
		hm.put("myar",ar);
		ar.add("1");
		System.out.println(hm.toString());
	}

}
