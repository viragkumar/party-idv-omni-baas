Feature: DDV and Liveness

  Scenario: Verifying the identity of a new customer through DDV check with Passport and Selfie
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is ID&V (L5)
    And Get the list of all valid documents for ID&V check
      | 66 |  | 76 |
    And transform the "66" option from ID&V DB to DDV format  "Passport and Selfie"
    And POST Start ID&V session with sending parameters documentType as Passport and include Liveness as True
    And session_id is created and returned in response
    And POST complete ID&V session with dataMatch=True
    And verify the DDV status is "Verified successful"
    Then verify the the check_id status is updated in ID&V DB


  Scenario: Verifying the identity of a new customer through ID&V check with Driving License
    Given a customer is already onboarded
    When check_id is ID&V (L5)
    And Get the list of all valid documents for ID&V check
      | PASSPORT |  | DRIVING LICENSE |
    When customer POST with Driving License
    Then get the session id in response
    When customer POST the session id and parameter dataMatch=True
    And get the reponse "session completed"
    Then verify ID&V status from DB with GET status API


  Scenario: Verifying the identity of a new customer through ID&V check with PROVISIONAL DRIVING LICENSE
    Given a customer is already onboarded
    When check_id is ID&V (L5)
    And Get the list of all valid documents for ID&V check
      | PASSPORT |  | DRIVING LICENSE |
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
      | PASSPORT |  | DRIVING LICENSE |
    When customer POST with BRP card
    Then response returned is http code 400 Bad request with error message "Invalid document"

    # What if user uploads a invalid doc
