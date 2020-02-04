package ApplicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LogoutPage {
WebDriver driver;
Actions ac;
public LogoutPage(WebDriver driver)
{
	this.driver=driver;
}
@FindBy(id="welcome")
WebElement objwelcome;
@FindBy(linkText="Logout")
WebElement objlogout;
public void verifylogout()throws Throwable
{
	ac=new Actions(driver);
	ac.moveToElement(objwelcome).click().perform();
	Thread.sleep(4000);
	ac.moveToElement(objlogout).click().perform();
	Thread.sleep(4000);
}
}
