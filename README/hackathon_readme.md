
		# Selenium Automation Testing Project: Find the Interest Amount for current year

	## Project Overview
This Selenium automation testing project focuses on automating tasks on   https://emicalculator.net/
The primary objectives include input field and slider element validation by passing data, navigating through the portal, verifying the presence of specific elements and extracting details from the page. 
The project uses various dependencies , plugins and libraries to facilitate automation.
 
	### 1. Maven Repository
 
- **Maven Version**: 3.12.1
- Created the whole project as a maven project
 
	### 2. Dependencies
  
- **TestNG**
- Version: 7.8.0
- Purpose: Framework for test automation that allows for parallel execution and flexible test configuration.
 
- **Extent Report**
- Version: 5.1.1
- Purpose: Generates interactive and detailed HTML reports to enhance test result analysis.
 
- **Selenium**
- Version: 4.15.0
- Purpose: Enables interaction with web elements, navigation, and form submission in the browser.

- **Apache-Log4j**
- Version: 2.22.1
- Purpose: To keep track of what happens in the software applications
 

- **Driver Setup**
- Purpose: Enables interaction browser and work with web browser without setting up file path for each browser in the SELENIUM version 4 and onwards .

- **Apache-POI**
- Version: 5.2.5
- Purpose: Used to communicate with Excel sheet

	###  3. Plugins
 		
- **Maven-compiler-plugin**
- Version: 3.12.1
- Purpose: To compile the whole project for further actions
-Compiles all resources present in the project(code)

- **Maven-surefire-plugin**
- Version: 3.2.5
- Purpose: Used to run the program using command prompt , or using pom.xml
-Used during the test phase of the build lifecycle to execute the unit tests of an application.


	## Automation Test Flow
 
1. **Open Google Home Page**

- Navigate to Google home page  .

2.** Search for EMICalculator Website **

- In the google home searchbar input emicalculator.net  .
-Click on Google Search button to initiate the search process  .
-Click on the 1st website that appears .

3.** Verify all LOAN Calculator sections with sliders **

-Check if all sections named as "Home Loan" , "Car Loan" , "Personal Loan" is working .
-Navigate to the Car Loan section 
-Input values to the calculator using sliders through automation script.

4.** Navigate to another page inside that website for further validation **

- Click on the CALCULATORS dropdown visible at the top right corner .
-Click on Home Loan EMI Calculator link .

5.** Working on the Home Loan Calculator Page  **

-Input all data to calculate the results .
- Store the displayed table in an excel table .

6.** Click on the Dropdown button  **

-After the dropdown appears click on LOAN Calculator.
-Check if all functions are working properly or not .

7.** Navigate to Loan Calculators  **
-Navigated to the new page for UI Check of Calculators .
-Validating the visibility and clickability of different calculator links .

8.** Validating the inputboxes of the calculators **
- Providing data to check if the inputboxes and accepting data or not .
-Repeat these for all type of calculators .
-Close the automation .

	## How to Run the Tests
 
1. **Open Eclipse IDE:**
- Launch Eclipse IDE on your machine.

2. **Import Project:**
  - Select File -> Import from the menu.
   -Choose Existing Maven Projects and click Next.
   - Browse to the directory where you cloned the repository and select the project.
 
3. **Update Maven Project:**
- Right-click on the project in the Project Explorer.
- Choose `Maven` -> `Update Project`.
- Click `OK` to update dependencies.

4. **Set Up Configuration:**
 - Open the src/test/resources/config.properties file.
  - Update any configuration parameters like browser type, URLs, etc., as needed.
 
5. **Run Test Suite:**
- Locate the test suite file (e.g., `src/test/java/TestSuite.java`).
- Right-click on the file and choose `Run As` -> `TestNG Suite`.
 
6.  **View Reports:**
- After execution, open the `test-output` folder.
- Find the Extent Report HTML file (`index.html`) for detailed test reports.

	## Author Information

**SAPTARSHI  ROY**


	## Disclaimer
 
 
This project is intended for educational and testing purposes only. The authors are not responsible for any unauthorized use or modification of the code. Use at your own risk.

 