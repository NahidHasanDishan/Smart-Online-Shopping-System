# Smart Online Shopping System

A console-based online shopping management system developed using **Java** and Object-Oriented Programming (OOP) principles.

The project simulates essential shopping operations, including product management, inventory tracking, shopping cart functionality, checkout, discount calculation, invoice generation, and order storage.

## Features

- **Product Management:** Add and display products with their ID, name, price, and available quantity.
- **Inventory Tracking:** Automatically update product quantities when items are added to or removed from the cart.
- **Shopping Cart:** Add products, remove products, view cart contents, and calculate the total.
- **Checkout:** Process customer orders with different payment options.
- **Payment Methods:** Simulated credit card and mobile banking payments.
- **Discount Calculation:** Apply a 10% discount when the order total is 1,000 or more.
- **Invoice Generation:** Display an invoice containing customer information, purchased products, and payment totals.
- **Order Storage:** Save order information locally in `orders.txt`.
- **Exception Handling:** Handle invalid product quantities and products that cannot be found.

## Technologies Used

- **Programming Language:** Java
- **Programming Concepts:** Object-Oriented Programming (OOP)
- **Development Environment:** IntelliJ IDEA
- **Data Storage:** Text file (`orders.txt`)
- **Version Control:** Git and GitHub

## OOP Concepts Implemented

The project demonstrates several fundamental OOP concepts:

- **Encapsulation:** Private class attributes with methods for controlled access.
- **Inheritance:** Credit card and mobile banking payment classes extend an abstract payment class.
- **Polymorphism:** Different payment implementations are handled through a common `Payment` reference.
- **Abstraction:** Abstract `Payment` class and `Discountable` interface.
- **Exception Handling:** Custom exceptions for product availability and quantity validation.

## Project Structure

```text
SmartOnlineShoppingSystem/
├── src/
│   ├── Main.java
│   ├── Product.java
│   ├── Customer.java
│   ├── ShoppingCart.java
│   ├── Order.java
│   ├── Payment.java
│   ├── CreditCardPayment.java
│   ├── MobileBankingPayment.java
│   ├── Discountable.java
│   ├── ProductNotFoundException.java
│   └── ProductQuantityException.java
├── orders.txt
└── .gitignore
```

## How to Run

### Using IntelliJ IDEA

1. Clone or download this repository.
2. Open the project in IntelliJ IDEA.
3. Configure a compatible Java JDK.
4. Navigate to `src/Main.java`.
5. Run the `Main` class.
6. Follow the instructions displayed in the console.

### Using the Terminal

From the project root directory:

```bash
javac -d out src/*.java
java -cp out Main
```

Make sure the Java Development Kit (JDK) is installed.

## Application Menu

The application provides eight main options:

```text
========== Online Shopping System ==========

1. Add Product
2. Display Products
3. Add Product to Cart
4. Remove Product from Cart
5. Display Shopping Cart
6. Checkout
7. Save Order
8. Exit
```

## Payment and Discount System

The system supports two simulated payment methods:

- Credit Card
- Mobile Banking

Orders with a total of 1,000 or more receive a 10% discount.

For example:

```text
Total Amount: 1500.00
Discount: 150.00
Final Amount: 1350.00
```

Payments are simulated for educational purposes. No real financial transactions are performed.

## Purpose

This project was developed to strengthen practical understanding of Java programming, object-oriented design, collections, file handling, and exception management.

It demonstrates how multiple Java classes can work together to implement a basic shopping management workflow.

## Developer

**Md. Nahid Hasan Dishan**

Software Engineering Student

- GitHub: [NahidHasanDishan](https://github.com/NahidHasanDishan)
- Portfolio: [nahid-hasan-dishan.netlify.app](https://nahid-hasan-dishan.netlify.app/)

---

*An academic Java project focused on object-oriented programming and shopping management fundamentals.*
