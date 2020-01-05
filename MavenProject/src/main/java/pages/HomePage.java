/**
 * 
 */
package pages;

import org.openqa.selenium.By;

/**
 * @author Naveen.S
 *
 */
public class HomePage extends BasePage{

	By signinbutton=By.id("signin_button");
	
	public void clickSignInButton()
	{
		performClick(signinbutton);
	}
}
