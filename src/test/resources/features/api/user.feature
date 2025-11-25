@api
Feature: User CRUD on JSONPlaceholder API

  @get-user
  Scenario: Get user by id
    Given I have a valid user id
    When I get user by id
    Then the response status should be 200
    And the response should contain user id

  @api @create-delete-user
  Scenario: Create and delete user
    Given I prepare a new user payload
    When I create a new user
    Then the response status should be 201
    And I save the created user id
    When I delete the created user
    Then the response status should be 200