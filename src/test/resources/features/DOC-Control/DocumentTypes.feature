Feature: Party ID&V OMNI BaaS

  Scenario: Retrieve the document list for the first time onboarding customer for ID check (L1)
    Given user is onboarding first time on PCA
    And GET the status of customer
    Then status is returned as 01(new)
    And he goes through identity check (L1)
    And GET IdCheck_DocList API gets hit
    Then the list of documents is returned for user to upload
      | PASSPORT - UK/IRISH (UNEXPIRED) |  | UK PHOTO DRIVING LICENCE(UNEXPIRED) |  | BIOMETRIC RESIDENCE PERMIT (UNEXPIRED) |  | PASSPORT - NON UK/NON-IRISH AND RIGHT TO RMN IN UK |  | EEA OR SWISS NATIONAL IDENTITY CARD (UNEXPIRED) |  | PRKING CRD FOR DISABLED PEOPLE (BLUE BADGE) (UNEX) |


  Scenario: Retrieve the document list with status in progress onboarding customer for residency check (L2)
    Given user is coming second time on PCA
    And GET the status of customer
    Then status is returned as 02(in progress) and document used in ID check (L1)
    And he goes through residency check (L2)
    And GET residency_Check_DocList API gets hit
    Then the list of documents is returned for user to upload
      | UK PHOTO DRIVING LICENCE(UNEXPIRED) |  | BANK STATEMENT - NOT BRANCH PRINTED (<3MTH) |  | Mortgage statement from recognised lender |  | Utility Bill (not mobile phone) |


  Scenario: Retrieve the document list for in progress onboarding customer for residency check when driving Licence is used in ID check
    Given user is coming second time on PCA
    And GET the status of customer
    Then status is returned as 02(in progress) and document used in ID check (L1)
    And he has used UK Driving Licence for ID check (L1)
    And he goes through residency check (L2)
    And GET residency_Check_DocList API gets hit
    Then the list of documents is returned for user to upload without UK Driving Licence
      | BANK STATEMENT - NOT BRANCH PRINTED (<3MTH) |  | Mortgage statement from recognised lender |  | Utility Bill (not mobile phone) |


  Scenario: Validate GET rightToRemain API output when customer's "right to remain" is already completed with L1 document "PASSPORT - UK/IRISH (UNEXPIRED)"
    Given user is onboarding first time on PCA
    And GET the status of customer
    Then status is returned as 01(new) and no list of document
    And he goes through identity check (L1)
    And POST idCheck_docUpload API with "PASSPORT - UK/IRISH (UNEXPIRED)"
    When user hits GET rightToRemain_Doc API
    Then message "Right to remain is already completed for the customer" should be returned


  Scenario: Retrieve the onboarding customer document list  for right to remain check(L3) with idCheck document as "PASSPORT - NON UK/NON-IRISH AND RIGHT TO RMN IN UK" and residency check document as "UK PHOTO DRIVING LICENCE(UNEXPIRED)"
    Given user is coming first time on PCA
    And GET the status of customer
    Then status is returned as 01(new)
    And he goes through ID check (L1) with "PASSPORT - NON UK/NON-IRISH AND RIGHT TO RMN IN UK"
    And he goes through residency check (L2) with "UK PHOTO DRIVING LICENCE(UNEXPIRED)"
    And GET rightToRemain_DocList API gets hit
    Then the list of documents is returned for user to upload
      | BIOMETRIC RESIDENCE PERMIT (UNEXPIRED) |  | Visa |  | Settled and Pre-settled status |


  Scenario: Retrieve the onboarding customer document list  for right to remain check(L3) with idCheck document as "PASSPORT - NON UK/NON-IRISH AND RIGHT TO RMN IN UK" and residency check document as "BANK STATEMENT - NOT BRANCH PRINTED (<3MTH)"
    Given user is coming first time on PCA
    And GET the status of customer
    Then status is returned as 01(new)
    And he goes through ID check (L1) with "PASSPORT - NON UK/NON-IRISH AND RIGHT TO RMN IN UK"
    And he goes through residency check (L2) with "BANK STATEMENT - NOT BRANCH PRINTED (<3MTH)"
    And GET rightToRemain_DocList API gets hit
    Then the list of documents is returned for user to upload
      | BIOMETRIC RESIDENCE PERMIT (UNEXPIRED) |  | Visa |  | Settled and Pre-settled status |


  Scenario: Retrieve the onboarding customer document list  for right to remain check(L3) with idCheck document as "PASSPORT - NON UK/NON-IRISH AND RIGHT TO RMN IN UK" and residency check document as "Mortgage statement from recognised lender"
    Given user is coming first time on PCA
    And GET the status of customer
    Then status is returned as 01(new)
    And he goes through ID check (L1) with "PASSPORT - NON UK/NON-IRISH AND RIGHT TO RMN IN UK"
    And he goes through residency check (L2) with "Mortgage statement from recognised lender"
    And GET rightToRemain_DocList API gets hit
    Then the list of documents is returned for user to upload
      | BIOMETRIC RESIDENCE PERMIT (UNEXPIRED) |  | Visa |  | Settled and Pre-settled status |


  Scenario: Retrieve the onboarding customer document list  for right to remain check(L3) with idCheck document as "PASSPORT - NON UK/NON-IRISH AND RIGHT TO RMN IN UK" and residency check document as "Utility Bill (not mobile phone)"
    Given user is coming first time on PCA
    And GET the status of customer
    Then status is returned as 01(new)
    And he goes through ID check (L1) with "PASSPORT - NON UK/NON-IRISH AND RIGHT TO RMN IN UK"
    And he goes through residency check (L2) with "Utility Bill (not mobile phone)"
    And GET rightToRemain_DocList API gets hit
    Then the list of documents is returned for user to upload
      | BIOMETRIC RESIDENCE PERMIT (UNEXPIRED) |  | Visa |  | Settled and Pre-settled status |


  Scenario: Validate GET rightToRemain API output when customer's "right to remain" is already completed with L1 document "BIOMETRIC RESIDENCE PERMIT (UNEXPIRED)"
    Given user is onboarding first time on PCA
    And GET the status of customer
    Then status is returned as 01(new) and no list of document
    And he goes through identity check (L1)
    And POST idCheck_docUpload API with "BIOMETRIC RESIDENCE PERMIT (UNEXPIRED)"
    When user hits GET rightToRemain_Doc API
    Then message "Right to remain is already completed for the customer" should be returned


  Scenario: Validate GET rightToRemain API output when customer's "right to remain" is already completed with L1 document "UK PHOTO DRIVING LICENCE(UNEXPIRED)"
    Given user is onboarding first time on PCA
    And GET the status of customer
    Then status is returned as 01(new) and no list of document
    And he goes through identity check (L1)
    And POST idCheck_docUpload API with "UK PHOTO DRIVING LICENCE(UNEXPIRED)"
    When user hits GET rightToRemain_Doc API
    Then message "Right to remain is already completed for the customer" should be returned


  Scenario: Retrieve the onboarding customer document list  for right to remain check(L3) with idCheck document as "PRKING CRD FOR DISABLED PEOPLE (BLUE BADGE) (UNEX)"
    Given user is coming first time on PCA
    And GET the status of customer
    Then status is returned as 01(new)
    And he goes through ID check (L1) with "PRKING CRD FOR DISABLED PEOPLE (BLUE BADGE) (UNEX)"
    And he goes through residency check (L2) with following documents
      | UK PHOTO DRIVING LICENCE(UNEXPIRED) |  | BANK STATEMENT - NOT BRANCH PRINTED (<3MTH) |  | Mortgage statement from recognised lender |  | Utility Bill (not mobile phone) |
    And GET rightToRemain_DocList API gets hit
    Then the list of documents is returned for user to upload
      | BIOMETRIC RESIDENCE PERMIT (UNEXPIRED) |  | Visa |  | Settled and Pre-settled status |


  Scenario: Retrieve the onboarding customer document list  for right to remain check(L3) with idCheck document as "PASSPORT - NON UK/NON-IRISH AND RIGHT TO RMN IN UK"
    Given user is coming first time on PCA
    And GET the status of customer
    Then status is returned as 01(new)
    And he goes through ID check (L1) with "PASSPORT - NON UK/NON-IRISH AND RIGHT TO RMN IN UK"
    And he goes through residency check (L2) with following documents
      | UK PHOTO DRIVING LICENCE(UNEXPIRED) |  | BANK STATEMENT - NOT BRANCH PRINTED (<3MTH) |  | Mortgage statement from recognised lender |  | Utility Bill (not mobile phone) |
    And GET rightToRemain_DocList API gets hit
    Then the list of documents is returned for user to upload
      | BIOMETRIC RESIDENCE PERMIT (UNEXPIRED) |  | Visa |  | Settled and Pre-settled status |


  Scenario: Retrieve the onboarding customer document list  for right to remain check(L3) with idCheck document as "EEA OR SWISS NATIONAL IDENTITY CARD (UNEXPIRED)"
    Given user is coming first time on PCA
    And GET the status of customer
    Then status is returned as 01(new)
    And he goes through ID check (L1) with "EEA OR SWISS NATIONAL IDENTITY CARD (UNEXPIRED)"
    And he goes through residency check (L2) with following documents
      | UK PHOTO DRIVING LICENCE(UNEXPIRED) |  | BANK STATEMENT - NOT BRANCH PRINTED (<3MTH) |  | Mortgage statement from recognised lender |  | Utility Bill (not mobile phone) |
    And GET rightToRemain_DocList API gets hit
    Then the list of documents is returned for user to upload
      | BIOMETRIC RESIDENCE PERMIT (UNEXPIRED) |  | Visa |  | Settled and Pre-settled status |


  Scenario: Validating the message for customer completed the checks
    Given user is coming second time on PCA
    And GET the status of customer
    And status is returned as 03(Done) and documents used in ID check,residency check,right to remain check
    And GET IdCheck_DocList API gets hit
    Then message "Customer already verified" should be returned
