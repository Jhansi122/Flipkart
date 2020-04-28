package Screenshot;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenshotLibraryTest 
{
	//stffh
   public static void Screenshots(WebDriver driver, String Screenshot)
   {
	   try {
		TakesScreenshot ts = (TakesScreenshot)driver;
		   File src = ts.getScreenshotAs(OutputType.FILE);
		   FileHandler.copy(src, new File("./Screenshots/" + Screenshot + ".png"));
	} 
	   
	 catch (IOException e) 
	   {
		
		e.printStackTrace();
	}
	   
   }
}
