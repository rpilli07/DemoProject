Feature: Post Creation API
  
  @api
  Scenario Outline: Create new posts and verify
    Given the API base URL is "https://jsonplaceholder.typicode.com"
    When I create a new post with title "<title>" and body "<body>"
    Then the status code should be 201
    And the response should contain the title "<title>"

    Examples:

      | title             | body                |
      | Selenium API Test | Learning automation |
      | Cucumber API Test | Using Rest Assured  |