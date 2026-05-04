Feature: JSONPlaceholder API Validation

  @api
  Scenario: Retrieve post details and verify data
    Given the API base URL is "https://jsonplaceholder.typicode.com"
    When I send a GET request for post id "1"
    Then the status code should be 200
    And the response should contain the title "sunt aut facere repellat provident occaecati excepturi optio reprehenderit"