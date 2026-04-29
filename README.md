# ToolShop Application

## Project Description

This project is a Selenium Java Automation Framework developed using Page Object Model (POM) for a ToolShop e-commerce web application.

## Features

* User Registration, Login and Logout Automation
* Product Search and Category Navigation
* Add to Cart and Cart Management
* Wishlist (Add, Validate, Remove)
* Checkout Flow Automation (Billing, Payment, Confirmation)
* Form Validations for invalid and empty inputs
* Screenshot Capture on Test Failure
* Extent Reports for execution results

## Tech Stack

* Java
* Selenium WebDriver
* TestNG
* Maven
* WebDriverManager
* ExtentReports

## Reports

Execution reports are generated in the `/reports` folder using ExtentReports.

## Screenshots

Screenshots are automatically captured on test failure and stored in the `/screenshots` folder.

## Key Design

* Page Object Model (POM) implemented for better maintainability
* Reusable methods and utilities
* FluentWait used for dynamic elements (no Thread.sleep)
* Config-driven framework (browser, URL, timeout)
* Listener-based reporting and screenshot capture
