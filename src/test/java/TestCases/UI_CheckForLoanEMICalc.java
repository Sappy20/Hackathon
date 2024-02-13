package TestCases;

import org.testng.annotations.Test;

import PageObjects.LOAN_Calculator_LoanEMI;

public class UI_CheckForLoanEMICalc extends UI_CheckForLoanAmountCalculators{
	
	
	// TEST FOR 2 PAGE
	
	@Test(priority=32,groups= {"sanity","master"})
	public void needTo_setLoan_Amount()
	{
		logger.info("***** Working on the Second type of Calculator page  *******");
		logger.info("***** WORKING ON EMI CALCULATOR  *******");
		
		LOAN_Calculator_LoanEMI  ui_EMI = new LOAN_Calculator_LoanEMI(driver);
		
		logger.info("***** _________________________________________ *******");
		logger.info("***** Providing the Loan Amount in the inputbox *******");
		
		// using property file here
		String LoanAmt=p.getProperty("loanAmount");
		
		ui_EMI.setLoan_Amount(LoanAmt);
		// returning value set
		ui_EMI.LoanAmt_Validate();
		logger.info("***** Validating the data shown finally in the inputbox *******");
		logger.info("***** _______________________________________  ******");
	}
	
	
	@Test(priority=33,groups= {"sanity","master"})
	public void needTo_setLoan_Interest_Rate()
	{

		logger.info("***** Setting the INTEREST RATE in the inputbox  *******");
		LOAN_Calculator_LoanEMI  ui_EMI = new LOAN_Calculator_LoanEMI(driver);
		
		logger.info("***** _______________________ *******");
		
		String Interest_Rates =p.getProperty("interestRateEMICalculator");
		ui_EMI.setLoan_Interest_Rate(Interest_Rates);
		
		logger.info("***** Validating the results shown in the Interest Rate inputbox *******");
		// returning value set
		ui_EMI.InterestRate_Validate();
		logger.info("***** _______________________________________________ *******");
		
	}
	
	
	@Test(priority=34,groups= {"sanity","master"})
	public void needTo_setLoan_Tennure()
	{
		logger.info("***** Providing the number of YEARS for which the LOAN is being applied for  *******");
		LOAN_Calculator_LoanEMI  ui_EMI = new LOAN_Calculator_LoanEMI(driver);
		
		String Years =p.getProperty("loanTenureEMICalculator");
		ui_EMI.setLoan_Tennure(Years);
		logger.info("***** _________________________ *******");
		// returning value set
		ui_EMI.LOAN_Tenure_Validate();
		logger.info("***** Returning the values stored in the inputbox  *******");
		
	}
	
	
	@Test(priority=35,groups= {"sanity","master"})
	public void needTo_setLoan_FeesAndCharges()
	{

		logger.info("***** ______________________________ *******");
		LOAN_Calculator_LoanEMI  ui_EMI = new LOAN_Calculator_LoanEMI(driver);
		
		String FEES =p.getProperty("loanChargesLoanCalculator");
		ui_EMI.setLoan_FeesAndCharges(FEES);
		
		logger.info("***** Providing the FEES and CHARGES for applying for the LOAN  *******");
		logger.info("*****  *******");
		// returning value set
		ui_EMI.Loan_FEES_Validate();
		logger.info("***** Returning the Value stored in the inputbox *******");
		logger.info("***** ________________________________ *******");
		
	}
	
	@Test(priority=36,groups= {"smoke","sanity","master"})
	public void needTo_NavigateToNxtPage()
	{

		logger.info("***** ____________________________________  *******");
		LOAN_Calculator_LoanEMI  ui_EMI = new LOAN_Calculator_LoanEMI(driver);
	
		logger.info("***** Moving on to the next page for LOAN Tennure Calculator  *******");
		logger.info("***** LOAN tenure Calculator page is opened *******");
		ui_EMI.NavigateToNxtPage();
		logger.info("*****   =============================================   *******");
		
	}
	
}



