package utilti;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileConfig
{
	 static Properties properties=new Properties();

	public static void PropertiesFileLoad()
	{
		
		try
		{
			properties.load(new FileInputStream("Config/avactis.properties"));
		}catch(FileNotFoundException e)
		{
			System.out.println("File Not Found");
		}catch(IOException e)
		{
			System.out.println("IO Exception");
		}
	}
	public static String getProperty(String keyValue)
	{
		return properties.getProperty(keyValue);
	}
}
