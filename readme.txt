**************************Selenium Coding challenge part 2- Naveen Automation Labs************************************

Important Points:
1. All test data required is placed in "TestRunDetails.properties" file which is available in src/main/resources
2. Path for browser is provided by OsPath.java class inside challenge.mmt.Browser package.
3.This script is capable to execute in Image disable mode and Headless mode. However headless mode works only for Firefox Browser.
4.Browser, Headless mode or image disable mode can be onfigured using "TestRunDetails.properties"
5.Please execute this program from testng.xml
6.Browser exe driver files are available in src/main/resources
7.Extent report is generated inside ExtentReports folder.Its is a kind of log file.
8.While verifying total price,if slashed price is displayed on website then this price will be verified with departure and return filghts
	discounted price will be ignored

***************************Working of Program**********************************************************************
1.Open browser
2.Open make my trip website.
3. Enter From and TO Place name.
4.Select Departure date, which is current date
5.Select Return date, which is +7 days from Departure date
6.Click on Search.
7.Scroll page to load total filghts in DOM
6.Count Departure and Return Filights and Print on Console.
7.Select Non Stop Check box.
8. Again scroll to load all flights on DOM
9. Count Departure and Return Filights and Print on Console. 
10.clear filter and check 1 Stop filter
11.Again scroll to load all flights on DOM
12. Count Departure and Return Flights and Print on Console. 
13.Clear the filter and Scroll to Load all flights.
14. Select any two flight randomly.
15. verify lable and bottom prices.
16. Verify total price
17.While verifying total price,if slashed price is displayed on website then this price will be verified with departure and return filghts
	discounted price will be ignored
	
************************************About project and Structure********************************************************
1.src/main/java : contains all main functions
	PACKAGES, Class and Functions
	1.challenge.mmt.Browse: this package contains class files for browser launch and configuration
		a.DisableImage.java: This class contains functions to disable browser image loading	
		b.Driver: This class contains function to launch browser, also to initialize Eventwebdirver listner and quit browser 
		c.HeadlessMode.java: This class will configure the browser to run in headless mode. it will work only with fire fox/
		d.OsPath.java: Determines the OS and provides browser path accordingly.
	2.challenge.mmt.Report: This package contains class related to reports.
		a.ExtentReport.java: contains function to initialize report and set path and report name.
		b.Logstatus.java: contains function to log test steps.
	3.challenge.mmt.util: this package contains some utilities required to run program
		a.DatePicker.java: Responsible for identifying current date and next 7 days date, and returns date for date selection
		b.DynamicXpath.java: contains function to help creating dynamic xpath.
		c.ElementVisibility.java: checks if element is displayed on page.
		d.PageScroll.java: contains functions to scroll page up and down.
		e.Wait.java: contains function to wait for certain conditions.
	4.challenge2.mmt.Listner: contains class for WebDriverEcent Listner and ItestListner, to help create logs.
	5.challenge2.mmt.Listner: contains class and function to read property from property file.
	6.challenge2.mmt.WebPages: contains class according to Website pages
		a.HomePage.java: Contains all element related to HomePage and Methods to perform action on homePage.
		b.FlightResultPage.java: this class represents the page which appears after search flight button is pressed.
			it contains elements related to Flight Search page and methods to perform action on page/
	7.src/main/resource: Contains TestRunDetails.properties file, browser exe files
	8.src/test/java: contains classes to test mmt website for challenge.
		a.challenge2.mmt.tests: contains test cases to test website
			a.SearchFilightTest.java: It contains funtion to test search functionality, i.e enter from and to, click date and search flight
			b.FlightCounts.java: contains function to count departure and Return flights based on filters.
			c.FlightPrices.java: contains function to validate flight prices.
			d.TestSetup.java: contains function to initialize browser ans report.
	9.ExtentReports:
		contains generated reports, naming is done on time at which test is run	
	 
		
	