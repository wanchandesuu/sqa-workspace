```robot
*** Settings ***
Library    SeleniumLibrary

*** Variables ***
${BROWSER}    chrome
${URL}       http://sampleapp.tricentis.com
${TIMEOUT}   10s

*** Test Cases ***
Automobile Insurance Process
    Open Browser    ${URL}    ${BROWSER}
    Maximize Browser Window

    Open Automobile Page
    Next From Vehicle
    Next From Insurant
    Next From Product
    Choose Insurance Plan
    Send Quote

    [Teardown]    Close Browser


*** Keywords ***
Open Automobile Page
    Wait Until Element Is Visible    id=nav_automobile    ${TIMEOUT}
    Click Element    id=nav_automobile

Next From Vehicle
    Wait Until Element Is Visible    id=nextenterinsurantdata    ${TIMEOUT}
    Click Element    id=nextenterinsurantdata

Next From Insurant
    Wait Until Element Is Visible    id=nextenterproductdata    ${TIMEOUT}
    Click Element    id=nextenterproductdata

Next From Product
    Wait Until Element Is Visible    id=nextselectpriceoption    ${TIMEOUT}
    Click Element    id=nextselectpriceoption

Choose Insurance Plan
    Wait Until Element Is Visible    id=selectsilver    ${TIMEOUT}
    Click Element    id=selectsilver

    Wait Until Element Is Visible    id=nextsendquote    ${TIMEOUT}
    Click Element    id=nextsendquote

Send Quote
    Wait Until Element Is Visible    id=sendemail    ${TIMEOUT}
    Click Element    id=sendemail
```
