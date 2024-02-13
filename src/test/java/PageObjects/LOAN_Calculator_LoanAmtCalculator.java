package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LOAN_Calculator_LoanAmtCalculator extends BasePage{

	// 1ST Page
	
	public LOAN_Calculator_LoanAmtCalculator(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
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
		
		@FindBy(xpath="//input[@id='loanemi']")
		WebElement EMI_amt_inputbox ;				//  inputbox
		
		@FindBy(xpath="//div[@id='loanamountslider']")
		WebElement Loans_amt_slider ;				  //slider
		
		// Interest Rate
		
		@FindBy(xpath="//input[@id='loaninterest']")
		WebElement InterestRate_Inputbox ;			// inputbox
		
		@FindBy(xpath="//div[@id='loaninterestslider']")
		WebElement Loans_InterestRate_Slider ;   		  //slider
		
		
		// Loan Tennure
		
		@FindBy(xpath="//input[@id='loanterm']")
		WebElement Loans_Tennure_Inputbox_Year ;				// inputbox
		
		@FindBy(xpath="//input[@id='loanmonths']")
		WebElement Loans_Tennure_ConvertTo_Months ; 			// convert to months
		
		
		@FindBy(xpath="//div[@id='loantermslider']")
		WebElement Loans_Tennure_slider ;   		 //slider
		
		// Fees and Charges
		
		@FindBy(xpath="//input[@id='loanfees']")
		WebElement Loan_FeesAndCharges_Inputbox ;			// inputbox
		
		@FindBy(xpath="//div[@id='loanfeesslider']")
		WebElement FeesAndCharges_Slider  ;				// slider
		
		
		
		
		// ACTION  METHODS  FOR VALIDATION
		
		public void Validation_Of_EMICalculator()
		{
			// checking if webelement is enabled and displayed or not as well as enabled or not
			System.out.println(" \n ");
			
			boolean click_emi=EMICalculator_LOGO.isEnabled();
			boolean emi_calc =EMICalculator_LOGO.isDisplayed();
			if(emi_calc==true && click_emi==true)
			{
				System.out.println(" _______________________________");
				System.out.println(" Validation of the WebElement Successful");
			}
			else
			{
				System.out.println(" _______________________________");
				System.out.println(" Validation of the WebElement is  Unsuccessful");
			}
		}

		public void Validation_Of_LoanAmountCalculator()
		{
			// checking if webelement is enabled and displayed or not as well as enabled or not
			System.out.println(" \n ");
			
		    boolean click_loanCalc=LoanAmount_CALCULATOR_LOGO.isEnabled();  // these functions returns true or false values used for validation
			boolean emi_calc =LoanAmount_CALCULATOR_LOGO.isDisplayed();
			if(emi_calc==true && click_loanCalc==true)
			{
				System.out.println(" _______________________________");
				System.out.println(" Validation of the WebElement Successful");
			}
			else
			{
				System.out.println(" _______________________________");
				System.out.println(" Validation of the WebElement is  Unsuccessful");
			}
		}
		
		public void Validation_Of_LoanTennureCalculator()
		{
			System.out.println(" \n ");
			// checking if webelement is enabled and displayed or not as well as enabled or not
			boolean click_TennureCalc=Loan_Tennure_CALCULATOR_LOGO.isEnabled();
			boolean emi_calc =Loan_Tennure_CALCULATOR_LOGO.isDisplayed();
			if(emi_calc==true && click_TennureCalc==true)
			{
				System.out.println(" _______________________________");
				System.out.println(" Validation of the WebElement Successful");
			}
			else
			{
				System.out.println(" _______________________________");
				System.out.println(" Validation of the WebElement is  Unsuccessful");
			}
		}
		public void Validation_Of_Loan_InterestCalculator()
		{
			System.out.println(" \n ");
			// checking if webelement is enabled and displayed or not as well as enabled or not
			 boolean Interest_Calc=InterestCalculator_LOGO.isEnabled();
			boolean emi_calc =InterestCalculator_LOGO.isDisplayed();
			if(emi_calc==true && Interest_Calc==true)
			{
				System.out.println(" _______________________________");
				System.out.println(" Validation of the WebElement Successful");
			}
			else
			{
				System.out.println(" _______________________________");
				System.out.println(" Validation of the WebElement is  Unsuccessful");
			}
		}
		
		
		//Action Methods
		
		public void setingLoan_Amount(String EMI__Amts)
		{
			fluentWait(EMI_amt_inputbox);
			// since sendKeys not working directly we are using CtrlA to set data permanently 
			EMI_amt_inputbox.sendKeys(Keys.CONTROL +"a");
			EMI_amt_inputbox.sendKeys(EMI__Amts);
			
			
			
			
		}
		
		public String LoanAmt_Validation()
		{
			return EMI_amt_inputbox.getAttribute("value");
		}
		
		public void setingLoan_Interest_Rate(String Interest_Ratess)
		{
			fluentWait(InterestRate_Inputbox);
			// since sendKeys not working directly we are using CtrlA to set data permanently 
			InterestRate_Inputbox.sendKeys(Keys.CONTROL +"a");
			InterestRate_Inputbox.sendKeys(Interest_Ratess);
			
		}
		
		public String InterestRate_Validation()
		{
			return InterestRate_Inputbox.getAttribute("value");
		}
		
		public void setingLoan_Tennure(String Year_s)
		{
			fluentWait(Loans_Tennure_Inputbox_Year);
			
			// since sendKeys not working directly we are using CtrlA to set data permanently 
			Loans_Tennure_Inputbox_Year.sendKeys(Keys.CONTROL +"a");
			Loans_Tennure_Inputbox_Year.sendKeys(Year_s);
			
		}
		
		public String Tennure_Validation()
		{
			return Loans_Tennure_Inputbox_Year.getAttribute("value");
		}
		
		public void setingLoan_FeesAndCharges(String Fees)
		{
			fluentWait(Loan_FeesAndCharges_Inputbox);
			// since sendKeys not working directly we are using CtrlA to set data permanently 
			Loan_FeesAndCharges_Inputbox.sendKeys(Keys.CONTROL +"a");
			Loan_FeesAndCharges_Inputbox.sendKeys(Fees);
			
			
			
		}
		
		public String FeesANDCharges_Validation()
		{
			return Loan_FeesAndCharges_Inputbox.getAttribute("value");
		}
		
		
		
		public void navigateToNextPage()
		{

			// navigating to 2 ND  page for UI validation
			EMICalculator_LOGO.click();
		}
	

}
