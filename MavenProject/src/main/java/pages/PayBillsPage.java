/**
 * 
 */
package pages;

import org.openqa.selenium.By;

/**
 * @author Naveen.S
 *
 */
public class PayBillsPage extends BasePage{
	
	By AddNewPayeeLink=By.xpath("//a[text()='Add New Payee']");
	
	
	//AddNewPayeeTab
	 By NameInput=By.id("np_new_payee_name"); 
	 By AddressInput=By.id("np_new_payee_address"); 
	 By AccountInput=By.id("np_new_payee_account"); 
	 By DetailsInput=By.id("np_new_payee_details"); 
	 By AddButton =By.id("add_new_payee");
	
	public void clickAddNewPayeeLink()
	{
		performClick(AddNewPayeeLink);
	}
	
	//AddNewPayeTab
	public void doAddPayee(String name,String address, String account, String details)
	{
		waitForElement(NameInput,"visibility").sendKeys(name);
		enterText(AddressInput, address);
		enterText(AccountInput, account);
		enterText(DetailsInput, details);
		performClick(AddButton);
	}
}
