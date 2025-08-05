Feature: Login Functionality for Multiple Users

  Scenario Outline: Login attempt with multiple credentials
    Given user is on the login page
    When user enters username "<username>" and password "<password>"
    And clicks the login button
    Then login result "<result>"

    Examples:
      | username             | password   | result                            |
      | admin@shophub.com    | admin123   | login should be successful        |
      | user@example.com     | user123    | login should be successful        |
      | guest@demo.com       | guest123   | login should be successful        |
      | user@invalid.com     | wrongpass  | error message should be displayed |
