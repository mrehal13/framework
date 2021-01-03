package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RiaLoginPO {

	@FindBy(xpath="//*[@name='emailAddress']")
	public WebElement username_textbox;
	
	@FindBy(xpath = "//*[@name='password']")
	public WebElement password_textbox;
	
	@FindBy(xpath = "//*[@data-qat='signin-button']")
	public WebElement signIn_button;
	
	public RiaLoginPO(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}
