Feature: Logout Functionality

@SEAMLES-846 @AC1 @wip
  Scenario: Verify that user can log out and ends up in login page
    Given User is successfully logged in
    When User clicks user icon on the top right of the page
    And User clicks "logout" user menu
    Then User should be logout and redirected to login page

@SEAMLES-847 @AC2 @wip
  Scenario: Verify that user can not navigate back to home page after logging out
    Given User is successfully logged in
    When User is logged out successfully
    And User clicks step back button
    Then User should not go to home page again
