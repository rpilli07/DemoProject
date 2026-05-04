package Stepdefinitions;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.*;
import utils.WaitHelper;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.interactions.Actions;
import org.junit.jupiter.api.Assertions; 

public class T_Shoppingcart_Steps extends BaseClass {
		
	WebDriver driver;
	String ProductName;
	String TPprice;
	String title;
	String price;
	
	@Given("User invokes TestPage")
	public void user_invokes_test_page() throws InterruptedException {
		
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Inside Step: User invokes TestPage");
		driver = new ChromeDriver();
//      Initializes the WaitHelper utility with the current driver instance to enable explicit waits
		waitHelper = new WaitHelper(driver);			
		driver.navigate().to("https://testpages.eviltester.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();		
//		Title validation
		System.out.println(driver.getTitle());
		Assertions.assertEquals("Software Testing Practice Pages, Apps, and Challenges", driver.getTitle(), "The page title does not match!");
			
	}
	
	@And("User navigates to Shopping Cart")
	public void user_navigates_to_shopping_cart() throws InterruptedException {
//	    Write code here that turns the phrase above into concrete actions
		System.out.println("Inside Step: User navigates to Shopping Cart");
		
//		Click the App link
		By Tapps = By.cssSelector("a[id$='apps']");
		
//		waitForElementClickable
		var element = waitHelper.waitForElementClickable(Tapps, 15);
		if(element !=null) {
			element.click();
		}
		
//		Click Shopping Cart
		By Tcart = By.xpath("//*[@id='m-appsbasiccart']");
		element = waitHelper.waitForElementClickable(Tcart, 15);
		if(element !=null) {
			element.click();
		}
	    
	}	

	@And("User views {string} and adds to cart")
	public void user_views_product_and_adds_to_cart(String productName) {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Inside Step: User views product and adds to cart");
		System.out.println("Captured Product: " + productName);
		var element = waitHelper.waitForElementClickable(By.xpath("//div[@id='productGrid']//div[@class='card']"),10);
		if(element !=null) {
		
		List<WebElement> cards = driver.findElements(By.xpath("//div[@id='productGrid']//div[@class='card']"));

		
		for (WebElement card : cards) {
		    
		    title = card.findElement(By.xpath(".//div[@class='title']")).getText().trim();
		    price = card.findElement(By.xpath(".//div[@class='price']")).getText().trim();
		    
		    
		    System.out.println(title);
		    System.out.println(price);
		    
		    // Example: Click the 'View' button ONLY for a specific product
		   // if (title.equals("Solar Powered Whatchamacallit 8")) {
		    if (title.equals(productName)) {	
		    	WebElement viewbutton = card.findElement(By.className("view"));
		        
		        // Click it using the ENTER key
		        viewbutton.sendKeys(org.openqa.selenium.Keys.ENTER);
		        By TaddBtn = By.xpath("//*[@id='productContainer']/div[1]/button");
				waitHelper.jsClick(TaddBtn, 10);
		        System.out.println("Keyboard Enter attempted for: " + title);
		      
		        break;
		    }
		}
		}	
		
	}

	@When("User checkout")
	public void user_checkout() {
	   
		System.out.println("Inside Step: User checkout");
		By Tcart = By.xpath("/html/body/div/main/div/div[1]/div[3]/div");
		//*[@id="productContainer"]/div[1]/button
		try {
		Thread.sleep(3000);	
		
		var element = waitHelper.jsClick(Tcart, 20);
		
			
		By TchkOut = By.xpath("//*[@id='checkoutBtn']");
		
		element = waitHelper.waitForElementClickable(TchkOut, 20);
		if(element !=null) {
			element.click();
		}	  
		}catch(Exception e) {
            System.out.println("LOG: Element not found: ");
     
	    }
	}

	@And("User login")
	public void user_login() {
	    
		System.out.println("Inside Step: user_login");
		WebElement idElement = waitHelper.waitForElementClickable(By.xpath("//*[@id=\'exampleId\']"), 10);
		
		String TcustomerID = idElement.getText().trim();

		WebElement passElement = waitHelper.waitForElementClickable(By.id("examplepassId"), 10);
		String YcapturedPassword = passElement.getText().trim();

		By usernameField = By.id("customerId");
		idElement = waitHelper.waitForElementClickable(usernameField, 10);
		idElement.click();
		idElement.sendKeys(TcustomerID);
		
	    By passwordField = By.id("password");
		passElement = waitHelper.waitForElementClickable(passwordField, 10);
		passElement.click();
		passElement.sendKeys(YcapturedPassword);
		
		By TSubtn = By.xpath("//*[@id='loginForm']/div/div[1]/button[2]");
	    WebElement BtnElement =  waitHelper.waitForElementClickable(TSubtn, 10);
	    BtnElement.click();
	}

	@Then("User successful checkout and confirmation")
	public void user_successful_checkout_and_confirmation() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Inside Step: User successful checkout and confirmation");
			  
		By Pname = By.xpath("//*[@id='cartContainer']/div[1]/div[1]");
		WebElement pelement = waitHelper.waitForElementClickable(Pname, 10);
		Assertions.assertEquals(pelement.getText(), title);		
		By Totalprice = By.xpath("//*[@id='cartContainer']/div[1]/div[5]");
		WebElement Telement = waitHelper.waitForElementClickable(Totalprice, 10);
		
		int startIndex =  Telement.getText().indexOf("$");
		
		String priceValue = Telement.getText().substring(startIndex); 
   
	   Assertions.assertEquals(priceValue, price);
	 
	    try {

		By TChkout = By.xpath("//*[@id=\'checkoutBtn\']");
	    WebElement BtnElement =  waitHelper.waitForElementClickable(TChkout, 20);
	    BtnElement.click();
	    
	    Thread.sleep(2000);
	    
	    By TBtnchkout = By.xpath("//*[@id=\'confirmBtn\']");
	    WebElement Btnchkout = waitHelper.waitForElementClickable(TBtnchkout, 20);
	    Btnchkout.click();
	    
	    By confOrdr = By.xpath("//h1[text()='Order Confirmation']");
	    WebElement Tvalue = waitHelper.waitForElementClickable(confOrdr, 10); 
	    }catch(Exception e) {
            System.out.println("LOG: Element not found: ");
     
	    }
	    driver.quit();
	
		}


}