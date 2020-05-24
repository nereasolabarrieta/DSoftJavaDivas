package ServiciosExternos;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class PasswordJSON implements Print
{
	private String content;
    private JSONParser parser;

    public PasswordJSON(String content) throws ParseException {

        // We need to parse the input as data is coming from python
        this.parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(content);
        this.content = (String) json.get("Password");
    }

    public String getContent()
    {
        return content;
    }

    public void setResult(String content)
    {
        this.content = content;
    }

    public long getContentNumber()
    {
        return Long.parseLong(content);
    }
   
    @Override
    public void print() {
        System.out.println("Content of Simple_pass_result class is: " + this.content);
    }

}
