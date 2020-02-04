package CommonFunLibraray;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import Constant.PBConstant;
public class CommonFunctions extends PBConstant {
	/*Project Name:Primus Bank
	 * Autor Name:Ranga
	 * Module Name: Admin login
	 * Created Date:01/02/2020
	 */
	public static boolean verifyLogin(String username,String password)throws  Throwable
	{
		driver.findElement(By.xpath(p.getProperty("Objusername"))).sendKeys(username);
		driver.findElement(By.xpath(p.getProperty("Objpassword"))).sendKeys(password);
		driver.findElement(By.xpath(p.getProperty("ObjLogin"))).click();
		Thread.sleep(5000);
		String Expval="adminflow";
		String Actval=driver.getCurrentUrl();
		if(Actval.toLowerCase().contains(Expval.toLowerCase()))
		{
			Reporter.log("Login Success",true);
			return true;
		}
		else
		{
			Reporter.log("Login Fail",true);
			return false;
		}
	}
	/*Project Name:Primus Bank
	 * Autor Name:Ranga
	 * Module Name: navigate branches
	 * Created Date:01/02/2020
	 */
	public static void navigateBranches()throws Throwable
	{
		driver.findElement(By.xpath(p.getProperty("Objbranches"))).click();
		Thread.sleep(5000);
	}
	public static boolean verifyBranchCreation(String bname,String address1,String zipcode,
			int country,int state,int city)throws Throwable
	{
		driver.findElement(By.xpath(p.getProperty("Objnewbranch"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath(p.getProperty("objbname"))).sendKeys(bname);
		driver.findElement(By.xpath(p.getProperty("objaddress1"))).sendKeys(address1);
		driver.findElement(By.xpath(p.getProperty("objzipcode"))).sendKeys(zipcode);
		new Select(driver.findElement(By.xpath(p.getProperty("objcountry")))).selectByIndex(country);
		Thread.sleep(3000);
		new Select(driver.findElement(By.xpath(p.getProperty("objstate")))).selectByIndex(state);
		Thread.sleep(3000);
		new Select(driver.findElement(By.xpath(p.getProperty("objcity")))).selectByIndex(city);
		Thread.sleep(3000);
		driver.findElement(By.xpath(p.getProperty("objsubmit"))).click();
		Thread.sleep(4000);
		//get alert message
		String alertmessage=driver.switchTo().alert().getText();
		System.out.println(alertmessage);
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		Thread.sleep(4000);
		String Expval="New Branch";
		if(alertmessage.toLowerCase().contains(Expval.toLowerCase()))
		{
			Reporter.log("Branch Creation is success",true);
			return true;
		}
		else
		{
			Reporter.log("Branch Creation is Fail",true);
			return false;
		}
	}
	/*Project Name:Primus Bank
	 * Autor Name:Ranga
	 * Module Name: Update Branch
	 * Created Date:01/02/2020
	 */
	public static boolean verifyBranchUpdation(String bname,String address1)throws Throwable
	{
		driver.findElement(By.xpath(p.getProperty("objedit"))).click();	
		Thread.sleep(4000);
		WebElement branch=driver.findElement(By.xpath(p.getProperty("objubname")));
		branch.clear();
		Thread.sleep(4000);
		branch.sendKeys(bname);
		WebElement address=driver.findElement(By.xpath(p.getProperty("objaddress")));
		address.clear();
		Thread.sleep(4000);
		address.sendKeys(address1);
		driver.findElement(By.xpath(p.getProperty("objupdate"))).click();	
		String updatebranchalert=driver.switchTo().alert().getText();
		System.out.println(updatebranchalert);
		Thread.sleep(4000);
		driver.switchTo().alert().accept();
		String Expval="Branch updated";
		if(updatebranchalert.toLowerCase().contains(Expval.toLowerCase()))
		{
			Reporter.log("Branch Update Success",true);
			return true;
		}
		else
		{
			Reporter.log("Branch Update Fail",true);
			return false;
		}
	}
	/*Project Name:Primus Bank
	 * Autor Name:Ranga
	 * Module Name: Admin logout
	 * Created Date:01/02/2020
	 */
	public static boolean verifyLogout()throws Throwable
	{
		driver.findElement(By.xpath(p.getProperty("objlogout"))).click();	
		Thread.sleep(4000);
		if(driver.findElement(By.xpath(p.getProperty("ObjLogin"))).isDisplayed())
		{
			Reporter.log("logout success",true);
			return true;
		}
		else
		{
			Reporter.log("logout Fail",true);
			return false;
		}
	}
}
















