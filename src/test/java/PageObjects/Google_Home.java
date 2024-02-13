package PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Google_Home extends BasePage {

	public Google_Home(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
@FindBy(xpath="//textarea[@title='Search']")
WebElement google_searchinput;


@FindBy(xpath="(//input[@value='Google Search'][@role='button'])[1]")
WebElement google_search_click;


@FindBy(xpath="//a[@href='https://mail.google.com/mail/&ogbl']")
WebElement gmail_link;

@FindBy(xpath="//img[@alt='Google'][@class='lnXdpd']")
WebElement google_logo;


@FindBy(xpath="//a[@href='https://www.google.com/imghp?hl=en&ogbl']")
WebElement google_images;

@FindBy(xpath="//h3[contains(text(),'EMI Calculator for Home Loan, Car Loan & Personal Loan in ...')]")
WebElement calculator_link ;


//action methods
  public void search_input() throws InterruptedException, IOException
  {
	  //search for a website in google homepage
	  fluentWait(google_searchinput);
	  google_searchinput.click();
//	  google_searchinput.clear();

	
	  google_searchinput.sendKeys("emi calculator");
	  
	  Thread.sleep(1000);
  }
  
  public void initiate_search()
  {
	  // searching for the given input
	  fluentWait(google_search_click);
	  google_search_click.click();
  }
  public void open_website() throws InterruptedException, IOException 
  {
	  // clicking on the website on which we will be working
	  Thread.sleep(2000);
	  calculator_link.click();
	  
	  //website is opened 
	
	  String Page=driver.getTitle();
	  //printing title of page
	System.out.println("Ttile of the 1st page is : \n "+Page);
	
	  Thread.sleep(1000);
	  
	  //refreshing the page
	  driver.navigate().refresh();
	  Thread.sleep(1000);
  }
  
  
 

}
