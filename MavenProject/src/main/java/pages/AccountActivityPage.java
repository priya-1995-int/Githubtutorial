package pages;

import java.text.ParseException;

import org.openqa.selenium.By;

public class AccountActivityPage extends BasePage{

	By FindTransactionsLink=By.xpath("//a[text()='Find Transactions']");
	By DescriptionInput=By.id("aa_description");
	By FindButton=By.xpath("//button[text()='Find']");
	By DateTable=By.xpath("//div[@id='filtered_transactions_for_account']//td[1]");
	By DescriptionTable=By.xpath("//div[@id='filtered_transactions_for_account']//td[2]");
	By DepositeTable=By.xpath("//div[@id='filtered_transactions_for_account']//td[3]");
	By WithdrawalTable=By.xpath("//div[@id='filtered_transactions_for_account']//td[4]");
	By FromDateField=By.id("aa_fromDate");
	
	public void clickFindTransactionLink()
	{
		performClick(FindTransactionsLink);
	}
	
	public void findTransactionByDescription(String searchterm)
	{
		waitForElement(DescriptionInput,"visibility").sendKeys(searchterm);
		performClick(FindButton);
	}
	
	public String getTransactionDate()
	{
		return waitForElement(DateTable,"visibility").getText();
	}
	public String getTransactionDescription()
	{
		return getText(DescriptionTable);
	}
	public String getTransactionDeposite()
	{
		if (getText(DepositeTable).equals(""))
			return "null";
		return getText(DepositeTable);
	}
	public String getTransactionWithdrawal()
	{
		return getText(WithdrawalTable);
	}

	public void findTransactionByDate(String fromdate, String todate) throws ParseException {
		waitForElement(FromDateField,"visibility").click();
		selectDate(fromdate);
		performClick(FindButton);
	}
}
