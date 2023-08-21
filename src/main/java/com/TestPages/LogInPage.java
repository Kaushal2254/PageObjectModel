package com.TestPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.TestBase.TestBase;


public class LogInPage extends TestBase {
	//Page Factory - OR:
		@FindBy(name="user-name")
		WebElement username;
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(id="login-button")
		WebElement loginBtn;
		
		@FindBy(xpath="//button[contains(text(),'Sign Up')]")
		WebElement signUpBtn;
		
		@FindBy(xpath="//img[contains(@class,'img-responsive')]")
		WebElement crmLogo;
		
		//Initializing the Page Objects:
		public LogInPage(){
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		
		public boolean validateCRMImage(){
			return crmLogo.isDisplayed();
		}
		public void logInToSauce (String usname, String pswd) {
			username.sendKeys(usname);
			password.sendKeys(pswd);
			loginBtn.click();
		}
		
		}

