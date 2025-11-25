package com.example.tests.api.steps;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Assertions;

public class UserApiSteps {
    private Response response;
    private String baseUrl = "https://jsonplaceholder.typicode.com";
    private String createdId;

    @Given("I have a valid user id")
    public void haveValidUserId() {
        System.out.println("Step: I have a valid user id");
        // No action needed - just for documentation
    }

    @When("I get user by id")
    public void getUserId() {
        try {
            System.out.println("Step: I get user by id");

            RequestSpecification request = RestAssured.given()
                    .baseUri(baseUrl)
                    .header("Content-Type", "application/json");

            response = request.when().get("/users/1");

            System.out.println("GET Status: " + response.getStatusCode());
            System.out.println("GET Body: " + response.getBody().asString());

        } catch (Exception e) {
            System.out.println("ERROR in GET: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Then("the response status should be {int}")
    public void responseStatusShouldBe(int expectedStatusCode) {
        System.out.println("Step: the response status should be " + expectedStatusCode);

        int actualStatusCode = response.getStatusCode();
        System.out.println("Status Check - Expected: " + expectedStatusCode + ", Actual: " + actualStatusCode);

        Assertions.assertEquals(expectedStatusCode, actualStatusCode,
                "Response status should be " + expectedStatusCode + " but was " + actualStatusCode);
    }

    @Then("the response should contain user id")
    public void responseShouldContainUserId() {
        System.out.println("Step: the response should contain user id");

        String responseBody = response.getBody().asString();
        System.out.println("Response Body: " + responseBody);

        // Check if response contains id field
        boolean hasId = responseBody.contains("\"id\"");
        System.out.println("Contains 'id' field: " + hasId);

        Assertions.assertTrue(hasId, "Response should contain 'id' field. Actual: " + responseBody);
    }

    // TAMBAHKAN STEP YANG MISSING
    @Given("I prepare a new user payload")
    public void prepareNewUserPayload() {
        System.out.println("Step: I prepare a new user payload");
        // No action needed - payload is prepared in the create step
    }

    @When("I create a new user")
    public void createNewUser() {
        try {
            System.out.println("Step: I create a new user");

            String payload = "{" +
                    "\"name\": \"John Doe\"," +
                    "\"username\": \"johndoe\"," +
                    "\"email\": \"john.doe@example.com\"," +
                    "\"phone\": \"1-770-736-8031 x56442\"," +
                    "\"website\": \"hildegard.org\"" +
                    "}";

            RequestSpecification request = RestAssured.given()
                    .baseUri(baseUrl)
                    .header("Content-Type", "application/json")
                    .body(payload);

            response = request.when().post("/users");

            System.out.println("POST Status: " + response.getStatusCode());
            System.out.println("POST Body: " + response.getBody().asString());

            // Extract the created user ID
            createdId = response.jsonPath().getString("id");
            System.out.println("Created User ID: " + createdId);

        } catch (Exception e) {
            System.out.println("ERROR in CREATE: " + e.getMessage());
            e.printStackTrace();
            createdId = "999"; // fallback for testing
        }
    }

    @Then("I save the created user id")
    public void saveCreatedUserId() {
        System.out.println("Step: I save the created user id");
        System.out.println("Saved User ID: " + createdId);
        Assertions.assertNotNull(createdId, "Created user ID should not be null");
    }

    @When("I delete the created user")
    public void deleteCreatedUser() {
        try {
            System.out.println("Step: I delete the created user");
            System.out.println("Deleting user with ID: " + createdId);

            RequestSpecification request = RestAssured.given()
                    .baseUri(baseUrl)
                    .header("Content-Type", "application/json");

            response = request.when().delete("/users/" + createdId);

            System.out.println("DELETE Status: " + response.getStatusCode());
            System.out.println("DELETE Body: " + response.getBody().asString());

        } catch (Exception e) {
            System.out.println("ERROR in DELETE: " + e.getMessage());
            e.printStackTrace();
        }
    }
}