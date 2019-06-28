package Amazon_Scripts;

public class Amazon_POM {

	public static class Login {
		
		public static String btn_login = "xpath=//span[text()='Hello, Sign in']";
		public static String url = "https://www.amazon.in/";
		public static String check_logo = "//span[@class='nav-sprite nav-logo-base']";
		public static String alrt_emptyEmain = "xpath=//div[contains(text(),'Enter your email or mobile phone number')]";
		public static String alrt_invalidEmain = "xpath=//span[contains(text(),'We cannot find an account with')]";
		public static String txt_EmailorNo = "xpath=//input[@id='ap_email']";
		public static String btn_Continue = "xpath=//input[@id='continue']";
		public static String txt_password = "xpath=//input[@id='ap_password']";
		public static final String txt_SignIn = "xpath=//input[@id='signInSubmit']";
		

		
	}
	
	public static class ProductSearch {
		
		public static String msg_welcomeMsg = "xpath=//div[@class='welcome-msg']";
		public static String Account_Logout = "xpath=//span[contains(text(),'Account & Lists') and @class='nav-line-2']";
		
		public static String btn_Signout = "xpath=//span[text()='Sign Out']";
		public static String elemt_baseProducts = "xpath=//div[contains(@data-cel-widget,'search_result')]";
		public static String elemt_Price = "//span[contains(@class,'a-price')]//span[@class='a-price-whole']";
		public static String elemt_name="//h2//span"; 
		public static String element_txt="xpath=//*[@id='twotabsearchtextbox']";
		
	}

}
