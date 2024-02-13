package PageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LOAN_Calculator_InterestRateCalculator extends BasePage {

	public LOAN_Calculator_InterestRateCalculator(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//4TH  PAGE
	
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
				WebElement InterestRateCalculator_LOGO  ;
				
				
				// WebElements for Loan Tenure Calculator checking
				
				// LOAN Amount
				
				@FindBy(xpath="//input[@id='loanamount']")
				WebElement LOAN_amount_inputbox ;						//  inputbox
				
				@FindBy(xpath="//div[@id='loanamountslider']")
				WebElement LOAN_amount_slider ;				 		 //slider
				
				// EMI AMT
				
				@FindBy(xpath="//input[@id='loanemi']")
				WebElement EMI_Amount_Inputbox ;					// inputbox
				
				@FindBy(xpath="//div[@id='loanemislider']")
				WebElement EMI_Amount_Slider ;   					  //slider
				
				
				// Loan Tennure
				
				@FindBy(xpath="//input[@id='loanterm']")
				WebElement LOAN_Tenure_Inputbox ;				// inputbox
				
				
				@FindBy(xpath="//div[@id='loantermslider']")
				WebElement LOAN_Tenure_slider ;   				 //slider
				
				@FindBy(xpath="//input[@id='loanmonths']")
				WebElement LOAN_Tenure_MonthConverter ;				// convert years to month
				
				
				// FEES AND CHARGES
				
				@FindBy(xpath="//input[@id='loanfees']")
				WebElement FeesAnd_Charges_Inputbox ;			// inputbox
				
				@FindBy(xpath="//div[@id='loanfeesslider']")
				WebElement FeesAnd_Charges_Slider  ;				// slider
				
				//
				@FindBy(xpath="//div[@id='loansummary-totalinterest']/p")
				WebElement Results_Four ;
				
	// ACTION  METHODS 
				
				
				public void settingLoan_Amount(String LoanAmounts)
				{
					fluentWait(LOAN_amount_inputbox);
					// since sendKeys not working directly we are using CtrlA to set data permanently 
					LOAN_amount_inputbox.sendKeys(Keys.CONTROL +"a");
					LOAN_amount_inputbox.sendKeys(LoanAmounts);
					
					
					
					
				}
				public String LOAN_amt_Validation()
				{
					
					return LOAN_amount_inputbox.getAttribute("value");
					
				}
				
				public void settingEMI_Amount(String EMI_Amount)
				{
					fluentWait(EMI_Amount_Inputbox);
					// since sendKeys not working directly we are using CtrlA to set data permanently 
					EMI_Amount_Inputbox.sendKeys(Keys.CONTROL +"a");
					EMI_Amount_Inputbox.sendKeys(EMI_Amount);
					
				}
				
				public String EMI_amt_Validation()
				{
					
					return EMI_Amount_Inputbox.getAttribute("value");
					
				}
				
				
				
				public void setingLoan_Tennure(String YEARS)
				{
					fluentWait(LOAN_Tenure_Inputbox);
					
					// since sendKeys not working directly we are using CtrlA to set data permanently 
					LOAN_Tenure_Inputbox.sendKeys(Keys.CONTROL +"a");
					LOAN_Tenure_Inputbox.sendKeys(YEARS);
					
				}
				
				public String TENURE_Validation()
				{
					
					return LOAN_Tenure_Inputbox.getAttribute("value");
					
				}
				
				
				public void setingLoan_FeesAndCharges(String FeesAndCharges)
				{
					fluentWait(FeesAnd_Charges_Inputbox);
					// since sendKeys not working directly we are using CtrlA to set data permanently 
					FeesAnd_Charges_Inputbox.sendKeys(Keys.CONTROL +"a");
					FeesAnd_Charges_Inputbox.sendKeys(FeesAndCharges);
					
					
					
				}
				
				public String CHARGES_amt_Validation()
				{
					
					return FeesAnd_Charges_Inputbox.getAttribute("value");
					
				}
				
			public String validation_Result()
			{
				//  returning the stored value in the element
				return Results_Four.getAttribute("value");
				 
				
			}
	
	

}
