package Amazon_Scripts;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Report.JUnitHTMLReporter;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Amazon_Testing extends JUnitHTMLReporter {
	public File fl;
	public Properties pro;
	public static WebDriver webDriver;

	@Before
	public void newTesting() {
		propertyfile();
		System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
		webDriver = new ChromeDriver();
		webDriver.manage().window().maximize();
		webDriver.get(Amazon_POM.Login.url);
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wb = new WebDriverWait(webDriver, 150);
		wb.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Amazon_POM.Login.check_logo)));

	}

	@Test
	public void amazonLoginValidation() {
		try {
			LibraryFiles_Amazon.click(Amazon_POM.Login.btn_login, "click");
			LibraryFiles_Amazon.Ui_Verify("empty");
			LibraryFiles_Amazon.Ui_Verify("invalid");
			Thread.sleep(2000);
			LibraryFiles_Amazon.sendKeys(Amazon_POM.Login.txt_EmailorNo, pro.getProperty("mail"));
			LibraryFiles_Amazon.click(Amazon_POM.Login.btn_Continue, "click");
			LibraryFiles_Amazon.sendKeys(Amazon_POM.Login.txt_password, pro.getProperty("password"));
			LibraryFiles_Amazon.click(Amazon_POM.Login.txt_SignIn, "click");
			Thread.sleep(2000);
			LibraryFiles_Amazon.action_Keyborad(
					LibraryFiles_Amazon.findDisplayingElement(Amazon_POM.ProductSearch.element_txt),
					pro.getProperty("product"));
			LibraryFiles_Amazon.iteamSearchanddisplayIT();
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	@After
	public void logout() {
		try {

			Actions action = new Actions(webDriver);
			WebElement btn = LibraryFiles_Amazon.findDisplayingElement(Amazon_POM.ProductSearch.Account_Logout);
			action.moveToElement(btn).perform();
			Thread.sleep(2000);
			LibraryFiles_Amazon.click(Amazon_POM.ProductSearch.btn_Signout, "click");
			Thread.sleep(2000);
			if (LibraryFiles_Amazon.findDisplayingElement(Amazon_POM.Login.txt_EmailorNo).isDisplayed()) {
				System.out.println("User has been logged out successfully");

			}
			webDriver.quit();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @author jsekar
	 * @see Initialise the Property file
	 */

	public void propertyfile() {

		try {

			fl = new File(".//TestData.Properties");
			FileInputStream fs = new FileInputStream(fl);
			pro = new Properties();
			pro.load(fs);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
