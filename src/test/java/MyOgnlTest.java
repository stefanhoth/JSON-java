import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;
import ognl.Ognl;

import org.json.JSONArray;
import org.json.JSONObject;


public class MyOgnlTest extends TestCase{

	/**
	 * @param args
	 * @throws OgnlException 
	 */
	/**
	 * @param args
	 * @throws Exception
	 */
	public   void testOgnl() throws Exception {
		Map rootObject = new HashMap();
		Map context = new HashMap();
		JSONObject jobj1 = new JSONObject();
        jobj1.put("ddd","jsss");
        JSONArray ar =  new JSONArray("['jhaldia','jdob']");
        jobj1.put("ar", ar);
        context.put("someBean", jobj1);
        System.out.println(Ognl.getValue("ar[0]", rootObject , jobj1 ));    
        assertEquals("jhaldia",Ognl.getValue("ar[0]", rootObject , jobj1 ));
        Object obj2 =  Ognl.getValue("someBean.ddd",context);
        System.out.println(obj2);
        assertEquals("jsss", obj2);

	}

}
