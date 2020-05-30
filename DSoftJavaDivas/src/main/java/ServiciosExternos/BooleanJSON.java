package ServiciosExternos;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import scala.collection.mutable.SynchronizedSet;

public class BooleanJSON implements Print {

	private Object content;
	private JSONParser parser;

	public BooleanJSON(String content) throws ParseException {
		
		// We need to parse the input as data is coming from python
		this.parser = new JSONParser();

		JSONObject json = (JSONObject) parser.parse(content);
	
		this.content = json.get("Result");
	
	}

	public Object getContent() {
		return content;
	}

	public void setResult(String content) {
		this.content = content;
	}

	public boolean getContentBoolean() {
	
		boolean resp = ((Boolean) content).booleanValue();
		return resp;
	}

	@Override
	public void print() {
		System.out.println("Content of Simple_pass_result class is: " + this.content);
	}

}