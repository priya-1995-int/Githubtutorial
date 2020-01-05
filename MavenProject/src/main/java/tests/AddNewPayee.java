package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.AccountSummaryPage;
import pages.HomePage;
import pages.LoginPage;
import pages.PayBillsPage;
import testdata.ReadExcelData;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class AddNewPayee extends BaseTest{
  PayBillsPage paybills;
  
  @BeforeClass
  public void beforeClass() {
	  HomePage home=new HomePage();
	  home.clickSignInButton();
	  LoginPage login=new LoginPage();
	  login.doLogin("username", "password");
	  AccountSummaryPage acsum=new AccountSummaryPage();
	  acsum.clickPayBillsLink();
  }

  @BeforeMethod
  public void beforeMethod()
  {
	  paybills=new PayBillsPage();
	  paybills.clickAddNewPayeeLink();
  }
  
  @Test(dataProvider="dp")
  public void addNewPayee(String name,String addrs,String account,String details) {
	  paybills.doAddPayee(name, addrs, account, details);
  }
  
  @DataProvider
  public Object[][] dp() throws IOException
  {
	  ReadExcelData obj=new ReadExcelData("AddNewPayee","PayeeDetails");
	  return obj.getdata();
  }
}
