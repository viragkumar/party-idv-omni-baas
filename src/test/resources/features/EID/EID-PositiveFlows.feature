Feature: EID (Electronic Identification)

  Background: Generate random data

  Scenario: Verifying the identity of a new customer through EID as PASS
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is L4 (EID)
    And POST the personal information of customer with API
      |Title| |FirstName| |LastName| |Birthdate| |PhoneNumber| |premise| |primaryStreet| |primaryDistrict| |town| |postCode||AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    And validate the response of personal information
    And transform the data in EID compatible format
    And POST EID endpoint with personal info parameters
      |Title| |FirstName| |LastName| |Birthdate| |PhoneNumber|
    And address details of customer are sent in request
      |premise| |primaryStreet| |primaryDistrict| |town| |postCode|
    And internal info values are sent in request
      |AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    And response returned is "Approved" and customerCompliantByEid as S with fields returned
      |customerCompliantByEid| |eIdDocumentList| |eIdDocumentType| |eIdUniqueId|
    And verify the check status is updated in ID&V
    Then verify that all the fields of response are stored in I&V DB with GET API



  Scenario: Verifying the identity of a new customer through EID as FAIL
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is L4 (EID)
    And POST the personal information of customer with API
      |Title| |FirstName| |LastName| |Birthdate| |PhoneNumber| |premise| |primaryStreet| |primaryDistrict| |town| |postCode||AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    And validate the response of personal information
    And transform the data in EID compatible format
    And POST EID endpoint with personal info parameters
      |Title| |FirstName| |LastName| |Birthdate| |PhoneNumber|
    And address details of customer are sent in request
      |premise| |primaryStreet| |primaryDistrict| |town| |postCode|
    And internal info values are sent in request
      |AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    Then response returned is "FAIL" customerCompliantByEid as "N" with fields returned
      |customerCompliantByEid| |eIdDocumentList|
    Then verify that all the fields of response are stored in DB with GET API