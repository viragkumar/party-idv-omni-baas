Feature: EID (Electronic Identification)

  Background: Generate random data

  Scenario: Verifying the identity of a new customer through EID as PASS
    Given a customer is already onboarded
    And check the status of customer is "Not Verified"
    When check_id is EID (L4)
    And POST EID endpoint with personal info parameters
      | Title |  | FirstName |  | MiddleName |  | LastName |  | Birthdate |  | PhoneNumber |
    And address details of customer are sent in request
      | premise |  | alternativePremise |  | primaryStreet |  | primaryDistrict |  | secondaryStreet |  | secondaryDistrict |  | town |  | postCode |
    And internal info values are sent in request
      | AMLRiskLevel (02-Standard) |  | customerId |  | interventionType |  | productType |  | productSubtype |  | advisor |
    Then response returned is "Approved" and customerCompliantByEid as S with fields returned //Need more clarification for output
      | customerCompliantByEid |  | eIdDocumentList |  | eIdDocumentType |  | eIdUniqueId |
    And verify the status response with GET API  //Need to get more info (Pending)


  Scenario: Verifying the identity of a new customer through EID as FAIL
    Given a customer is already onboarded
    And check the status of customer is "Not Verified"
    When check_id is EID (L4)
    And POST EID endpoint with personal info parameters
      | Title |  | FirstName |  | MiddleName |  | LastName |  | Birthdate |  | PhoneNumber |
    And address details of customer are sent in request
      | premise |  | alternativePremise |  | primaryStreet |  | primaryDistrict |  | secondaryStreet |  | secondaryDistrict |  | town |  | postCode |
    And internal info values are sent in request
      | AMLRiskLevel (02-Standard) |  | customerId |  | interventionType |  | productType |  | productSubtype |  | advisor |
    Then response returned is "FAIL" customerCompliantByEid as "N" with fields returned //Need more clarification for output
      | customerCompliantByEid |  | eIdDocumentList |
    And verify the status response with GET API  //Need to get more info (Pending)
