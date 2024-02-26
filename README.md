# webstaurantstore-automation
# Selenium Automation Testing Project

This project is a Maven-based Java project that utilizes Selenium for automated testing of web applications. It focuses on automating a test case for the WebstaurantStore website, specifically testing the functionality of searching for items, verifying search results, and manipulating the shopping cart.

## Project Structure

- `src/main/java`: Contains the core automation framework and utility classes.
- `src/test/java`: Contains test cases and test suites.
- `pom.xml`: Maven project file with dependencies and project configuration.

## Getting Started

### Prerequisites

- Java JDK 11 or higher installed.
- Maven installed for managing project dependencies and running the project.
- Google Chrome browser installed.

### Dependencies

- Selenium WebDriver for browser automation.
- JUnit for assertions and test management.
- WebDriverManager for managing browser driver binaries.

### Setup and Installation

1. Clone the repository to your local machine.
2. Open the project in IntelliJ IDEA or your preferred IDE.
3. Ensure that Maven successfully imports all dependencies specified in `pom.xml`.

### Running Tests

Tests can be run directly from the IDE or via the command line using Maven:

```shell
mvn clean test
