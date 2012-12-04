

import org.json.JSONException;
import org.json.XML;

public class IdctXMLTest {

	/**
	 * @param args
	 * @throws JSONException 
	 */
	public static void main(String[] args) throws JSONException {
		String xmlData = "<?xml version=\"1.0\"?><IDCT><TRANS_CODE>CUSSU1</TRANS_CODE><IDCT_ID>EZAMEXCUSTOMER_374754500002753_1353657676246</IDCT_ID><DATETIME>Fri N" + 
				"ov 23 13:31:16 IST 2012</DATETIME><NET_ID>374754500002753</NET_ID><MESSAGE_VER_NO>1.0</MESSAGE_VER_NO><CHANNEL_ID>WEB</CHANNEL_ID><MESSAGE_DIGEST>" + 
				"NO_DATA</MESSAGE_DIGEST><IDCT_STATUS>XML_PROCESSED</IDCT_STATUS><IDCT_ERR_CODE>NO_DATA</IDCT_ERR_CODE><IDCT_MESSAGE_TYPE>02</IDCT_MESSAGE_TYPE><ID" + 
				"CT_DATA><FF0024>520.00</FF0024><FF0026>374754500002753</FF0026></IDCT_DATA></IDCT>";
		
		System.out.println("Orig XML:"+xmlData);
		System.out.println(XML.toJSONObject(xmlData).toString(2));
		System.out.println(XML.toString(XML.toJSONObject(xmlData)));

		
	}

}
