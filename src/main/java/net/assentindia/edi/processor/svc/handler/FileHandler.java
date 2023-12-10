/**
 * 
 */
package net.assentindia.edi.processor.svc.handler;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.invoke.MethodHandles;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXSource;
import javax.xml.transform.stream.StreamResult;

import org.json.JSONObject;
import org.json.XML;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.xml.sax.InputSource;

import com.fasterxml.jackson.databind.ObjectMapper;

import net.assentindia.edi.processor.model.Root;
import net.assentindia.edi.processor.model.health835.Root835;
import net.assentindia.edi.processor.model.health837.Root837;
import net.assentindia.edi.processor.reader.EDIReader;
import net.assentindia.edi.processor.reader.EDIReaderFactory;


/**
 * @author gaaur
 *
 */
@Component
public class FileHandler 
{
	private static final Logger logger = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());
	public Root handleFile(File file)
	{
		InputStream stream;
		Root root =null;
		try {
			stream = new FileInputStream(file);
			EDIReader ediReader = EDIReaderFactory.createEDIReader(new InputSource(stream));
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			//SAXSource source = new SAXSource(ediReader,new InputSource(stream));
			
			//Transformer transformer = TransformerFactory.newInstance().newTransformer();
			
			//StreamResult result = new StreamResult(baos);
			
			//transformer.transform(source, result);
			
			logger.info("Generated XML {}", new String(baos.toByteArray()));
			
			JSONObject xmlJSONObj = XML.toJSONObject(new String(baos.toByteArray()));
			
			int docType=xmlJSONObj.getJSONObject("ediroot").getJSONObject("interchange").getJSONObject("group").getJSONObject("transaction").getInt("DocType");
			
			ObjectMapper objectMapper = new ObjectMapper();
			
			if(docType==837)
			{
				root =objectMapper.readValue(xmlJSONObj.toString(4), Root837.class);
			}
			//else if(docType==835)
			//{
			//	root =objectMapper.readValue(xmlJSONObj.toString(4), Root835.class);
			//}
			//else
			//{
				//Unknown DocType
			//}
			
			baos.flush();
			baos.close();
			stream.close();
			//String jsonPrettyPrintString = xmlJSONObj.toString(4);
            //System.out.println(jsonPrettyPrintString);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return root;
	}
}
