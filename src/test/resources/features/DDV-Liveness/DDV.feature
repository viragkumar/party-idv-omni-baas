Feature: DDV and Liveness

  Background:
    Given generate dynamic profile for a new customer

  Scenario: Verifying the identity of a new customer through DDV check with Passport
    Given a customer is already onboarded
    When check_id is ID&V (L5)
    And Get the list of all valid documents for ID&V check
      | PASSPORT |  | DRIVING LICENSE |  | PROVISIONAL DRIVING LICENSE |
    When customer POST with Passport
    Then get the session id in response
    When customer POST the session id and parameter dataMatch=True
    And get the response "session completed"
    Then verify DDV status from ID&V DB with GET status API


  Scenario: Verifying the identity of a new customer through ID&V check with Driving License
    Given a customer is already onboarded
    When check_id is ID&V (L5)
    And Get the list of all valid documents for ID&V check
      | PASSPORT |  | DRIVING LICENSE |  | PROVISIONAL DRIVING LICENSE |
    When customer POST with Driving License
    Then get the session id in response
    When customer POST the session id and parameter dataMatch=True
    And get the reponse "session completed"
    Then verify ID&V status from DB with GET status API


  Scenario: Verifying the identity of a new customer through ID&V check with PROVISIONAL DRIVING LICENSE
    Given a customer is already onboarded
    When check_id is ID&V (L5)
    And Get the list of all valid documents for ID&V check
      | PASSPORT |  | DRIVING LICENSE |  | PROVISIONAL DRIVING LICENSE |
    When customer POST with Provisional driving license
    Then get the session id in response
    When customer POST the session id and parameter dataMatch=True
    And get the reponse "session completed"
    Then verify ID&V status from DB with GET status API

####Negative Scenario
  Scenario: Validate the ID&V response with invalid document as BRP card
    Given a customer is already onboarded
    When check_id is ID&V (L5)
    And Get the list of all valid documents for ID&V check
      | PASSPORT |  | DRIVING LICENSE |  | PROVISIONAL DRIVING LICENSE |
    When customer POST with BRP card
    Then response returned is http code 400 Bad request with error message "Invalid document"

    # What if user uploads a invalid doc
