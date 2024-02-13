package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import utilities.ExcelUtility;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.*;

public class HomeLoanEMICalculator extends BasePage{

	public HomeLoanEMICalculator(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	// Object Repository containing WebElements
	
	
	// Home loan details header element 
		@FindBy(xpath = "//h3[contains(text(),'Home Loan Details')]")
		WebElement homeLoanDetailsHeaderElement;
		
		// Advertisement dismiss button
		@FindBy(xpath = "//div[@id='dismiss-button']")
		WebElement advertisementDismissButtonElement;
		
		// Advertisement iframe element
		@FindBy(xpath = "//iframe[@id='ad_iframe']")
		WebElement advertisementIframeElement;
		
		// Home Value input box element
		@FindBy(xpath = "//input[@id='homeprice']")
		WebElement homeValueInputElement;
		
		// Loan Amount input box element
		@FindBy(xpath = "//input[@id='homeloanamount']")
		WebElement loanAmountInputElement;
		
		// Down Payment input box element
		@FindBy(xpath = "//input[@id='downpayment']")
		WebElement downPaymentElement;
		
		// Down Payment rupees button element
		@FindBy(xpath = "//input[@id='downpayment']/../div/div/label[2]")
		WebElement downPaymentRupeesButtonElement;
		
		
		// Loan Insurance Input element
		@FindBy(xpath = "//input[@id='homeloaninsuranceamount']")
		WebElement loanInsuranceInputElement;
		
		// Interest Rate input element
		@FindBy(xpath = "//input[@id='homeloaninterest']")
		WebElement interesetRateInputElement;
		
		// Loan Tenure input element
		@FindBy(xpath = "//input[@id='homeloanterm']")
		WebElement loanTenureInputElement;
		
		// Loan Tenure months button
		@FindBy(xpath = "//input[@id='homeloanmonths']//..")
		WebElement loanTenureMonthsButtonElement;
		
		
		// Loan Fees & Charges input element
		@FindBy(xpath = "//input[@id='loanfees']")
		WebElement loanChargesInputElement;
		
		// Loan Charges rupees button element
		@FindBy(xpath = "//input[@id='loanfeesrupees']/..")
		WebElement loanChargesRupeesButtonElement;
		
		// Loan Start Month and Year element
		@FindBy(xpath = "//input[@id='startmonthyear']")
		WebElement loanStartMonthAndYearInputElement;
		
		// Datepicker element
		@FindBy(xpath = "//div[@class='datepicker-months']")
		WebElement datePickerElement;
		
		// Loan Start Year
		@FindBy(xpath = "(//table[@class='table-condensed'])[2]/thead/tr[2]/th[2]")
		WebElement loanYearElement;
		
		// Year change button (Next)
		// button to navigate to next year
		@FindBy(xpath = "(//table[@class='table-condensed'])[2]/thead/tr[2]/th[3]")
		WebElement nextYearButtonElement;
		
		// List of Month Elements
		@FindBy(xpath = "(//table[@class='table-condensed'])[2]/tbody/tr/td/span")
		List<WebElement> monthsElement;
		
		
		// From Home Owner Expenses 
		
		// One time expenses 
		@FindBy(xpath = "//input[@id='onetimeexpenses']")
		WebElement oneTimeExpensesElement;
		
		// One Time expenses rupees button
		@FindBy(xpath = "//input[@id='onetimeexpensesrupees']/..")
		WebElement oneTimeExpensesRupeesElement;
		
		// Property Taxes / year input element 
		@FindBy(xpath = "//input[@id='propertytaxes']")
		WebElement propertyTaxesPerYearElement;
		
		// Property Taxes / year rupees button element
		@FindBy(xpath = "//input[@id='propertytaxesrupees']/..")
		WebElement propertyTaxesPerYearRupeesButtonElement;
		
		// Home Insurance / year input Element
		@FindBy(xpath = "//input[@id='homeinsurance']")
		WebElement homeInsurancePerYearInputElement;
		
		//Home Insurance / Year rupees button element
		@FindBy(xpath = "//input[@id='homeinsurancerupees']/..")
		WebElement homeInsurancePerYearRupeesButtonElement;
		
		// Maintenance Expenses / month element
		@FindBy(xpath = "//input[@id='maintenanceexpenses']")
		WebElement maintenanceExpensesPerMonthElement;
		
		// Excel Table Data shown in page
		
		// Year on Year table ( Total Table )
		
		@FindBy(xpath = "//div[@id='paymentschedule']")
		WebElement yearOnYearTableElement;
		
		// Year on Year table Headers
		//Table  column headers
		
		@FindBy(xpath = "//div[@id='paymentschedule']/table/tbody/tr[1]/th")
		List<WebElement> headersElements;
		
		// Year on Year table row
		// 1st row in excel table
		
		@FindBy(xpath = "//tr[@class='row no-margin yearlypaymentdetails']")
		List<WebElement> dataTableRowElements;
		
		// Dropdown Elements in top left corner
		@FindBy(xpath="//a[@title='Calculators']")
		WebElement  Click_toOpen_dropdown ;
		
		@FindBy(xpath="//a[@href='https://emicalculator.net/loan-calculator/']")
		WebElement LoanCalculator_drpElement ;
	
		// xpath to navigate to special caculator type
		@FindBy(xpath="//li[@id='loan-amount-calc']")
		WebElement  LoanAmount_CALCULATOR_LOGO ;
		
	
	//ACTION METHODS
	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	// Method to validate home loan emi calculator link
	
	public boolean validateHomeLoanEmiCalculator() throws IOException, InterruptedException
	{
		// completed working on the frame 
		// handling the advertisement
		driver.switchTo().defaultContent();
		// returns boolean data 
		Thread.sleep(4000);
		return homeLoanDetailsHeaderElement.isDisplayed();
	}
	
	// Method to handle ADVERTISEMENT
	
		public void handleAdvertisement() {
			// first iframe
			
			try
			{
			driver.switchTo().frame("aswift_9");
			// second iframe
			driver.switchTo().frame(advertisementIframeElement);
			advertisementDismissButtonElement.click();
			driver.switchTo().defaultContent();
			}
			catch(Exception e)
			{
				System.out.println("Exceptions caught: "+e.getMessage());
				System.out.println("\n");
			}
		}
		
		// Method to set the home value amount
		
		public void setHomeValue_InputBox(String homeValueAmount) {
			fluentWait(homeValueInputElement);
			homeValueInputElement.clear();
			
			homeValueInputElement.sendKeys(homeValueAmount);
			
		}
		
		// Method to set down payment
		
		public void setdownPayment(String downPayment) {
			fluentWait(downPaymentElement);
			downPaymentElement.clear();
			
			
			// Using String parameters to send data TO INPUT BOX
			downPaymentElement.sendKeys(downPayment);
			
		}
		
		// Method to click on DownPayment rupees button
		
		public void clickOnDownPaymentRupeesButton() {
			fluentWait(downPaymentRupeesButtonElement);
			downPaymentRupeesButtonElement.click();
			System.out.println("\n");
		}
		
		// Method to get DownPayment Amount
		public String getDownPaymentAmount() throws IOException {
			
			return downPaymentElement.getAttribute("value");
		}
		
		// Method to set loan insurance
		public void setLoanInsurance(String loanInsuranceAmount) throws IOException {
			// since sendKeys not working directly we are using CtrlA to set data permanently 
			fluentWait(loanInsuranceInputElement);
			
			loanInsuranceInputElement.sendKeys(Keys.CONTROL +"a");
			loanInsuranceInputElement.sendKeys(loanInsuranceAmount);
		
		}
		
		// Method to get loan amount
		public String getLoanAmount() {
			
			// storing the value after calculating in a string and printing it
			fluentWait(loanAmountInputElement);
				String loanamount = loanAmountInputElement.getAttribute("value");
				return loanamount;
		}
		
		// Method to set the Interest Rate
		public void setInteresrRate(String interestRate) throws InterruptedException, IOException {
			
			// since sendKeys not working directly we are using CtrlA to set data permanently 
			fluentWait(interesetRateInputElement);
			interesetRateInputElement.sendKeys(Keys.CONTROL +"a");
			
			interesetRateInputElement.sendKeys(interestRate);
			
		}
		
		// Method to set the loan tenure 
		public void setLoanTenure(String loanTenure) throws IOException {
			
			// since sendKeys not working directly we are using CtrlA to set data permanently 
			fluentWait(loanTenureInputElement);
			loanTenureInputElement.sendKeys(Keys.CONTROL +"a");
			loanTenureInputElement.sendKeys(loanTenure);
			
		}
		
		// Method to click on the Loan Tenure Months button
		public void clickOnLoanTenureMonthsButton() {
			
			//loanTenureMonthsButtonElement.click();
			jse.executeScript("arguments[0].click();", loanTenureMonthsButtonElement);
		}
		
		// Method to get the Loan Tenure in Months
		public String getLoanTenureInMonths() throws InterruptedException {
			
			// storing the value after calculating in a string and printing it
			
			return loanTenureInputElement.getAttribute("value");
		}
		
		// Method to set loan charges 
		public void setLoanCharges(String loanCharges) throws InterruptedException, IOException {
			fluentWait(loanChargesInputElement);
			loanChargesInputElement.clear();
			loanChargesInputElement.sendKeys(loanCharges);
		
			Thread.sleep(2000);
		}
		
		// Method to validate loan charges rupees button
		public void clickOnLoanChargesRupeesButton() {
			
			loanChargesRupeesButtonElement.click();
			//jse.executeScript("arguments[0].click();",loanChargesRupeesButtonElement);
		}
		
		// Method to get loan charges Amount
		public String getLoanChargesAmount() throws IOException {
			
			// Getting the value after calculating in a string and returning the value
	//	returning the value stored in value attribute of webelement
			return loanChargesInputElement.getAttribute("value");
		}
		
		// Method to select Loan start month and year
		public void clickOnLoanStartMonthAndYear()
		{
			fluentWait(loanStartMonthAndYearInputElement);
			loanStartMonthAndYearInputElement.click();
		}
		
		// Method to validate Date Picker 
		public boolean validateDatePicker() {
			
			// Validating if datepicker element is displayed 
			
			if(datePickerElement.isDisplayed()) 
			{
				return true;
			}
			else 
			{
				return false;
			}
		  }
		
		// Method to set loan start month and year
		
		public void setLoanStartMonthAndYear(String year,String month) {
			
			// Creating parameters for use in this method to be used 
			while(true) 
			{
				if(loanYearElement.getText().equals(year)) 
				{
					break;
				}
				else 
				{
					nextYearButtonElement.click();
				}
			}
			try {
				
				for(WebElement element:monthsElement) {
					if(element.getText().equals(month)) {
						element.click();
						
					}
				}
			}
			catch (Exception e) {
				System.out.println("Exceptions Caught"+ e.getMessage());
				// TODO: handle exception
			}
		}
		
		// Method to set the oneTimeExpenses 
		
		public void setOneTimeExpenses(String oneTimeExpenses) throws IOException {
			// storing the value after calculating in a string and printing it
			
			fluentWait(oneTimeExpensesElement);
			oneTimeExpensesElement.sendKeys(Keys.CONTROL +"a");
			// Using keyboard actions
			oneTimeExpensesElement.sendKeys(oneTimeExpenses);
			
		}
		
		// Method to validate one time expenses rupees button
		public void clickOnOneTimeExpensesRupeesButton() throws InterruptedException {
			Thread.sleep(2000);
			fluentWait(oneTimeExpensesRupeesElement);
			oneTimeExpensesRupeesElement.click();
		}
		
		// Method to get one time expenses
		public String getOneTimeExpensesInRupees() throws IOException
		{
			
			return oneTimeExpensesElement.getAttribute("value");
		}
		
		// Method to set the Property Taxes / year
		public void setPropertyTaxesPeryear(String taxesPerYear) throws IOException{
			//since send keys alone is not working so ctrlA is used here
			
			fluentWait(propertyTaxesPerYearElement);
			propertyTaxesPerYearElement.sendKeys(Keys.CONTROL +"a");
			propertyTaxesPerYearElement.sendKeys(taxesPerYear);
			
		}
		
		// Method to validate Property Taxes / year rupees button
		public void clickOnPropertyTaxesPerYearRupeesButton() throws InterruptedException {
			Thread.sleep(2000);
			fluentWait(propertyTaxesPerYearRupeesButtonElement);
			propertyTaxesPerYearRupeesButtonElement.click();
		}
		
		// Method to get property taxes / year amount
		public String getPropertyTaxesPerYearInRupees() throws IOException {
			// returning the value caused after calculating 
			
			return propertyTaxesPerYearElement.getAttribute("value");
		}
		
		// Method to set Home Insurance / Year
		public void setHomeInsurancePerYear(String homeInsurance) throws IOException {
			homeInsurancePerYearInputElement.sendKeys(Keys.CONTROL +"a");
			homeInsurancePerYearInputElement.sendKeys(homeInsurance);
			
		}
		
		// Method to validate Home Insurance / Year rupees button
		public void clickOnHomeInsurancePerYearRupeesButton() throws InterruptedException {
			Thread.sleep(3000);
			homeInsurancePerYearRupeesButtonElement.click();
		}
		
		// Method to get Home Insurance / Year amount
		public String getHomeInsurancePerYearInRupees() throws IOException {
			// Returning Home insurance/Year  data calculated 
			
			return homeInsurancePerYearInputElement.getAttribute("value");
		}
		
		// Method to set Maintenance Expenses / month
		public void setMaintenanceExpensesPerMonth(String MaintenanceExpenses) throws IOException {
			fluentWait(maintenanceExpensesPerMonthElement);
			maintenanceExpensesPerMonthElement.sendKeys(Keys.CONTROL +"a");
			
			// sending paramaterized values to the input boxes
			maintenanceExpensesPerMonthElement.sendKeys(MaintenanceExpenses);
			System.out.println("\n");
			
		}
		
		// Method to print the Year on Year table
		public void readData() throws InterruptedException, IOException {
			
			jse.executeScript("arguments[0].scrollIntoView();", yearOnYearTableElement);  // scrolling to view the element
			Thread.sleep(4000);
			System.out.println("Year"+"\t"+"Principal (A)"+"\t"+"Interest (B)"+"\t"+"Taxes, Home Insurance & Maintenance (C)"+"\t"+"Total Payment (A+B+C)"+"\t"+"Balance"+"\t"+"Loan Paid To Date");
			for(int i=1;i<=dataTableRowElements.size();i++) {
				for(int j=0;j<headersElements.size();j++) {
					
					// STORING DATA FROM  excel sheet shown in webpage
	  				String data = driver.findElement(By.xpath("//tr[@class='row no-margin yearlypaymentdetails']["+i+"]/td["+(j+1)+"]")).getText().replaceAll("[₹,%]+", "");
	  				ExcelUtility.writeData("HomeLoanYearOnYearTable", i, j, Float.parseFloat(data));
					System.out.print(data+"\t");
					
				}
				System.out.println();
				System.out.println("\n");
			}
		}
		
		public void GoToLoanCalculator_Page() throws InterruptedException
		{
			fluentWait(Click_toOpen_dropdown);
			// clicking on this link stored as webelement to go to nxt page
			Click_toOpen_dropdown.click();
			// navigating to next page for UI checking
			
			fluentWait(LoanCalculator_drpElement);
			LoanCalculator_drpElement.click();
			
			Thread.sleep(2000);
		
			LoanAmount_CALCULATOR_LOGO.click();
		}
	

}
