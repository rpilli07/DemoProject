package Stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;

public class CommonSteps {
	
	public static Response response; 
	
	@Given("the API base URL is {string}")
    public void setBaseUrl(String url) {
        RestAssured.baseURI = url;
        System.out.println("Base URI set to: " + url);        
	}
	
	@Then("the status code should be {int}")
    public void verifyStatusCode(int code) {
        response.then().statusCode(code);
    }
	@And("the response should contain the title {string}")
    public void verifyTitle(String expectedTitle) {
        response.then().body("title", equalTo(expectedTitle));
    }
	

}
