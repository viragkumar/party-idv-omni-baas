Feature: EID (Electronic Identification)

  Background: Generate random data

  Scenario Outline: Verify the error message response if title is sent wrong in POST API
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is L4 (EID)
    And POST the personal information of customer where <Title> is wrong
      |FirstName| |LastName| |Birthdate| |PhoneNumber| |premise| |primaryStreet| |town| |postCode||AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    Then response returned is http code 400 Bad request with error message "Incorrect data"
    Examples:
      |Title|
      |     |
      |Null |
      |123  |
      |@£$  |
      |abc  |


  Scenario Outline: Verify the error message response if First Name is sent wrong in POST API
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is L4 (EID)
    And POST the personal information of customer where <FirstName> is wrong
      |Title| |LastName| |Birthdate| |PhoneNumber| |premise| |primaryStreet| |town| |postCode||AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    Then response returned is http code 400 Bad request with error message "Incorrect data"
    Examples:
      |FirstName|
      |         |
      |Null     |
      |123      |
      |@£$      |
      |x        |
      |xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx|


  Scenario Outline: Verify the error message response if Last Name is sent wrong in POST API
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is L4 (EID)
    And POST the personal information of customer where <LastName> is wrong
      |Title| |FirstName| |Birthdate| |PhoneNumber| |premise| |primaryStreet| |town| |postCode||AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    Then response returned is http code 400 Bad request with error message "Incorrect data"
    Examples:
      |LastName|
      |        |
      |Null    |
      |123     |
      |$£@     |
      |x       |
      |xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx|


  Scenario Outline: Verify the error message response if Birth Date is sent wrong in POST API
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is L4 (EID)
    And POST the personal information of customer where <BirthDate> is wrong
      |Title| |FirstName| |LastName| |PhoneNumber| |premise| |primaryStreet| |town| |postCode||AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    Then response returned is http code 400 Bad request with error message "Incorrect data"
    Examples:
      |BirthDate|
      |          |
      |Null      |
      |2023-11-20|
      |1910-01-23|
      |1990-23-02|
      |01-23     |
      |1990-02   |
      |1990-24   |
      |1980-12-12|



  Scenario Outline: Verify the error message response if Phone Number is sent wrong in POST API
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is L4 (EID)
    And POST the personal information of customer where <PhoneNumber> is wrong
      |Title| |FirstName| |LastName| |Birthdate| |premise| |primaryStreet| |town| |postCode||AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    Then response returned is http code 400 Bad request with error message "Incorrect data"
    Examples:
      |PhoneNumber      |
      |0044-190834568534|
      |0044-0000000000  |
      |0112-1908345685  |
      |+44-8932134587   |
      |+44-0732134587658|
      |+44-073213       |


  Scenario Outline: Verify the error message response if Premise is sent wrong in POST API
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is L4 (EID)
    And POST the personal information of customer where <Premise> is wrong
      |Title| |FirstName| |LastName| |Birthdate| |PhoneNumber| |primaryStreet| |town| |postCode||AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    Then response returned is http code 400 Bad request with error message "Incorrect data"
    Examples:
      |Premise|
      |       |
      |Null   |
      |$£@    |
      |xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx|


  Scenario Outline: Verify the error message response if Primary Street is sent wrong in POST API
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is L4 (EID)
    And POST the personal information of customer where <PrimaryStreet> is wrong
      |Title| |FirstName| |LastName| |Birthdate| |PhoneNumber| |premise| |town| |postCode||AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    Then response returned is http code 400 Bad request with error message "Incorrect data"
    Examples:
      |PrimaryStreet|
      |             |
      |Null         |
      |$£@          |
      |1234         |
      |xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx|


  Scenario Outline: Verify the error message response if Town is sent wrong in POST API
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is L4 (EID)
    And POST the personal information of customer where <Town> is wrong
      |Title| |FirstName| |LastName| |Birthdate| |PhoneNumber| |premise| |primaryStreet| |postCode||AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    Then response returned is http code 400 Bad request with error message "Incorrect data"
    Examples:
      |Town      |
      |          |
      |Null      |
      |$£@       |
      |12345     |
      |Milton3456|
      |xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx|


  Scenario Outline: Verify the error message response if Post Code is sent wrong in POST API
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is L4 (EID)
    And POST the personal information of customer where <PostCode> is wrong
      |Title| |FirstName| |LastName| |Birthdate| |PhoneNumber| |premise| |primaryStreet| |town| |AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    Then response returned is http code 400 Bad request with error message "Incorrect data"
    Examples:
      |postCode|
      |       |
      |Null   |
      |$£@    |
      |1234567|


  Scenario Outline: Verify the error message response if Risk level is sent wrong in POST API
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is L4 (EID)
    And POST the personal information of customer where <RiskLevel> is wrong
      |Title| |FirstName| |LastName| |Birthdate| |PhoneNumber| |premise| |primaryStreet| |town| |postCode| |productType| |productSubtype|
    Then response returned is http code 400 Bad request with error message "Incorrect data"
    Examples:
      |RiskLevel|
      |    |
      |Null|
      |$£@ |
      |05  |
      |03  |
      |01  |


  Scenario Outline: Verify the error message response if Product type is sent wrong in POST API
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is L4 (EID)
    And POST the personal information of customer where <productType> is wrong
      |Title| |FirstName| |LastName| |Birthdate| |PhoneNumber| |premise| |primaryStreet| |town| |postCode||AMLRiskLevel (02-Standard)| |productSubtype|
    Then response returned is http code 400 Bad request with error message "Incorrect data"
    Examples:
      |productType|
      |    |
      |Null|
      |$£@ |
      |05ab|
      |0000|


  Scenario Outline: Verify the error message response if Product Subtype is sent wrong in POST API
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is L4 (EID)
    And POST the personal information of customer where <productSubtype> is wrong
      |Title| |FirstName| |LastName| |Birthdate| |PhoneNumber| |premise| |primaryStreet| |town| |postCode||AMLRiskLevel (02-Standard)| |productType|
    Then response returned is http code 400 Bad request with error message "Incorrect data"
    Examples:
      |productSubtype|
      |    |
      |Null|
      |$£@ |
      |05ab|
      |0000|

  Scenario: Verifying the identity of a new customer through EID as PASS with BirthDate transformed to EID format
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is L4 (EID)
    And POST the personal information of customer with BirthDate as "23-12-1980"
      |Title| |FirstName| |LastName| |PhoneNumber| |premise| |primaryStreet|  |town| |postCode||AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    And validate the response of personal information
    And transform the BirthDate in EID compatible format as "1980-12-23"
    And POST EID endpoint with personal info parameters
      |Title| |FirstName| |LastName| |PhoneNumber|
    And address details of customer are sent in request
      |premise| |primaryStreet| |town| |postCode|
    And internal info values are sent in request
      |AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    And response returned is "Approved" and customerCompliantByEid as S with fields returned
      |customerCompliantByEid| |eIdDocumentList| |eIdDocumentType| |eIdUniqueId|
    And verify the check status is updated in ID&V
    Then verify that all the fields of response are stored in I&V DB with GET API


  Scenario: Verifying the identity of a new customer through EID as PASS with Post Code transformed to EID format
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is L4 (EID)
    And POST the personal information of customer with PostCode as "MK52JH"
      |Title| |FirstName| |LastName| |Birthdate| |PhoneNumber| |premise| |primaryStreet|  |town| |AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    And validate the response of personal information
    And transform the PostCode in EID compatible format as "MK5 2JH"
    And POST EID endpoint with personal info parameters
      |Title| |FirstName| |LastName| |PhoneNumber|
    And address details of customer are sent in request
      |premise| |primaryStreet| |secondaryStreet| |town| |postCode|
    And internal info values are sent in request
      |AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    And response returned is "Approved" and customerCompliantByEid as S with fields returned
      |customerCompliantByEid| |eIdDocumentList| |eIdDocumentType| |eIdUniqueId|
    And verify the check status is updated in ID&V
    Then verify that all the fields of response are stored in I&V DB with GET API


  Scenario Outline: Verify the error message response if wrong title is sent to EID
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is L4 (EID)
    And GET the personal information from customer service DB
      |Title| |FirstName| |LastName| |Birthdate| |PhoneNumber| |premise| |primaryStreet|  |town| |postCode||AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    And validate the response of personal information
    And transform the data in EID compatible format
    And POST EID endpoint with personal info parameters with wrong <Title>
      |FirstName| |LastName| |Birthdate| |PhoneNumber|
    And address details of customer are sent in request
      |premise| |primaryStreet| |town| |postCode|
    And internal info values are sent in request
      |AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    Then response returned is http code 400 Bad request with error message "invalid Title"
    Examples:
      |Title|
      |     |
      |Null |
      |123  |
      |@£$  |
      |abc  |


  Scenario Outline: Verify the error message response if wrong FirstName is sent to EID
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is L4 (EID)
    And GET the personal information from customer service DB
      |Title| |FirstName| |LastName| |Birthdate| |PhoneNumber| |premise| |primaryStreet|  |town| |postCode||AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    And validate the response of personal information
    And transform the data in EID compatible format
    And POST EID endpoint with personal info parameters with wrong <FirstName>
      |Title| |LastName| |Birthdate| |PhoneNumber|
    And address details of customer are sent in request
      |premise| |primaryStreet| |town| |postCode|
    And internal info values are sent in request
      |AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    Then response returned is http code 400 Bad request with error message "invalid First Name"
    Examples:
      |FirstName|
      |         |
      |Null     |
      |123      |
      |@£$      |
      |x        |
      |xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx|


  Scenario Outline: Verify the error message response if wrong LastName is sent to EID
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is L4 (EID)
    And GET the personal information from customer service DB
      |Title| |FirstName| |LastName| |Birthdate| |PhoneNumber| |premise| |primaryStreet|  |town| |postCode||AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    And validate the response of personal information
    And transform the data in EID compatible format
    And POST EID endpoint with personal info parameters with wrong <LastName>
      |Title| |FirstName| |Birthdate| |PhoneNumber|
    And address details of customer are sent in request
      |premise| |primaryStreet| |town| |postCode|
    And internal info values are sent in request
      |AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    Then response returned is http code 400 Bad request with error message "invalid Last Name"
    Examples:
      |LastName|
      |        |
      |Null    |
      |123     |
      |$£@     |
      |x       |
      |xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx|


  Scenario Outline: Verify the error message response if wrong BirthDate is ent to EID
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is L4 (EID)
    And GET the personal information from customer service DB
      |Title| |FirstName| |LastName| |Birthdate| |PhoneNumber| |premise| |primaryStreet|  |town| |postCode||AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    And validate the response of personal information
    And transform the data in EID compatible format
    And POST EID endpoint with personal info parameters with wrong <BirthDate>
      |Title| |FirstName|  |LastName| |PhoneNumber|
    And POST EID endpoint with personal info parameters <BirthDate>
    And address details of customer are sent in request
      |premise| |primaryStreet| |town| |postCode|
    And internal info values are sent in request
      |AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    Then response returned is http code 400 Bad request with error message "invalid Birth Date"
    Examples:
      |Birthdate|
      |          |
      |Null      |
      |2023-11-20|
      |1910-01-23|
      |1990-23-02|
      |01-23     |
      |1990-02   |
      |1990-24   |


  Scenario Outline: Verify the error message response if wrong PhoneNumber is sent to EID
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is L4 (EID)
    And GET the personal information from customer service DB
      |Title| |FirstName| |LastName| |Birthdate| |PhoneNumber| |premise| |primaryStreet|  |town| |postCode||AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    And validate the response of personal information
    And transform the data in EID compatible format
    And POST EID endpoint with personal info parameters with wrong <PhoneNumber>
      |Title| |FirstName|  |Birthdate|
    And address details of customer are sent in request
      |premise| |primaryStreet| |town| |postCode|
    And internal info values are sent in request
      |AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    Then response returned is http code 400 Bad request with error message "invalid Phone Number"
    Examples:
      |PhoneNumber      |
      |0044-190834568534|
      |0044-0000000000  |
      |0112-1908345685  |
      |+44-8932134587   |
      |+44-0732134587658|
      |+44-073213       |


  Scenario Outline: Verify the error message response if wrong Premise is sent to EID
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is L4 (EID)
    And GET the personal information from customer service DB
      |Title| |FirstName| |LastName| |Birthdate| |PhoneNumber| |premise| |primaryStreet|  |town| |postCode||AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    And validate the response of personal information
    And transform the data in EID compatible format
    And POST EID endpoint with personal info parameters
      |Title| |FirstName|  |Birthdate| |PhoneNumber|
    And address details of customer are sent in request
      |primaryStreet| |town| |postCode|
    And internal info values are sent in request
      |AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    Then response returned is http code 400 Bad request with error message "invalid Premise"
    Examples:
      |Premise|
      |       |
      |Null   |
      |$£@    |
      |xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx|


  Scenario Outline: Verify the error message response if wrong primaryStreet is sent to EID
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is L4 (EID)
    And GET the personal information from customer service DB
      |Title| |FirstName| |LastName| |Birthdate| |PhoneNumber| |premise| |primaryStreet|  |town| |postCode||AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    And validate the response of personal information
    And transform the data in EID compatible format
    And POST EID endpoint with personal info parameters
      |Title| |FirstName|  |Birthdate| |PhoneNumber|
    And address details of customer are sent in request
      |premise| |town| |postCode|
    And internal info values are sent in request
      |AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    Then response returned is http code 400 Bad request with error message "invalid Primary Street"
    Examples:
      |primaryStreet|
      |             |
      |Null         |
      |$£@          |
      |1234         |
      |xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx|


  Scenario Outline: Verify the error message response if wrong town is sent to EID
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is L4 (EID)
    And GET the personal information from customer service DB
      |Title| |FirstName| |LastName| |Birthdate| |PhoneNumber| |premise| |primaryStreet|  |town| |postCode||AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    And validate the response of personal information
    And transform the data in EID compatible format
    And POST EID endpoint with personal info parameters
      |Title| |FirstName|  |Birthdate| |PhoneNumber|
    And address details of customer are sent in request
      |premise| |primaryStreet| |postCode|
    And internal info values are sent in request
      |AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    Then response returned is http code 400 Bad request with error message "invalid Town"
    Examples:
      |town      |
      |          |
      |Null      |
      |$£@       |
      |12345     |
      |Milton3456|
      |xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx|


  Scenario Outline: Verify the error message response if wrong postCode is sent to EID
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is L4 (EID)
    And GET the personal information from customer service DB
      |Title| |FirstName| |LastName| |Birthdate| |PhoneNumber| |premise| |primaryStreet|  |town| |postCode||AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    And validate the response of personal information
    And transform the data in EID compatible format
    And POST EID endpoint with personal info parameters
      |Title| |FirstName|  |Birthdate| |PhoneNumber|
    And address details of customer are sent in request
      |premise| |primaryStreet| |town|
    And internal info values are sent in request
      |AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    Then response returned is http code 400 Bad request with error message "invalid PostCode"
    Examples:
      |postCode|
      |       |
      |Null   |
      |$£@    |
      |1234567|
      |MK52FE |


  Scenario Outline: Verify the error message response if wrong riskLevel is sent to EID
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is L4 (EID)
    And GET the personal information from customer service DB
      |Title| |FirstName| |LastName| |Birthdate| |PhoneNumber| |premise| |primaryStreet|  |town| |postCode||AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    And validate the response of personal information
    And transform the data in EID compatible format
    And POST EID endpoint with personal info parameters
      |Title| |FirstName|  |Birthdate| |PhoneNumber|
    And address details of customer are sent in request
      |premise| |primaryStreet| |town| |postCode|
    And internal info values are sent in request
      |productType| |productSubtype|
    Then response returned is http code 400 Bad request with error message "invalid Risk Level"
    Examples:
      |riskLevel|
      |    |
      |Null|
      |$£@ |
      |05  |
      |03  |
      |01  |


  Scenario Outline: Verify the error message response if wrong productType is sent to EID
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is L4 (EID)
    And GET the personal information from customer service DB
      |Title| |FirstName| |LastName| |Birthdate| |PhoneNumber| |premise| |primaryStreet|  |town| |postCode||AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    And validate the response of personal information
    And transform the data in EID compatible format
    And POST EID endpoint with personal info parameters
      |Title| |FirstName|  |Birthdate| |PhoneNumber|
    And address details of customer are sent in request
      |premise| |primaryStreet| |town| |postCode|
    And internal info values are sent in request
      |AMLRiskLevel (02-Standard)| |productSubtype|
    Then response returned is http code 400 Bad request with error message "invalid Product Type"
    Examples:
      |productType|
      |    |
      |Null|
      |$£@ |
      |05ab|
      |0000|



  Scenario Outline: Verify the error message response if wrong productSubtype is sent to EID
    Given a customer has registered and customer id is created
    And check if customer id exists in ID&V DB
    And check the status of customer is "NOT_VERIFIED"
    When check_id is L4 (EID)
    And GET the personal information from customer service DB
      |Title| |FirstName| |LastName| |Birthdate| |PhoneNumber| |premise| |primaryStreet|  |town| |postCode||AMLRiskLevel (02-Standard)| |productType| |productSubtype|
    And validate the response of personal information
    And transform the data in EID compatible format
    And POST EID endpoint with personal info parameters
      |Title| |FirstName|  |Birthdate| |PhoneNumber|
    And address details of customer are sent in request
      |premise| |primaryStreet| |town| |postCode|
    And internal info values are sent in request
      |AMLRiskLevel (02-Standard)| |productType|
    Then response returned is http code 400 Bad request with error message "invalid Product SubType"
    Examples:
      |productSubtype|
      |    |
      |Null|
      |$£@ |
      |05ab|
      |0000|


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


