Feature: DDV and Liveness

  Scenario: Verifying the identity of a new customer through DDV check with Passport and Liveness as true
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is ID&V (L5)
    And Get the list of all valid documents through DOC control API from ID&V database
      |66| |76 | |83|
    And transform the "66" option from ID&V DB to DDV format  "Passport and Selfie"
    And POST Start ID&V session with parameters documentType as Passport and include documents scan and impersonation as True
    And session_id is created and returned in response
    And POST complete ID&V session with dataMatch=True
    And verify the DDV status is "Verified successful"
    Then verify the the check_id status is updated in ID&V DB


  Scenario: Verifying the identity of a new customer through DDV check with document scan as true and impersonation as false
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is ID&V (L5)
    And Get the list of all valid documents through DOC control API from ID&V database
      |66| |76 | |83| |86|
    And transform the "86" option from ID&V DB to DDV format  "Passport"
    And POST Start ID&V session with parameters documentType as Passport and include documents scan True and impersonation as False
    And session_id is created and returned in response
    And POST complete ID&V session with dataMatch=True
    And verify the DDV status is "Verified successful"
    Then verify the the check_id status is updated in ID&V DB
  #Verify the journey for different scenario with Jose


  Scenario: Verifying the identity of a new customer through DDV check with document scan as False and impersonation as True
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is ID&V (L5)
    And Get the list of all valid documents through DOC control API from ID&V database
      |66| |76 | |83| |86|
    And transform the "86" option from ID&V DB to DDV format  "Selfie"
    And POST Start ID&V session with parameters documentType as Passport and include documents scan False and impersonation as True
    And session_id is created and returned in response
    And POST complete ID&V session with dataMatch=True
    And verify the DDV status is "Verified successful"
    Then verify the the check_id status is updated in ID&V DB


  Scenario: Verifying the identity of a new customer through DDV check with Driving Licence and Liveness as true
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is ID&V (L5)
    And Get the list of all valid documents through DOC control API from ID&V database
      |66| |76 | |83|
    And transform the "76" option from ID&V DB to DDV format  "Licence and Selfie"
    And POST Start ID&V session with parameters documentType as Licence and include documents scan and impersonation as True
    And session_id is created and returned in response
    And POST complete ID&V session with dataMatch=True
    And verify the DDV status is "Verified successful"
    Then verify the the check_id status is updated in ID&V DB


  Scenario: Verifying the identity of a new customer through DDV check with Driving Licence document scan True and Liveness as False
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is ID&V (L5)
    And Get the list of all valid documents through DOC control API from ID&V database
      |66| |76 | |83|
    And transform the "76" option from ID&V DB to DDV format  "Driving Licence"
    And POST Start ID&V session with parameters documentType as Driving Licence and include documents scan True and impersonation as Flase
    And session_id is created and returned in response
    And POST complete ID&V session with dataMatch=True
    And verify the DDV status is "Verified successful"
    Then verify the the check_id status is updated in ID&V DB


  Scenario: Verifying the identity of a new customer through DDV check with Driving Licence document scan False and Liveness as true
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is ID&V (L5)
    And Get the list of all valid documents through DOC control API from ID&V database
      |66| |76 | |83|
    And transform the "76" option from ID&V DB to DDV format  "Selfie"
    And POST Start ID&V session with parameters documentType as Driving Licence and include documents scan False and impersonation as True
    And session_id is created and returned in response
    And POST complete ID&V session with dataMatch=True
    And verify the DDV status is "Verified successful"
    Then verify the the check_id status is updated in ID&V DB


  Scenario: Verifying the identity of a new customer through DDV check with Provisional Driving Licence and Liveness as true
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is ID&V (L5)
    And Get the list of all valid documents through DOC control API from ID&V database
      |66| |76 | |83|
    And transform the "76" option from ID&V DB to DDV format  "Provisional Driving Licence and Selfie"
    And POST Start ID&V session with parameters documentType as Provisional Driving Licence and include documents scan and impersonation as True
    And session_id is created and returned in response
    And POST complete ID&V session with dataMatch=True
    And verify the DDV status is "Verified successful"
    Then verify the the check_id status is updated in ID&V DB


  Scenario: Verifying the identity of a new customer through DDV check with Provisional Driving Licence document scan True and Liveness as False
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is ID&V (L5)
    And Get the list of all valid documents through DOC control API from ID&V database
      |66| |76 | |83|
    And transform the "76" option from ID&V DB to DDV format  "Provisional Driving Licence"
    And POST Start ID&V session with parameters documentType as Provisional Driving Licence and include documents scan True and impersonation as Flase
    And session_id is created and returned in response
    And POST complete ID&V session with dataMatch=True
    And verify the DDV status is "Verified successful"
    Then verify the the check_id status is updated in ID&V DB


  Scenario: Verifying the identity of a new customer through DDV check with Provisional Driving Licence document scan False and Liveness as true
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is ID&V (L5)
    And Get the list of all valid documents through DOC control API from ID&V database
      |66| |76 | |83|
    And transform the "76" option from ID&V DB to DDV format  "Selfie"
    And POST Start ID&V session with parameters documentType as Provisional Driving Licence and include documents scan False and impersonation as True
    And session_id is created and returned in response
    And POST complete ID&V session with dataMatch=True
    And verify the DDV status is "Verified successful"
    Then verify the the check_id status is updated in ID&V DB

#Manual scripts
  Scenario: Verifying the identity of a new customer through DDV and GBG logs
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is ID&V (L5)
    And Get the list of all valid documents from ID&V databse
      |66| |76 | |83|
    And transform the "66" option from ID&V DB to DDV format  "Passport and Selfie"
    And POST Start ID&V session with parameters documentType as Passport and include documents scan and impersonation as True
    And session_id is created and returned in response
    And POST complete ID&V session with dataMatch=True
    And verify the DDV status is "Verified successful"
    And verify the the check_id status is updated in ID&V DB
    Then verify that NFC and OCR and liveness are correctly processed through DDV and GBG logs
