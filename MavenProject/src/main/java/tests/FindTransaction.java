package tests;

import java.io.IOException;
import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AccountActivityPage;
import pages.AccountSummaryPage;
import pages.HomePage;
import pages.LoginPage;
import testdata.ReadExcelData;

public class FindTransaction extends BaseTest{
  
	AccountActivityPage accact;
	
	  @Parameters({"username","password"})
	@BeforeClass
	public void beforeClass(@Optional("username")String username,@Optional("password")String password)
	{
		HomePage home=new HomePage();
		home.clickSignInButton();
		LoginPage login=new LoginPage();
		login.doLogin("username", "password");
		AccountSummaryPage accsum=new AccountSummaryPage();
		accsum.clickAccountActivityLink();
		accact=new AccountActivityPage();
		accact.clickFindTransactionLink();
	}
	
	  
	@Test(dataProvider="dp")
  public void findTransactionByDescription(String date,String desc,String dep,String with) {
	  test = report.createTest("Find the transaction by description");
	  accact.findTransactionByDescription(desc);
	  Assert.assertEquals(accact.getTransactionDate(), date);
	  Assert.assertEquals(accact.getTransactionDescription(), desc);
	  Assert.assertEquals(accact.getTransactionDeposite(), dep);
	  Assert.assertEquals(accact.getTransactionWithdrawal(), with);
  }
	  @Test
	  public void findTransactionByDate() throws ParseException {
		  test = report.createTest("Find the transaction by date");
		  accact.findTransactionByDate("1-Sep-2012","2-Sep-2012");
	  }
	@DataProvider
	public Object[][] dp() throws IOException
	{
		ReadExcelData obj=new ReadExcelData("FindTransaction","Description");
		return obj.getdata();
	}
}
