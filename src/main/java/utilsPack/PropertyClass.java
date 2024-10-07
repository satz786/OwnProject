package utilsPack;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyClass {
public Properties properties;
	public PropertyClass() throws IOException
	{
		FileReader reader = new FileReader("./PropertyFiles/OwnProject.Properties");
		properties = new Properties();
		properties.load(reader);
	}
	
	public String getbrowsername()
	{
		String browsername = properties.getProperty("Browsername");
		return browsername;
	}
	
	
	public String getURL()
	{
		String urlvalue = properties.getProperty("URL");
		return urlvalue;
	}
	
}
