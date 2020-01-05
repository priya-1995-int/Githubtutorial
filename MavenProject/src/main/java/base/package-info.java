/**
 * 
 */
/**
 * @author Naveen.S
 *
 */
package base;

/*
1. base 
	- BaseTest (TestNG class)
	- BeforeSuite - open the browser and navigate to our application
	- AfterSuite - close the browser
		
2. pages
	- Pages class(Class) extends BasePage
		- locators
		- actions like in home page -> click sign in button or in login page -> doLogin
	- BasePage
		- selenium interactions
3. reports
	- Extents reports as html file
4. suite
	- TestNG Suite
5. testdata
	- Excel file
6. test
	- Scenario class (TestNG Class) extends BaseTest
*/