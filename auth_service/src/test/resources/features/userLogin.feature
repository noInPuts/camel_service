Feature: Logging in which returns the user object and a JWT Token

  Scenario: User logging in
    Given I want to login, onto the "test_user" account with "pAssword!1" as the password
    When I make a login POST request to "/user/login" with the following body:
      | username | password |
      | test_user | pAssword!1 |
    Then I should receive the user object and JWT:
      | username | password | id | jwt |
      | test_user | null | 1 | token |

