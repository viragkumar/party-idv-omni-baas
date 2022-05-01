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


  ///// Negative scenarios ////////

  Scenario Outline: Verify the error message response if title is wrong
    Given a customer is already onboarded
    And check the status of customer is "Not Verified"
    When check_id is EID (L4)
    And POST EID endpoint with personal info parameters <Title>
    And address details of customer are sent in request
      | premise |  | alternativePremise |  | primaryStreet |  | primaryDistrict |  | secondaryStreet |  | secondaryDistrict |  | town |  | postCode |
    And internal info values are sent in request
      | AMLRiskLevel (02-Standard) |  | customerId |  | interventionType |  | productType |  | productSubtype |  | advisor |
    Then response returned is http code 400 Bad request with error message // Pending error message

  Example:
  |Title|
  |     |
  |Null |
  |123  |
  |@£$  |
  |abc  |


  Scenario Outline: Verify the error message response if FirstName is wrong
    Given a customer is already onboarded
    And check the status of customer is "Not Verified"
    When check_id is EID (L4)
    And POST EID endpoint with personal info parameters <FirstName>
    And address details of customer are sent in request
      | premise |  | alternativePremise |  | primaryStreet |  | primaryDistrict |  | secondaryStreet |  | secondaryDistrict |  | town |  | postCode |
    And internal info values are sent in request
      | AMLRiskLevel (02-Standard) |  | customerId |  | interventionType |  | productType |  | productSubtype |  | advisor |
    Then response returned is http code 400 Bad request with error message // Pending error message

  Example:
  |FirstName|
  |         |
  | Null    |
  |123      |
  |@£$      |
  |x        |
  |xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx|


  Scenario Outline: Verify the error message response if LastName is wrong
    Given a customer is already onboarded
    And check the status of customer is "Not Verified"
    When check_id is EID (L4)
    And POST EID endpoint with personal info parameters <LastName>
    And address details of customer are sent in request
      | premise |  | alternativePremise |  | primaryStreet |  | primaryDistrict |  | secondaryStreet |  | secondaryDistrict |  | town |  | postCode |
    And internal info values are sent in request
      | AMLRiskLevel (02-Standard) |  | customerId |  | interventionType |  | productType |  | productSubtype |  | advisor |
    Then response returned is http code 400 Bad request with error message // Pending error message

  Example:
  |LastName|
  |  |
  |Null|
  |123|
  |$£@|
  |x        |
  |xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx|


  Scenario Outline: Verify the error message response if BirthDate is wrong
    Given a customer is already onboarded
    And check the status of customer is "Not Verified"
    When check_id is EID (L4)
    And POST EID endpoint with personal info parameters <BirthDate>
    And address details of customer are sent in request
      | premise |  | alternativePremise |  | primaryStreet |  | primaryDistrict |  | secondaryStreet |  | secondaryDistrict |  | town |  | postCode |
    And internal info values are sent in request
      | AMLRiskLevel (02-Standard) |  | customerId |  | interventionType |  | productType |  | productSubtype |  | advisor |
    Then response returned is http code 400 Bad request with error message // Pending error message

  Example:
  |Birthdate| |PhoneNumber|
  |  |
  |Null|
  |2023-11-20|
  |1910-01-23|
  |1990-23-02|
  |01-23|
  |1990-02|
  |1990-24|


  Scenario Outline: Verify the error message response if PhoneNumber is wrong
    Given a customer is already onboarded
    And check the status of customer is "Not Verified"
    When check_id is EID (L4)
    And POST EID endpoint with personal info parameters <PhoneNumber>
    And address details of customer are sent in request
      | premise |  | alternativePremise |  | primaryStreet |  | primaryDistrict |  | secondaryStreet |  | secondaryDistrict |  | town |  | postCode |
    And internal info values are sent in request
      | AMLRiskLevel (02-Standard) |  | customerId |  | interventionType |  | productType |  | productSubtype |  | advisor |
    Then response returned is http code 400 Bad request with error message // Pending error message

  Example:
  |PhoneNumber|
  |0044-190834568534|
  |0044-0000000000|
  |0112-1908345685|
  |+44-8932134587|
  |+44-0732134587658|
  |+44-073213|
  //Info needed for UK/Non-UK numbers


  Scenario Outline: Verify the error message response if Premise is wrong
    Given a customer is already onboarded
    And check the status of customer is "Not Verified"
    When check_id is EID (L4)
    And POST EID endpoint with personal info parameters
    And address details of customer are sent in request with parameters <premise>
      | alternativePremise |  | primaryStreet |  | primaryDistrict |  | secondaryStreet |  | secondaryDistrict |  | town |  | postCode |
    And internal info values are sent in request
      | AMLRiskLevel (02-Standard) |  | customerId |  | interventionType |  | productType |  | productSubtype |  | advisor |
    Then response returned is http code 400 Bad request with error message // Pending error message

  Example:
  |Premise|
  |    |
  |Null|
  |$£@ |
  |xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx|


  Scenario Outline: Verify the error message response if primaryStreet is wrong
    Given a customer is already onboarded
    And check the status of customer is "Not Verified"
    When check_id is EID (L4)
    And POST EID endpoint with personal info parameters
    And address details of customer are sent in request with parameters <primaryStreet>
      | premise |  | alternativePremise |  | primaryDistrict |  | secondaryStreet |  | secondaryDistrict |  | town |  | postCode |
    And internal info values are sent in request
      | AMLRiskLevel (02-Standard) |  | customerId |  | interventionType |  | productType |  | productSubtype |  | advisor |
    Then response returned is http code 400 Bad request with error message // Pending error message

  Example:
  |primaryStreet|
  |    |
  |Null|
  |$£@ |
  |1234|
  |xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx|


  Scenario Outline: Verify the error message response if town is wrong
    Given a customer is already onboarded
    And check the status of customer is "Not Verified"
    When check_id is EID (L4)
    And POST EID endpoint with personal info parameters
    And address details of customer are sent in request with parameters <town>
      | premise |  | alternativePremise |  | primaryStreet |  | primaryDistrict |  | secondaryStreet |  | secondaryDistrict |  | postCode |
    And internal info values are sent in request
      | AMLRiskLevel (02-Standard) |  | customerId |  | interventionType |  | productType |  | productSubtype |  | advisor |
    Then response returned is http code 400 Bad request with error message // Pending error message

  Example:
  |town|
  |    |
  |Null|
  |$£@ |
  |12345 |
  |Milton3456|
  |xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx|
  //Charcter limit of field

  Scenario Outline: Verify the error message response if postCode is wrong
    Given a customer is already onboarded
    And check the status of customer is "Not Verified"
    When check_id is EID (L4)
    And POST EID endpoint with personal info parameters
    And address details of customer are sent in request with parameters <postCode>
      | premise |  | alternativePremise |  | primaryStreet |  | primaryDistrict |  | secondaryStreet |  | secondaryDistrict |  | town |
    And internal info values are sent in request
      | AMLRiskLevel (02-Standard) |  | customerId |  | interventionType |  | productType |  | productSubtype |  | advisor |
    Then response returned is http code 400 Bad request with error message // Pending error message

  Example:
  |postCode|
  |    |
  |Null|
  |$£@ |
  |1234567|
  |MK52FE|
  //More info for UK/Non-UK address


  Scenario Outline: Verify the error message response if riskLevel is wrong
    Given a customer is already onboarded
    And check the status of customer is "Not Verified"
    When check_id is EID (L4)
    And POST EID endpoint with personal info parameters
    And address details of customer are sent in request with parameters <riskLevel>
      | premise |  | alternativePremise |  | primaryStreet |  | primaryDistrict |  | secondaryStreet |  | secondaryDistrict |  | town |  | postCode |
    And internal info values are sent in request
      | customerId |  | interventionType |  | productType |  | productSubtype |  | advisor |
    Then response returned is http code 400 Bad request with error message // Pending error message

  Example:
  |postCode|
  |    |
  |Null|
  |$£@ |
  |05  |
  |03  |
  |01  |


  Scenario: Call EID endpoint with valid token
    Given Call EID endpoint with valid session token
    Then 201 http code is returned with message "Success"


  Scenario: Call EID endpoint without session token
    Given Call EID endpoint without session token
    Then 401 http code is returned with message "Authentication failed"


  Scenario: Call EID endpoint with invalid session token
    Given Call EID endpoint with invalid session token
    Then 401 http code is returned with message "Authentication failed"

  Scenario: Call EID endpoint with expired session token
    Given Call EID endpoint with expired session token
    Then 401 http code is returned with message "Authentication failed"


  Scenario: Call EID endpoint with not accepted method
    Given Call EID endpoint with not allowed method
    Then 405 http code is returned with message "Method not allowed"


  Scenario: EID endpoint validation with wrong URL
    Given Call EID endpoint with wrong URL
    Then 404 http code is returned with message "Resource code does not exist"

  Scenario: Call EID endpoint with different user token
    Given Call EID endpoint with token from different user
    Then 403 http code is returned with message "Forbidden"
