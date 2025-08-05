# BugBash_Shophub_Automation
BDD-based UI test automation framework for ShopHub login module of https://bugbash.syook.com/ using selenium webdriver, cucumber(Bdd), and java with maven.

# Project Structure
BugBash_Automation/
├── src/
│   └── test/
│       ├── java/
│       │   ├── pages/              # Page Object Model classes
│       │   │   └── login.java
│       │   ├── test_runner/        # Cucumber Test Runner
│       │   │   └── runner.java
│       │   └── test_steps/         # Test Steps
│       │       └── login_test.java
│       └── resources/
│           └── features/
│               └── Login.feature   # Gherkin file
├── target/
│   └── cucumber-reports.html       # Test Results Reports
├── pom.xml                         # Maven configuration to download dependencies and plugins
└── README.md                       # Project Documentation

# Prerequisites

Before running the project, ensure you have:
- Java JDK 17+
- Maven 3.8+
- Chrome browser installed
- Internet connection

Install dependencies by running: mvn clean install in command promt

# Feature Files
Located in: `src/test/resources/features/Login.feature`

**Scenarios included:**
- Successful login with valid credentials
- Error message shown on login with invalid credentials

# Test Execution
Run tests using Maven: mvn test in command prompt

# Test Result Reports
- After execution, a basic HTML report is generated in target/cucumber-reports/index.html
- To view the report, open it in your browser.

# Test Data Management

Test data is managed using `Scenario Outline` and `Examples` in Gherkin, making it easy to scale tests with more data.

# Author

- Name: Santhosh R
- Role: QA Automation Engineer  
- GitHub: https://github.com/Santhosh-Gitrepo
