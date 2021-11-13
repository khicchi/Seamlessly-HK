Feature: Login Functionality

@SEAMLES-836 @AC1/1
Scenario Outline: Verify that user can login with valid credentials / By ENTER key
    Given User navigates to Login Page
    When User enters "<userName>" to username textbox
    And User enters "<password>" to password textbox
    And User presses Enter key
    Then User should be able to land on the Files page
    Examples:
      | userName   | password    |
      | Employee81 | Employee123 |

@SEAMLES-838  @AC1/2
Scenario Outline: Verify that user can login with valid credentials / By Clicking
    Given User navigates to Login Page
    When User enters "<userName>" to username textbox
    And User enters "<password>" to password textbox
    And User clicks LogIn button
    Then User should be able to land on the Files page
    Examples:
      | userName   | password    |
      | Employee81 | Employee123 |

@SEAMLES-839    @AC2/1
Scenario Outline: Verify that user can not login with any invalid credentials
    Given User navigates to Login Page
    When User enters "<userName>" to username textbox
    And User enters "<password>" to password textbox
    And User clicks LogIn button
    Then Wrong username or password. message should be displayed
    Examples:
      | userName   | password    |
      | Employee81 | hfhfhfh     |
      | hfhfhf     | Employee123 |
      | jfjfjf     | khkhkhk     |

@SEAMLES-840    @AC2/2
Scenario Outline: Verify that user can not login with empty credentials
    Given User navigates to Login Page
    When User enters "<userName>" to username textbox
    And User enters "<password>" to password textbox
    And User clicks LogIn button
    Then Please fill out this field message should be displayed
    Examples:
      | userName   | password    |
      |            | Employee123 |
      | Employee81 |             |
      |            |             |

@SEAMLES-841 @AC3
Scenario: Verify that user can see the password in a form of dots by default
   Given User navigates to Login Page
   When User enters "123456" to password textbox
   Then User should see the password in a form of dots by default

@SEAMLES-842 @AC4
Scenario: Verify that user can see the password explicitly if needed
  Given User navigates to Login Page
  When User enters "123456" to password textbox
  And User clicks eye icon near the password textbox
  Then User should see the password explicitly

  @SEAMLES-843 @AC5
  Scenario: Verify that user can access Reset Password button
    Given User navigates to Login Page
    Then User should see Forgot password link on the page
    And User clicks on the Forgot password link
    Then User should see the Reset password button

  @SEAMLES-844 @AC6
  Scenario: Verify that user can see valid placeholders on Username and Password fields
    Given User navigates to Login Page
    Then User should see Username or email placeholder on the Username field
    And User should see Password placeholder on the Password field