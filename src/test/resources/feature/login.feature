Feature: Login

  Scenario: Login on qase.io
    Given Login page opened
    When Input EMAIL and PASSWORD and click Login button
    Then Button Create new project  on page