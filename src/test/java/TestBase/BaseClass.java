package TestBase;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
public class BaseClass {

	public Properties p;
	public Logger logger;
	public static WebDriver driver;
	
	
	
	@BeforeClass(groups={"smoke","sanity","regression","master"})
	@Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException, InterruptedException
	{
		
		// loading properties file
		
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		p= new Properties();
		p.load(file);                    // IO Exception
		
		
		// loading log4j2 file 
		logger=LogManager.getLogger(this.getClass());
		/*
		ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); // Enable headless mode
        // for headless testing just uncomment this part and typecast options to driver
        */
		
		
			// Launching browser based on choice
		switch(br.toLowerCase())
		{
		case "chrome": driver= new ChromeDriver(); break;
		case "edge": driver= new EdgeDriver();  break;
		default : System.out.println(" Wrong input choice !! ");
					return;
		
		}
		
		
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
	}
	
	public String randomString()
	{
		String randomAlphabets = RandomStringUtils.randomAlphabetic(5);
		return randomAlphabets;
	}
	
	public String randomNumber()
	{
		String randomNum = RandomStringUtils.randomNumeric(1);
		return randomNum;
	}
	
	
	public String randomAlphaNumeric()
	{
		String str = RandomStringUtils.randomAlphabetic(3);
		String num = RandomStringUtils.randomNumeric(3);
		return (str+"@"+num);
	}
	
	
	@AfterClass(groups= {"smoke","sanity","regression","master"})
	public void tearDown()
	{
		driver.quit();
	}
	
}
