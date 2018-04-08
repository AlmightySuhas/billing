package clientpageobject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;



import java.util.*;

public class GmailLogin extends LoadableComponent<GmailLogin>  
{
	@FindBy (id="identifierId")
	private WebElement LoginName;
	
	@FindBy (className="CwaK9")
	private WebElement Next;
	@FindBy (className="CwaK9")
	private WebElement Next1;
	@FindBy (name="password")
	private WebElement Password;
	private WebDriver driver;
	private String url = "http://www.gmail.com";
	private String title = "Gmail";
	
	public GmailLogin()
	{
		System.setProperty("webdriver.chrome.driver","test\\resources\\chromedriver.exe");
		driver=new ChromeDriver();
//		System.setProperty("webdriver.gecko.driver","test\\resources\\geckodriver64bit19.exe");
//		driver=new FirefoxDriver();
		PageFactory.initElements(driver, this);
		
	}
	public GmailLogin(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@Override
	protected void load() 
	{
		driver.get(url);
		
	}

	@Override
	protected void isLoaded() throws Error 
	{
		//assertEquals("GmailLoginPage Not loaded Properely",title, driver.getTitle());
		
	}

	
	public GmailInbox login(String username,String password)
	{
		LoginName.sendKeys(username);
		Next.click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='autosuggest-head']/following-sibling::*[1]")));
		WebDriverWait  wait=new WebDriverWait(driver,180);
		wait.until(ExpectedConditions.visibilityOf(Password));
		Password.sendKeys(password);
		wait.until(ExpectedConditions.visibilityOf(Next));
		Next.click();
		GmailInbox myInbox=new GmailInbox(driver);
		return myInbox;
	}
	public void close()
	{
		driver.close();
		
	}
	public void alert()
	{
		Alert alert=driver.switchTo().alert();
		
		alert.accept();
	}
}
