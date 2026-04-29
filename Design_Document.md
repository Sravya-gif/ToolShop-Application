# Test Framework Design

## Framework Type

Page Object Model (POM)

---

## Application Under Test

Primary Site:
https://demo.nopcommerce.com

Note:
The NopCommerce demo site had issues.  
So an alternate stable site was used:

Alternate Site:
https://practicesoftwaretesting.com/

---

## Features

* Config-driven execution using `config.properties`
* Reusable Page methods using Page Object Model (POM)
* FluentWait/WebDriverWait for dynamic elements (no Thread.sleep)
* Screenshot capture on test failure using TestNG Listener
* ExtentReports for HTML reporting
* Centralized Driver management using WebDriverManager
* Clean separation of Pages, Tests, and Utilities

---

## Project Structure
```
NopStore
│
├── src/main/java
│   ├── com.srm.base
│   │   ├── BasePage.java
│   │   └── BaseTest.java
│   │
│   ├── com.srm.driver
│   │   └── DriverFactory.java
│   │
│   ├── com.srm.listener
│   │   └── TestListener.java
│   │
│   ├── com.srm.pages
│   │   ├── HomePage.java
│   │   ├── LoginPage.java
│   │   ├── RegisterPage.java
│   │   ├── ProductPage.java
│   │   ├── CartPage.java
│   │   ├── WishlistPage.java
│   │   ├── CheckoutPage.java
│   │   └── SearchPage.java
│   │
│   ├── com.srm.utils
│   │   ├── ConfigReader.java
│   │   ├── WaitUtil.java
│   │   ├── ScreenshotUtil.java
│   │   └── ExtentManager.java
│
├── src/main/resources
│   └── config.properties
│
├── src/test/java
│   └── com.srm.tests
│       ├── LoginTest.java
│       ├── RegisterTest.java
│       ├── SearchTest.java
│       ├── CartTest.java
│       ├── WishlistTest.java
│       ├── CheckoutTest.java
│       └── FormValidationTest.java
│
├── reports
│   
│
├── screenshots
│   
│
├── testng.xml
├── pom.xml

```

## Test Coverage

* User Registration (valid & duplicate cases)
* Login (valid & invalid)
* Product Search and Category Navigation
* Add to Cart and Cart Management
* Wishlist (add, already exists validation)
* Checkout Flow (Billing, Payment, Confirmation)
* Form Validations (empty fields, invalid inputs)

---

## Tools & Technologies

* Java
* Selenium WebDriver
* TestNG
* Maven
* WebDriverManager
* ExtentReports

---
