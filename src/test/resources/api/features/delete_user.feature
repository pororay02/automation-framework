@When("I get the user by ID")
public void i_get_the_user_by_id() {
response = given()
.header("app-id", appId)
.when()
.get("/user/" + createdUserId)
.then()
.extract().response();

System.out.println("GET Response: " + response.getBody().asString());
}

@Then("the user data should be returned")
public void the_user_data_should_be_returned() {
response.then().statusCode(200);
assertNotNull(response.jsonPath().getString("id"), "ID should not be null");
assertEquals(createdUserId, response.jsonPath().getString("id"), "ID should match");
}
