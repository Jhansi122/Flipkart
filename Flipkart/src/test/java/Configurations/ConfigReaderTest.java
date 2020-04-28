package Configurations;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReaderTest
{
	//bffip
	Properties pro;
	public ConfigReaderTest() 
	{
       try {
		File src = new File("C:\\Program Files\\Selenium\\Spring tool suite\\Code\\Flipkart\\src\\main\\resources\\Configuration.properties");
		   FileInputStream fis = new FileInputStream(src);
		   pro= new Properties();
		   pro.load(fis);
	}
	 catch (IOException e) 
       {
		
		e.printStackTrace();
	}
	
	}
	
	public String path()
	{
		return pro.getProperty("FirefoxDriver");
		
	}
	
	public String URL()
	{
		return pro.getProperty("URL");
	}
}
