/**
 * 
 */
package pages;

import org.openqa.selenium.By;

/**
 * @author Naveen.S
 *
 */
public class AccountSummaryPage extends BasePage {

		By PayBillsLink=By.xpath("//a[text()='Pay Bills']");
		By AccountActivityLink=By.xpath("//a[text()='Account Activity']");
		
		public void clickPayBillsLink()
		{
			performClick(PayBillsLink);
		}
		public void clickAccountActivityLink()
		{
			performClick(AccountActivityLink);
		}
}
