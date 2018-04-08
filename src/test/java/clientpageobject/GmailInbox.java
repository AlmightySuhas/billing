package clientpageobject;

import static org.junit.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailInbox extends LoadableComponent<GmailInbox>
{
	@FindBy (id=":h4")
	private WebElement Compose;
	@FindBy (xpath="//input/following-sibling::textarea[@name='to']")
	private WebElement To;
	@FindBy (id=":m9")
	private WebElement Subject;
	@FindBy (id=":na")
	private WebElement Body;
	@FindBy(id=":lx")
	private WebElement Send;
	@FindBy (xpath="//span[@class='gb_ab gbii']")
	private WebElement S;
	@FindBy (xpath="//a[@id='gb_71']")
	private WebElement LogOut;
	private WebDriver driver;
	private String Title="Inbox";
	public GmailInbox(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@Override
	protected void load()
	{
		
	}

	@Override
	protected void isLoaded() throws Error
	{
		
	//assertTrue("GmailInbox Not loaded Properely",driver.getTitle().contains(Title));
	}
	
	public GmailInbox compose(String to,String subject,String body)
	{
		WebDriverWait  wait=new WebDriverWait(driver,120);
		wait.until(ExpectedConditions.visibilityOf(Compose));
		Compose.click();
		wait.until(ExpectedConditions.visibilityOf(To));
		To.sendKeys(to);
		wait.until(ExpectedConditions.visibilityOf(Subject));
		Subject.sendKeys(subject);
		wait.until(ExpectedConditions.visibilityOf(Body));
		Body.sendKeys(body);
		wait.until(ExpectedConditions.visibilityOf(Send));
		Send.click();
		return this;
	}
	public GmailLogin logout()
	{
		S.click();
		LogOut.click();
		GmailLogin myLogin=new GmailLogin(driver);
		return myLogin;
	}
	
}
