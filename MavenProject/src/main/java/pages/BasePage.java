/**
 * 
 */
package pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

/**
 * @author Naveen.S
 *
 */
public class BasePage {

	protected WebDriver driver=BaseTest.driver;

	void performClick(By locator)
	{
		driver.findElement(locator).click();
	}
	
	void enterText(By locator,String text)
	{
		driver.findElement(locator).sendKeys(text);
	}
	
	String getText(By locator)
	{
		return driver.findElement(locator).getText();
	}
	
	WebElement waitForElement(By locator,String condition)
	{
		WebDriverWait wait=new WebDriverWait(driver,3);
		if(condition.equals("visibility"))
		{
			return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		}
		else if(condition.equals("clickable"))
		{
			return wait.until(ExpectedConditions.elementToBeClickable(locator));
		}
		else
		{
			return null;
		}
	}
	protected void selectDate(String date) throws ParseException {
		String year=date.split("-")[2];
		
		Date m = new SimpleDateFormat("MMM", Locale.ENGLISH).parse(date.split("-")[1]);
		Calendar cal = Calendar.getInstance();
		cal.setTime(m);
		int month = cal.get(Calendar.MONTH);
		
		goToYear(Integer.parseInt(year));
		goToMonth(month);
		driver.findElement(By.xpath("//a[@class='ui-state-default' and text()='"+date.split("-")[0]+"']")).click();
	}
	private void goToMonth(int month) throws ParseException {
		while(true)
		{
			String m=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText().substring(0,3);
			Date m_ = new SimpleDateFormat("MMM", Locale.ENGLISH).parse(m);
			Calendar cal = Calendar.getInstance();
			cal.setTime(m_);
			int actual_month = cal.get(Calendar.MONTH);
			
			if(actual_month>month)
			{
				driver.findElement(By.xpath("//span[text()='Prev']")).click();
			}
			else if (actual_month>month)
			{
				driver.findElement(By.xpath("//span[text()='Next']")).click();
			}
			else
			{
				break;
			}
		}
			
	}
	private void goToYear(int year) {
		while(true)
		{
			int actual_year=Integer.parseInt(driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText());
			if(actual_year>year)
			{
				driver.findElement(By.xpath("//span[text()='Prev']")).click();
			}
			else if (actual_year<year)
			{
				driver.findElement(By.xpath("//span[text()='Next']")).click();
			}
			else
			{
				break;
			}
		}
	}
}
