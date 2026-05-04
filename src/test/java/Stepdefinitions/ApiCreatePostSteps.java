package Stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiCreatePostSteps {
	
	//private Response response;

    @When("I create a new post with title {string} and body {string}")
    public void createPost(String title, String body) {
        // Constructing the JSON payload using the parameters from the feature file
        String payload = "{\"title\": \"" + title + "\", \"body\": \"" + body + "\", \"userId\": 1}";
        
        CommonSteps.response = given()
                    .header("Content-Type", "application/json")
                    .body(payload)
                   .when()
                    .post("/posts");
    }

}
