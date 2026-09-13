```robot
*** Settings ***
Library    SeleniumLibrary

*** Variables ***
${URL}        http://sampleapp.tricentis.com
${BROWSER}    chrome
${TIMEOUT}    10s

*** Test Cases ***
Test Automobile Insurance
    Open Browser    ${URL}    ${BROWSER}
    Maximize Browser Window

    Go To Automobile
    Enter Vehicle Details
    Enter Customer Details
    Enter Policy Details
    Select Coverage
    Complete Quote

    [Teardown]    Close Browser


*** Keywords ***
Go To Automobile
    Wait Until Element Is Visible    id=nav_automobile    ${TIMEOUT}
    Click Element    id=nav_automobile
    Wait Until Element Is Visible    id=make    ${TIMEOUT}

Enter Vehicle Details
    Select From List By Label    id=make    BMW
    Input Text    id=engineperformance    110
    Input Text    id=dateofmanufacture    09/09/2020
    Select From List By Label    id=numberofseats    5
    Select From List By Label    id=fuel    Electric Power
    Input Text    id=listprice    30000
    Input Text    id=licenseplatenumber    CKK1234
    Input Text    id=annualmileage    10000

    Wait Until Element Is Visible    id=nextenterinsurantdata    ${TIMEOUT}
    Click Button    id=nextenterinsurantdata

Enter Customer Details
    Wait Until Element Is Visible    id=firstname    ${TIMEOUT}
    Input Text    id=firstname    Wichai
    Input Text    id=lastname    Sandee
    Input Text    id=birthdate    01/31/1990

    Click Element    xpath=//input[@id="gendermale"]/parent::label

    Input Text    id=streetaddress    KKU
    Select From List By Label    id=country    Thailand
    Input Text    id=zipcode    40002
    Input Text    id=city    Khon Kaen
    Select From List By Label    id=occupation    Employee

    Click Element    xpath=//input[@id="other"]/parent::label

    Wait Until Element Is Visible    id=nextenterproductdata    ${TIMEOUT}
    Click Button    id=nextenterproductdata

Enter Policy Details
    Wait Until Element Is Visible    id=startdate    ${TIMEOUT}
    Input Text    id=startdate    10/10/2026
    Select From List By Label    id=insurancesum    7.000.000,00
    Select From List By Label    id=meritrating    Bonus 1
    Select From List By Label    id=damageinsurance    No Coverage

    Click Element    xpath=//input[@id="EuroProtection"]/parent::label

    Select From List By Label    id=courtesycar    Yes

    Wait Until Element Is Visible    id=nextselectpriceoption    ${TIMEOUT}
    Click Button    id=nextselectpriceoption

Select Coverage
    Wait Until Element Is Visible    id=selectsilver    ${TIMEOUT}
    Click Element    id=selectsilver

    Wait Until Element Is Visible    id=nextsendquote    ${TIMEOUT}
    Click Button    id=nextsendquote

Complete Quote
    Wait Until Element Is Visible    id=email    ${TIMEOUT}
    Input Text    id=email    wichai.sandee@gmail.com
    Input Text    id=phone    0049201123456
    Input Text    id=username    wichai.sandee
    Input Text    id=password    SecretPassword123!
    Input Text    id=confirmpassword    SecretPassword123!
    Input Text    id=Comments    Please contact via email only

    Wait Until Element Is Visible    id=sendemail    ${TIMEOUT}
    Click Button    id=sendemail
```
