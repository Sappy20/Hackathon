package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotClass {
	
	WebDriver driver;
	public ScreenShotClass(WebDriver d) {
		this.driver = d;
	}
	public String screenShot(String s) {
		TakesScreenshot ts  = (TakesScreenshot)driver;
		File srFile = ts.getScreenshotAs(OutputType.FILE);
		String trgFilePath = System.getProperty("user.dir")+"\\screenshots\\sShot"+s+".png";
		File trgFile = new File(System.getProperty("user.dir")+"\\screenshots\\sShot"+s+".png");
		try {
			FileUtils.copyFile(srFile, trgFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Exception Caught : \n"+e.getMessage());
		}
	  	// returning the screenshot file so that can be used in other classes
		return trgFilePath;
	}

}
