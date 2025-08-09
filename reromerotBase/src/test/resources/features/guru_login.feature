Feature: Succes Login in a home page

  As a user
  I want to log in to the application
  So that I can access the dashboard

  # Escenario 1: Login con usuario y contraseña válidos
  Scenario Outline: Successfully log in with valid credentials
    Given I navigate to the "<pageAlias>" login page
    When I enter username "<username>" and password "<password>"
    And I submit the login form
    Then I should see the welcome "<title>" "<managerId>"

    Examples:
      | pageAlias | username   | password | title                                    | managerId              |
      | guru      | mngr630468 | qahUzed  | Welcome To Manager's Page of Guru99 Bank | Manger Id : mngr630468 |
      | guru      | mngr630469 | qEvEmAg  | Welcome To Manager's Page of Guru99 Bank | Manger Id : mngr630469 |

  # Escenario 2: Intento de login con credenciales incorrectas
  Scenario: Unsuccessful login with invalid credentials
    Given I navigate to the "guru" login page
    When I enter username "wronguser" and password "wrongpass"
    And I submit the login form
    Then I should see the error message "User or Password is not valid"