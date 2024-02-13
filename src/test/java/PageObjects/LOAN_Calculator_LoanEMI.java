package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LOAN_Calculator_LoanEMI  extends BasePage{

	public LOAN_Calculator_LoanEMI(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	// 2ND PAGE
	
	// PAGE HEADING
	@FindBy(xpath="//div[@class='page-header']/h1")
	WebElement PageHeading  ;

	// DASHBOARD HEADINGS FOR DIFFERENT CALCULATORS 
	@FindBy(xpath="//div[@id='loancalculatordashboard']/ul/li")
	WebElement EMICalculator_LOGO  ;

	
	@FindBy(xpath="//li[@id='loan-amount-calc']")
	WebElement  LoanAmount_CALCULATOR_LOGO ;

	
	@FindBy(xpath="//li[@id='loan-tenure-calc']")
	WebElement  Loan_Tennure_CALCULATOR_LOGO ;

	
	@FindBy(xpath="//li[@id='interest-rate-calc']")
	WebElement InterestCalculator_LOGO  ;
	
	
	
	// WebElements for calculation checking
	
	// EMI Amount
	@FindBy(xpath="//input[@id='loanamount']")
	WebElement Loan_amt_inputbox ;						//  inputbox
	
	@FindBy(xpath="//div[@id='loanamountslider']")
	WebElement Loan_amt_slider ;				 	 //slider
	
	// Interest Rate
	@FindBy(xpath="//input[@id='loaninterest']")
	WebElement Loan_InterestRate_Inputbox ;				// inputbox
	
	@FindBy(xpath="//div[@id='loaninterestslider']")
	WebElement Loan_InterestRate_Slider ;   			  //slider
	
	
	// Loan Tennure
	@FindBy(xpath="//input[@id='loanterm']")
	WebElement Loan_Tennure_Inputbox_Year ;				// inputbox
	
	@FindBy(xpath="//input[@id='loanmonths']")
	WebElement Loan_Tennure_ConvertTo_Months ; 			// convert to months
	
	
	@FindBy(xpath="//div[@id='loantermslider']")
	WebElement Loan_Tennure_slider ;   		 				//slider
	
	// Fees and Charges
	@FindBy(xpath="//input[@id='loanfees']")
	WebElement Loan_FeesAndCharges_Inputbox ;			// inputbox
	
	@FindBy(xpath="//div[@id='loanfeesslider']")
	WebElement Loan_FeesAndCharges_Slider  ;				// slider
	
	
	
	
	
	
	
	public void setLoan_Amount(String LoanAmt)
	{
		fluentWait(Loan_amt_inputbox);
		// since sendKeys not working directly we are using CtrlA to set data permanently 
		Loan_amt_inputbox.sendKeys(Keys.CONTROL +"a");
		Loan_amt_inputbox.sendKeys(LoanAmt);
		
		
		
		
	}
	
	public String LoanAmt_Validate()
	{
		return Loan_amt_inputbox.getAttribute("value");
	}
	
	
	public void setLoan_Interest_Rate(String Interest_Rates)
	{
		fluentWait(Loan_InterestRate_Inputbox);
		// since sendKeys not working directly we are using CtrlA to set data permanently 
		Loan_InterestRate_Inputbox.sendKeys(Keys.CONTROL +"a");
		Loan_InterestRate_Inputbox.sendKeys(Interest_Rates);
		
	}
	
	public String InterestRate_Validate()
	{
		return Loan_InterestRate_Inputbox.getAttribute("value");
	}
	
	
	
	public void setLoan_Tennure(String Years)
	{
		fluentWait(Loan_Tennure_Inputbox_Year);
		
		// since sendKeys not working directly we are using CtrlA to set data permanently 
		Loan_Tennure_Inputbox_Year.sendKeys(Keys.CONTROL +"a");
		Loan_Tennure_Inputbox_Year.sendKeys(Years);
		
	}
	
	public String LOAN_Tenure_Validate()
	{
		return Loan_Tennure_Inputbox_Year.getAttribute("value");
	}
	
	
	public void setLoan_FeesAndCharges(String FEES)
	{
		fluentWait(Loan_FeesAndCharges_Inputbox);
		// since sendKeys not working directly we are using CtrlA to set data permanently 
		Loan_FeesAndCharges_Inputbox.sendKeys(Keys.CONTROL +"a");
		Loan_FeesAndCharges_Inputbox.sendKeys(FEES);
		
		
	}
	
	public String Loan_FEES_Validate()
	{
		return Loan_FeesAndCharges_Inputbox.getAttribute("value");
	}
	
	
	public void NavigateToNxtPage()
	{
		// navigating to NEXT( 3 RD ) page
		Loan_Tennure_CALCULATOR_LOGO.click();
	}
}
