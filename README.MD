# Appium Mobile Automation Tests

This repository contains automated tests for the SwagLabs Android application using Appium, Selenium, and TestNG. The project is set up to run functional UI tests on Android devices or emulators.

## Project Structure

The project has the following main components:

### Source Code
- **`src/main/java/com/swaglabs`**
  - **`constants`**: Contains constant values used throughout the project (e.g., `AndroidDriverConstants`, `SystemConstants`).
  - **`driverFactory`**: Manages driver instances such as `AndroidDriverService`.
  - **`locators`**: Contains classes for different page locators like `CartPageLocators` and `LoginPageLocators`.
  - **`pages`**: Represents the different pages of the SwagLabs application. Each page has a corresponding class (e.g., `CartPage`, `LoginPage`) for interacting with page elements.
  - **`util`**: Utility classes to assist in reusable functions, such as `ItemsListHelper` and `PropertiesHelper`.

### Test Code
- **`src/test/java/com/swaglabs`**
  - **`com.swaglabs.BaseTests`**: Base class that initializes drivers and manages setup/teardown operations for tests.
  - **`CartTests`**: Contains tests related to the cart functionality.
  - **`CheckoutTests`**: Contains tests for the checkout process.
  - **`com.swaglabs.LoginTests`**: Tests the login feature of the app.
  - **`com.swaglabs.ProductsTests`**: Tests product page functionality.
- **`src/test/resources`**
  - **`testng.xml`**: Configuration file for running TestNG test suites.

### Resources
- **`src/main/resources/properties`**
  - Configuration properties such as `android.properties`, `appium.properties`, and `login.properties`.

## Prerequisites
- **Java 11**
- **Maven 3.x**
- **Node.js (for Appium)**
- **Android SDK** (with necessary emulator images)

Ensure the following are installed:
- Appium Server (`npm install -g appium`)
- Android SDK and relevant platform tools

## Installation
1. Clone this repository:
   ```sh
   git clone https://github.com/username/AppiumMobileAutomationTests.git
   cd AppiumMobileAutomationTests
   ```

2. Install dependencies using Maven:
   ```sh
   mvn clean install
   ```

3. Set up the required Android emulator or connect a physical device.

## Running Tests

To run the test suite:

```sh
mvn clean test
```

## Generating Allure Reports
The project uses **Allure** for reporting. To generate an Allure report:

1. Run the tests:
   ```sh
   mvn clean test
   ```

2. Generate the Allure report:
   ```sh
   mvn allure:report
   ```

3. Serve the report to view it in a browser:
   ```sh
   allure serve target/allure-report
   ```

## GitHub Pages Deployment
The workflow is configured to deploy the Allure report to GitHub Pages automatically after the tests are executed successfully.

The deployed report can be found in the `gh-pages` branch of the repository.

## Folder Structure Overview
```
AppiumMobileAutomationTests/
├── src/
│   ├── main/
│   │   ├── java/com/swaglabs/
│   │   │   ├── constants/
│   │   │   ├── driverFactory/
│   │   │   ├── locators/
│   │   │   ├── pages/
│   │   │   └── util/
│   │   └── resources/properties/
│   └── test/
│       ├── java/com/swaglabs/
│       │   ├── BaseTests
│       │   ├── CartTests
│       │   ├── CheckoutTests
│       │   ├── LoginTests
│       │   └── ProductsTests
│       └── resources/
│           └── testng.xml
├── pom.xml
├── README.md

```

## Technologies Used
- **Appium**: For mobile automation.
- **Selenium**: For web element interactions.
- **TestNG**: For test management and running test suites.
- **Allure**: For reporting test results.

## License
This project is licensed under the MIT License. See the `LICENSE` file for details.
