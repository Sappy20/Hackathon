package PageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;


public class EMI_Calculator extends BasePage {
	Actions actions;


	public EMI_Calculator(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

 // 	calculator type link elements
	@FindBy(xpath="//a[@href='#'][contains(text(),'Home Loan')]")
	WebElement HomeLoan_main ;
	
	@FindBy(xpath="//a[@href='#'][contains(text(),'Personal Loan')]")
	WebElement PersonalLoan_main ;
	
	@FindBy(xpath="//a[@href='#'][contains(text(),'Car Loan')]")
	WebElement CarLoan_main ;
	
	
	// slider elements
	//car loan slider
	@FindBy(xpath="//div[@id='loanamountslider']")
	WebElement CarloanSlider_main ;
	
	
	//interest slider
	@FindBy(xpath="//div[@id='loaninterestslider']")
	WebElement interestSlider_main ;
	
	// tenure slider 
	@FindBy(xpath="//div[@id='loantermslider']")
	WebElement CarLoan_tennureSlider_main ;
	
	
	//Labels
	// carLoanAmount Label element present above slider
		@FindBy(xpath = "//label[@for='loanamount']")
		WebElement carLoanAmountLabelElement;
		
		// Go down the page and there you can find the year  and other lists from the table
		
		// year element  from excel table displayed in page
		@FindBy(xpath = "//td[@id='year2024']") 
		WebElement yearElement;
		
		
		// one month interest amount and principal amount
		// selecting the 1st month from excel table by iterating through xpath of table headers
		@FindBy(xpath = "//tr[@class='row no-margin'][1]/td") 
		// (//tr[@class='row no-margin'])[2]//td
		List<WebElement> listOfMonthInterestAndPrincipalAmountElements;
		
		
		
	
	@FindBy(xpath="//a[@id='menu-item-dropdown-2696']")  // list of dropdown
	 WebElement  CALCULATORS_link ;
	
	// WebElements for validation 
	
	@FindBy(xpath="//a[@title='EMI Calculator Widget']")
	WebElement calculatorwidget ;   // just for validation 
	
	@FindBy(xpath="//a[@href='https://emicalculator.net/category/articles/']")  // for validation
	 WebElement  ARTICLES ;
	
	@FindBy(xpath="//a[@href='https://emicalculator.net/category/reviews/']")  // for validation
	 WebElement  PRODUCT_REVIEWS ;
	
	
	@FindBy(xpath="//a[@href='https://emicalculator.net/category/news-opinion/']")  // for validation
	 WebElement  NEWS_Opinions ;
	
	
	@FindBy(xpath="//ul[@class='dropdown-menu show']")
	List<WebElement>  drp_options ;
	
	
	// Link for dropdown elements with links to go to
	
	@FindBy(xpath="(//a[@href='https://emicalculator.net/home-loan-emi-calculator/'])[1]")
	WebElement HomeLoanCalculator_LINK;
	
	@FindBy(xpath="(//a[@href='https://emicalculator.net/loan-calculator/'])[1]")
	WebElement LoanCalculator_LINK;
	
	@FindBy(xpath="(//a[@href='https://play.google.com/store/apps/details?id=net.emicalculator'])[1]")
	WebElement EMICalculatorAndroidApp_LINK;
	
	
	
	@FindBy(xpath="(//a[@href='https://emicalculator.net/loan-emi-calculation-work/'])[1]")
	WebElement LoanEMICalculator_HELP ;
	
	// Action methods
	
	
	
	// method to validate the car loan page 
		public boolean carLoanAmountElement() {
			return carLoanAmountLabelElement.isDisplayed();
			
		}
					
	public void carloan_click() throws IOException
	{
		
		CarLoan_main.click();
		
		
		//use slider now
				
		
		
		
		
	}
	// method to set car loan amount 
		public void setCarLoanAmount(String amount) {
	 
			actions = new Actions(driver);
	 // getting the size of the slider to implement unitary method later on
			
			int sliderWidth = CarloanSlider_main.getSize().width;
	 
			int pixels = sliderToMove(CarloanSlider_main, Float.parseFloat(amount), 2000000, 0);
	 // using pixels to control slider
			actions.clickAndHold(CarloanSlider_main).moveByOffset(-sliderWidth/2, 0).moveByOffset(pixels, 0).release().perform();
		}
		
		// method to set the loan tenure
		 
		public void setLoanTenure(String tenure) {
			
			// getting the total length of slider
	 
			int sliderWidth = CarLoan_tennureSlider_main.getSize().width;
	 // using unitary method to select the required position in slider
			int pixels = sliderToMove(CarLoan_tennureSlider_main, Float.parseFloat(tenure), 7, 0);
	 
			actions.clickAndHold(CarLoan_tennureSlider_main).moveByOffset(-sliderWidth/2, 0).moveByOffset(pixels, 0).release().perform();
	 
		}
	 
		
		// method to move the slider based on the value 
		// paramaterizing  the method to use the parameters as applicable
		
		public int sliderToMove(WebElement sliderElement, float value, float sliderMax, float sliderMin)
		{
	 // using float type variable to allow decimal values
			int pixels = 0;
			// using unitary method to calculate accurate position
			float tempPixels = sliderElement.getSize().width;
			
			
			
			tempPixels = tempPixels/(sliderMax-sliderMin);
			tempPixels = tempPixels*((value)-sliderMin);
	 
			pixels = Math.round(tempPixels);
			return pixels;
	 
		}
		
		// method to click on the year
		
		public void clickOnYear() {
			scrollIntoView(yearElement);
			fluentWait(yearElement);
			yearElement.click();
		}
		
		// method to scroll 
		public void scrollIntoView(WebElement element) {
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("arguments[0].scrollIntoView();",element);
		}
		
		
		// method to read the interest amount and principal amount for one month
		public void readData() {
	 
			System.out.println("Car Loan");
			System.out.println("Month" + "   " + "Interest Amount" + "   " + "Principal Amount");
	 
			int i=1;
	 
			for(WebElement element:listOfMonthInterestAndPrincipalAmountElements) {
				if(i<4) {
					
					// printing 1 month and related data upon expanding the excel table
					System.out.print(element.getText()+"\t");
					i++;
				}
			}
	 
			System.out.println();
			System.out.println("\n");
	 
		}
	 	
		
	public void page_reload()
	{
		driver.navigate().refresh();
	}
	
	
	
	public void  goToCalculator() throws InterruptedException, IOException
	{
		CALCULATORS_link.click();
		
		Thread.sleep(1000);
		fluentWait(HomeLoanCalculator_LINK);
	
		HomeLoanCalculator_LINK.click();
		Thread.sleep(7000);
		
	}
	
	
}
