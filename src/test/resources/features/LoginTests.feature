@All @LogInFeatures
Feature: Login tests
  As an end user, I can login to hudl.com

  Background: Home page of hudl.com
    Given The user navigates to the hudl home page
    And The user navigates to the log in page

  @HappyPath @EmailPasswordLogin
  Scenario Outline: Login to hudl.com using valid email and password
    Given Login page is displayed
    When The user enters "<Email>" as their email
    And The user enters "<Password>" as their password
    And Click login continue button
    Then The user is successfully logged in

    Examples:
      | Email                    | Password  |
      | mattjsimpson93@gmail.com | Hudl123!  |
      | MATTJSIMPSON93@GMAIL.COM | Hudl123!  |
      | mattjsimpson93@GMAIL.COM | Hudl123!  |


  @ValidationIncorrectEmailPassword
  Scenario Outline: Login to hudl.com using invalid account email and password combination and validating the error message
    Given Login page is displayed
    When The user enters "<Email>" as their email
    And The user enters "<Password>" as their password
    And Click login continue button
    Then The user is unsuccessful in logging in and the first error message is displayed

    Examples:
      | Email                    | Password |
      | mattjsimpson93@gmail.com | Hudl123  |
      | mattjsimpson93@gmail     | Hudl123  |
      | hkdjtiwkfk               | oy$%kgl  |

  @ValidationMissingEmailOrPassword
  Scenario Outline: Login to hudl.com using either just a email or password and validating the error message
    Given Login page is displayed
    When The user enters "<Email>" as their email
    And The user enters "<Password>" as their password
    And Click login continue button
    Then The user is unsuccessful in logging in and the second error message is displayed

    Examples:
      | Email                    | Password                 |
      | mattjsimpson93@gmail.com |                          |
      |                          | Hudl123                  |
      | jgkti684                 |                          |
      |                          | mattjsimpson93@gmail.com |

  @ForgotPassword
  Scenario: Check the forgot password link works
    Given Login page is displayed
    When The user clicks the forgot password link
    Then The forgot password link opens
#   Did not perform email address submission steps as would have to check email for receipt of password reset as well

  @FacebookLogin
  Scenario: Check the login to hudl.com using Facebook link works
    Given Login page is displayed
    When The user clicks the Facebook login link
    Then The Facebook login link opens
#   Did not perform login step due to having to use personal account details or having to setup new test account

  @GoogleLogin
  Scenario: Check the login to hudl.com using Google link works
    Given Login page is displayed
    When The user clicks the Google login link
    Then The Google login link opens
#   Did not perform login step due to having to use personal account details or having to setup new test account

  @AppleLogin
  Scenario: Check the login to hudl.com using Apple link works
    Given Login page is displayed
    When The user clicks the Apple login link
    Then The Apple login link opens
#   Did not perform login step due to having to use personal account details or having to setup new test account

  @CreateAccount1
  Scenario: Check the create account link at the top of the screen works
    Given Login page is displayed
    When The user clicks the create account link at the top of the screen
    Then The create account link opens
#   Did not perform create account steps as I didn't think this was necessity for the task

  @CreateAccount2
  Scenario: Check the create account link at the bottom of the screen works
    Given Login page is displayed
    When The user clicks the create account link at the bottom of the screen
    Then The create account link opens
#   Did not perform create account steps as I didn't think this was necessity for the task

#  * Commented out code relevant to the commented out Privacy Policy and Site Terms feature.
#  I couldn't get the webdriver to handle testing new tab functionality to work hence commenting out:
  #  @SiteTerms
#  Scenario: Check the site terms link works
#    Given Login page is displayed
#    When The user clicks the site terms link
##    When The user switches to the new tab
#    Then The site terms link opens
#  Attempted this scenario but couldn't get the new tab testing fuctionality to work, unfortunately
#
#  @PrivacyPolicy
#  Scenario: Check the privacy policy link works
#    Given Login page is displayed
#    When The user clicks the privacy policy link
#    Then The privacy policy link opens
#  Attempted this scenario but couldn't get the new tab testing fuctionality to work, unfortunately