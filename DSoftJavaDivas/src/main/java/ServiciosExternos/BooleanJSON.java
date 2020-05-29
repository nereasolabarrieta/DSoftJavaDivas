package ServiciosExternos;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import scala.collection.mutable.SynchronizedSet;

public class BooleanJSON implements Print {

	private Object content;
	private JSONParser parser;

	public BooleanJSON(String content) throws ParseException {
		System.out.println("llego al constr");
		// We need to parse the input as data is coming from python
		this.parser = new JSONParser();
		System.out.println("1");
		JSONObject json = (JSONObject) parser.parse(content);
		System.out.println("2");
		this.content = json.get("Result");
		System.out.println("3");
	}

	public Object getContent() {
		return content;
	}

	public void setResult(String content) {
		this.content = content;
	}

	public boolean getContentBoolean() {
		System.out.println("LO QUE VOY A PARSEAS VA A SER ESTO ueue ");
		boolean resp = ((Boolean) content).booleanValue();
		return resp;
	}

	@Override
	public void print() {
		System.out.println("Content of Simple_pass_result class is: " + this.content);
	}

}