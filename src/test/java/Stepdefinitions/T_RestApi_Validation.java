package Stepdefinitions;

import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;


public class T_RestApi_Validation {
	
	//private Response response;

    //@Given("the API base URL is {string}")
    //public void setBaseUrl(String url) {
    //   RestAssured.baseURI = url;
    //}

    @When("I send a GET request for post id {string}")
    public void sendGetRequest(String id) {
    	CommonSteps.response = given()
                    .when()
                    .get("/posts/" + id);
    }

    //@Then("the status code should be {int}")
    //public void verifyStatusCode(int code) {
    //    response.then().statusCode(code);
    //}

}
