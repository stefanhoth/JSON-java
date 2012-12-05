#This JSON library for java is a fork from in Java [package org.json] Douglas Crockford

The key changes are:
##JSONObject is extended from LinkedHashMap ##

* Ensures order of elements
* Enables the normal HashMap methods to be available although most of them were overridden in earlier implementation like keys() and keySet()
* Main reason to do this is to enable libraries which works on HashMap and ArrayLists to be able to work on JSONObject
* json-lib project implements Map which is probably an even better approach. But it also gets the same benefits as above point.

> Known Issue:
> *In JDK7 The order of elements serialized from a bean or local ResourceBundle provided through a class will not maintian the order of elements in JSONObject.
> This is because in JDK 7 getDeclaredMethods() does not retrieve the methods in order it is random and can vary from time to time. A bug was logged for jdk but was rejected as wont fix. 
> In JDK6 and lower versions the order is maintained however this is a feature not mentioned in specifications of jdk.  

##JSONArray extends from ArrayList##
* This in combination with JSONObjects extends from LinkedHashMap enables the whole library to be usable in a generic way where other libraries which uses model data in any combination of Map<String, Object> and List<Object> for example Map<String,List<Object>>.


##XML to JSON Serialization##
* Attributes are marked with a '@' prepended to the key
* Content element is marked with a '#' prepended to the key
* Since the json keeps order of the original xml elements it can be deserialized back to same xml.
 

An xml of format 

	<root><person fname="samarjit" lname="samanta" >normal text</person></root>
	
will serialize to 

	{"root":{"person":{"@fname":"samarjit","@lname":"samanta","#content":"normal text"}}}
	
	
In earlier version it used to serialize to 

	{"root":{"person":{"fname":"samarjit","lname":"samanta","content":"normal text"}}}	

##JSON to XML Serialization##  
	
Since we have the attribute marked in the json, we can create back the exact xml
if input xml is

	{"root":{"person":{"@fname":"samarjit","@lname":"samanta","#content":"normal text"}}}
	
this will produce	

	<root><person fname="samarjit" lname="samanta">normal text</person></root>
	
old version of JSON eg. release version 20090211 or before will produce

Since the json produced is  
	{"root":{"person":{"content":"normal text","lname":"samanta","fname":"samarjit"}}}
It will produce	
	<root><person>normal text<lname>samanta</lname><fname>samarjit</fname></person></root>
			
			
Example of libraries that uses model as combination of Map<String,Object> and List<Object> and arbitrary java beans.

### Freemarker ###
		String templateExpression = "Hi ${ddd} hello ${ar[0]} your home is ${USER_HOME}";

		Template t = new Template("name", new StringReader(templateExpression), new Configuration());
		StringWriter out = new StringWriter();
		
		JSONObject jobj1 = new JSONObject();
		jobj1.put("ddd","jsss");
		JSONArray ar =  new JSONArray("['jhaldia','jdob']");
		jobj1.put("ar", ar);
		jobj1.put("USER_HOME", System.getProperty("user.home").replace("\\","/"));
			
		t.process(jobj1, out );
		
		String ret = out.toString(); 
		
		System.out.println(ret);
Result		
This version produces
		Hi jsss hello jhaldia your home is C:/Users/Samarjit
		
Earlier version json: 	
		Hi jsss hello [ your home is C:/Users/Samarjit

		
		
### Ognl ###		
   		JSONObject jobj1 = new JSONObject();
		jobj1.put("ddd","jsss");
		JSONArray ar =  new JSONArray("['jhaldia','jdob']");
		jobj1.put("ar", ar);
		System.out.println(Ognl.getValue("ar[0]", rootObject , jobj1 ));	
		Object obj2 =  Ognl.getValue("someBean.sss",context);
		System.out.println(obj2);
		
Result
This version produces
		jhaldia
		dddd
		
Earlier version json		
  		ognl.NoSuchPropertyException: org.json.JSONObject.ar



Please refer to the original README for other functions. 
  						 		