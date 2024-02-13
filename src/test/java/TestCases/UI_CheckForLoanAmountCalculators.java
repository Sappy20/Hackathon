package TestCases;

import org.testng.annotations.Test;

import PageObjects.LOAN_Calculator_LoanAmtCalculator;


public class UI_CheckForLoanAmountCalculators extends HomeLoanEMICalculator_Test{
	
	// TESTS of 1st PAGE
	

	@Test(priority=24,groups= {"smoke","sanity","master"})
	public void validation_Of_EMI_Calculator()
	{
		logger.info("***** Working on the 1st TYPE of CALCULATOR  *******");
		logger.info("*****   WORKING on LOAN AMOUNT CALCULATOR  *******");
		logger.info("*****  *******");
		logger.info("******  ________________________________  ********");
		LOAN_Calculator_LoanAmtCalculator  Calc_UI=new LOAN_Calculator_LoanAmtCalculator(driver);
		Calc_UI.Validation_Of_EMICalculator();
		logger.info("***** Validation Of Loan Amount Calculator links   *******");
		logger.info("***** Validating to check whether Element is visible and  clickable or not *******");
		logger.info("***** ________________________________ *******");
	}
	
	
	
	@Test(priority=25,groups= {"smoke","sanity","master"})
	public void validationOf_Loan_Amount_Calculator()
	{
		logger.info("*****  _______________________________ *******");
		LOAN_Calculator_LoanAmtCalculator  Calc_UI=new LOAN_Calculator_LoanAmtCalculator(driver);
		Calc_UI.Validation_Of_LoanAmountCalculator();
		logger.info("***** Validation of Loan Amount Calculators link  *******");
		logger.info("***** Validating to check whether Element is visible and  clickable or not *******");
		logger.info("***** ________________________________ *******");
	}
	
	
	
	@Test(priority=26,groups= {"smoke","sanity","master"})
	public void validationOf_Loan_Tenure_Calculator()
	{
		logger.info("***** ________________________________  *******");
		LOAN_Calculator_LoanAmtCalculator  Calc_UI=new LOAN_Calculator_LoanAmtCalculator(driver);
		Calc_UI.Validation_Of_LoanTennureCalculator();
		logger.info("***** Validation of Loan Tennure Calculator link *******");
		logger.info("***** Validating to check whether Element is visible and  clickable or not *******");
		logger.info("***** ________________________________ *******");
	}
	
	
	@Test(priority=27,groups= {"smoke","sanity","master"})
	public void validationOf_Loan_Interest_Calculator()
	{
		logger.info("***** Validation of Loan Interest Calculator link   *******");
		LOAN_Calculator_LoanAmtCalculator  Calc_UI=new LOAN_Calculator_LoanAmtCalculator(driver);
		Calc_UI.Validation_Of_Loan_InterestCalculator();
		logger.info("***** Validating to check whether Element is visible and  clickable or not *******");
		logger.info("***** ________________________________ *******");
	}
	
	
	
	@Test(priority=28,groups= {"sanity","master"})
	public void does_setingLoan_Amount()
	{
		LOAN_Calculator_LoanAmtCalculator  Calc_UI=new LOAN_Calculator_LoanAmtCalculator(driver);
		logger.info("***** Providing the Loan Amount in the inputbox   *******");
		
		String EMI__Amts =p.getProperty("EMIAmount");
	Calc_UI.setingLoan_Amount(EMI__Amts);
	// checking value 
	Calc_UI.LoanAmt_Validation();
	logger.info("***** _________________________ *******");
	logger.info("***** Validating the final result in the inputbox  *******");
	}
	
	
	@Test(priority=29,groups= {"sanity","master"})
	public void does_setingLoan_Interest_Rate()
	{
		
		LOAN_Calculator_LoanAmtCalculator  Calc_UI=new LOAN_Calculator_LoanAmtCalculator(driver);
		logger.info("***** Providing the Loan Interest Rate in the inputbox  *******");
		
		String Interest_Ratess =p.getProperty("InterestRATE");
	Calc_UI.setingLoan_Interest_Rate(Interest_Ratess);
	// returning o/p value
	Calc_UI.InterestRate_Validation();
	
	logger.info("***** ________________________________ *******");
	logger.info("***** Validating the final value  *******");
	logger.info("***** ________________________________ *******");
	
	}
	
	
	@Test(priority=30,groups= {"sanity","master"})
	public void LoanTennure_CalculatorIs_Present_Validation()
	{
		logger.info("***** Setting the Loan Tennure by providing the number of years into the checkbox *******");
		LOAN_Calculator_LoanAmtCalculator  Calc_UI=new LOAN_Calculator_LoanAmtCalculator(driver);
	
		String Year_s =p.getProperty("LoanTennure");
	Calc_UI.setingLoan_Tennure(Year_s);
	
	logger.info("***** ________________________________ *******");
	logger.info("***** Validating the Final data in the checkbox  *******");
	Calc_UI.Tennure_Validation();
	}
	
	
	@Test(priority=31,groups= {"smoke","sanity","master"})
	public void does_setingLoan_FeesAndCharges()
	{
		logger.info("*****  *******");
		logger.info("***** ________________________________ *******");
		LOAN_Calculator_LoanAmtCalculator  Calc_UI=new LOAN_Calculator_LoanAmtCalculator(driver);

		logger.info("***** Providing the value for Fees and Charges charged for LOAN initiation *******");
	
		String Fees =p.getProperty("FEESandCharges");
	Calc_UI.setingLoan_FeesAndCharges(Fees);
	Calc_UI.FeesANDCharges_Validation();
	logger.info("***** _________________________________________________ *******");
	logger.info("***** Validating the DATA stored in the inputbox *******");
	
	
	logger.info("***** Moving on to the next calculator page  *******");
	logger.info("*****  *******");
	
	// Navigating to EMI Calculator page 
	
	Calc_UI.navigateToNextPage();
	logger.info("*****  *******");
	logger.info("***** EMI Calculator page is opened for Calculation  *******");

	
	logger.info("*****   ==================================================  *******");
	
	}
	

}
