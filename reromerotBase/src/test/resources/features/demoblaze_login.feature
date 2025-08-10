Feature: Demoblaze Log In from the Home Page

  As a user
  I want to login to the application
  So that I can access to the ecommerce

  # Escenario 1: Login con usuario y contraseña válidos
  Scenario Outline: Login and access to the store with valid credentials
    Given I navigate to the "<pageAlias>" login page
    When I enter username "<username>" and password "<password>" on "<pageAlias>"
    And I submit the login form on "<pageAlias>"
    Then I should see the welcome "<title>" on "<pageAlias>"

    Examples:
      | pageAlias | username   | password    | title              |
      | demoblaze | reromeroD1 | PruebaDemo1 | Welcome reromeroD1 |
      | demoblaze | reromeroD2 | PruebaDemo2 | Welcome reromeroD2 |


  # Escenario 2: Intento de login con credenciales incorrectas
  Scenario: Unsuccessful login with invalid credentials
    Given I navigate to the "demoblaze" login page
    When I enter username "wronguser" and password "wrongpass" on "demoblaze"
    And I submit the login form on "demoblaze"
    Then I should see the error message "Wrong password." on "demoblaze"
