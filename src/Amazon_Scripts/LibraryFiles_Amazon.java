package Amazon_Scripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LibraryFiles_Amazon extends Amazon_Testing {

	

	public static void click(String strObjLocatior, String strValue) throws Exception {
		if (!strValue.equalsIgnoreCase("")) {
			try {

				WebElement element = findDisplayingElement(strObjLocatior);
				if (element.isDisplayed()) {
					((JavascriptExecutor) webDriver).executeScript("arguments[0].click()", element);
					// element.click();
				}
				
			} catch (Exception e) {

				{

				}
			}
		}
	}

	public static WebElement findDisplayingElement(String xpath) throws Exception {
		List<WebElement> elementList = findWebElements(xpath);
		WebElement displayingElement = null;
		try {
			for (WebElement element : elementList) {
				if (element.isDisplayed()) {
					displayingElement = element;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// reportResults("", "Failure in findDisplayingElement method",
			// "Fail");
		}
		return displayingElement;
	}

	public static List<WebElement> findWebElements(String Locator) throws Exception {

		List<WebElement> element = null;

		try {

			if (Locator.startsWith("css=")) {
				Locator = Locator.substring(4);
				element = webDriver.findElements(By.cssSelector(Locator));
			} else if (Locator.startsWith("id=")) {
				Locator = Locator.substring(3);
				element = webDriver.findElements(By.id(Locator));
			} else if (Locator.startsWith("xpath=")) {
				Locator = Locator.substring(6);
				element = webDriver.findElements(By.xpath(Locator));
			} else if (Locator.startsWith("name=")) {
				Locator = Locator.substring(5);
				element = webDriver.findElements(By.name(Locator));
			} else if (Locator.startsWith("link=")) {
				Locator = Locator.substring(5);
				element = webDriver.findElements(By.linkText(Locator));
			} else if (Locator.startsWith("class=")) {
				Locator = Locator.substring(6);
				element = webDriver.findElements(By.className(Locator));
			} else {
				element = (List<WebElement>) ((JavascriptExecutor) webDriver).executeScript(Locator);
			}
		} catch (Exception e) {
			return null;
		}
		return element;
	}

	public static void sendKeys(String strObjLocatior, String strValue) throws Exception {
		if (!strValue.equalsIgnoreCase("")) {

			WebElement element = findDisplayingElement(strObjLocatior);
			try {
				if (element.isDisplayed()) {
					element.clear();
					element.sendKeys(strValue);

				} else {

				}
			} catch (Exception e) {

			}
		}
	}
	
	

	public static void iteamSearchanddisplayIT() throws InterruptedException {
		Thread.sleep(8000);
		/*WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='a-section a-spacing-medium']")));
		*/
		try {
			int i = 1;
			List<WebElement> WebElement = webDriver.findElements(By
					.xpath("//div[@class='a-section a-spacing-medium']"));
			int count=WebElement.size();
			for (WebElement element : WebElement) {
				String text = webDriver
						.findElement(
								By.xpath("(//div[@class='a-section a-spacing-medium']//span[1][@class='a-price']//span[@class='a-price-whole'])["
										+ i + "]")).getText();

				String clean = text.replaceAll("[,]", "");
				int number = Integer.parseInt(clean);

				if (number >= 500) {
					// System.out.println(number +"its from integer");
					String product = webDriver
							.findElement(
									By.xpath("(//div[@class='a-section a-spacing-medium']//span[@class='a-size-medium a-color-base a-text-normal'])["
											+ i + "]")).getText();

					System.out.println();
					System.out.println("Product name is   " + product + " Amount is  " + number);

				}

				i++;
				if(i==count-1){
					break;
				}

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	public static void action_Keyborad(WebElement elementlocation, String text) throws InterruptedException {
		elementlocation.sendKeys(text);
		Thread.sleep(2000);
		elementlocation.sendKeys(Keys.DOWN);
		elementlocation.sendKeys(Keys.DOWN);
		elementlocation.sendKeys(Keys.DOWN);
		elementlocation.sendKeys(Keys.DOWN);
		elementlocation.sendKeys(Keys.DOWN);
		elementlocation.sendKeys(Keys.ENTER);
		
		
	}
	
	public static void Ui_Verify(String verify) {
		try {

			verify = verify.toLowerCase();
			switch (verify) {

			case "empty":

				LibraryFiles_Amazon.click(Amazon_POM.Login.btn_Continue, "click");
				WebElement alertEmpty = LibraryFiles_Amazon.findDisplayingElement(Amazon_POM.Login.alrt_emptyEmain);
				if (alertEmpty.getText().contains("Enter your email or mobile phone number"))
					System.out.println("Empty validation has been verified successfully");
				else
					System.out.println("Empty validation has not been verified");

				break;
			case "invalid":
				LibraryFiles_Amazon.sendKeys(Amazon_POM.Login.txt_EmailorNo, "abl");
				LibraryFiles_Amazon.click(Amazon_POM.Login.btn_Continue, "click");
				WebElement alertInvalid = LibraryFiles_Amazon.findDisplayingElement(Amazon_POM.Login.alrt_invalidEmain);
				if (alertInvalid.getText().contains("We cannot find an account with that email address"))
					System.out.println("Invalid mobile No validation has been verified successfully");
				else
					System.out.println("Invalid mobile No validation has not been verified");

				break;

			default:
				break;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
