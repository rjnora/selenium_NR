@feature.login
Feature: Login

  Background:
    Given I open web PORTAL PASTI AHM
    When I fill in "m.dummy.b1" as username

  @Login.sukses @sanity
  Scenario: Login Successfully
    Then I fill in "Honda2020!" as password
    And I click login button
    And I should see "Announcement" text

  @Login.gagal @sanity
  Scenario: Login failed using invalid password
    Then I fill in "Salah" as password
    And I click login button
    And I should see "Invalid username / password" text

    @login.outline
    Scenario Outline: Login scenario
      Then I fill in "<password>" as password
      And I click login button
      And I should see "<textValidation>" text
      Examples:
        | password   | textValidation              |
        | Honda2020! | Announcement                |
        | salah      | Invalid username / password |