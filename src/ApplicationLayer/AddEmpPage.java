package ApplicationLayer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
public class AddEmpPage {
	WebDriver driver;
	Actions ac;
	public AddEmpPage(WebDriver driver)
	{
		this.driver=driver;
	}
	@FindBy(id="menu_pim_viewPimModule")
	WebElement objpim;
	@FindBy(css="#btnAdd")
	WebElement objAdd;
	@FindBy(css="#firstName")
	WebElement objfname;
	@FindBy(css="#lastName")
	WebElement objlname;
	@FindBy(css="#btnSave")
	WebElement objsave;
	public void verifyEmp(String fname,String lname)throws Throwable
	{
		ac=new Actions(driver);
		ac.moveToElement(objpim).click().perform();
		Thread.sleep(4000);
		ac.moveToElement(objAdd).click().perform();
		Thread.sleep(4000);
		objfname.sendKeys(fname);
		objlname.sendKeys(lname);
		ac.moveToElement(objsave).click().perform();
		Thread.sleep(4000);
	}

}























