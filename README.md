# Automation Framework - DemoBlaze & DummyAPI

Repository ini berisi framework automation untuk UI (Web) dan API.

## Tools & Library
* Java 17
* Selenium WebDriver
* Cucumber (Gherkin)
* Rest Assured
* Gradle

## Cara Menjalankan Test
### API Test
`./gradlew apiTest "-DAPP_ID=YOUR_APP_ID"`

### Web Test
`./gradlew webTest`

## Report
Setelah running, report dapat ditemukan di:
`build/reports/cucumber/web-report.html`