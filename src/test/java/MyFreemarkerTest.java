import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import junit.framework.TestCase;

import org.json.JSONArray;
import org.json.JSONObject;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;


public class MyFreemarkerTest extends TestCase{

	/**
	 * @param args
	 * @throws IOException 
	 * @throws TemplateException 
	 */
	public static void testFreemarker() throws IOException, TemplateException {
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
        assertEquals("Hi jsss hello jhaldia your home is "+System.getProperty("user.home").replace("\\","/"),ret);
	}

}
