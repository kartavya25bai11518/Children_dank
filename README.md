# 🏦 Children Bank – Java Banking Management System

Children Bank is a **console-based banking management system** developed in Java. The application simulates basic banking services and allows users to manage their accounts through a command-line interface.

## 📌 Features

* **Create a new account:** Enter customer details and make a minimum initial payment of ₹500.
* **Sign in:** Access an existing account using a username and account number.
* **Debit money:** Withdraw money from the account based on the available balance.
* **Credit money:** Deposit money into the account.
* **Fixed Deposit (FD):** Create an FD using simple interest with different plans:

  * 1 year – 7%
  * 2 years – 7.2%
  * 3 years – 7.3%
  * 5 years – 7.5%
* **Personal Loan:** Apply for a personal loan of up to ₹50 lakh at an interest rate of 8.7%.
* **Check account balance:** View the current account balance.
* **Check FD status:** View the stored FD amount.
* **Check loan status:** View the outstanding loan amount and repay the full amount.
* **CSV data storage:** Save and update account information using a CSV file.

## 🛠️ Technologies Used

* Java
* Java I/O (`FileReader`, `FileWriter`, `BufferedReader`, `BufferedWriter`)
* `Scanner` for user input
* `ArrayList` for storing account records
* `Random` for generating account numbers
* CSV file handling
* Exception handling

## 📂 Project Structure

```text
ChildrenBank/
│
├── ChildrenBank.java
├── bank_info.csv
└── README.md
```

> `bank_info.csv` stores account records. The program can create the file when a new account is added.

## ▶️ How to Run

### 1. Install Java

Make sure Java Development Kit (JDK) is installed on your computer.

Check the installation:

```bash
java -version
javac -version
```

### 2. Compile the program

Open a terminal in the project directory and run:

```bash
javac ChildrenBank.java
```

### 3. Run the program

```bash
java ChildrenBank
```

The application will start in the terminal and display the Children Bank menu.

## 💳 Demo Account

The program displays demo account information when it starts. Use the demo details provided in the program to test the sign-in process, provided the corresponding record exists in `bank_info.csv`.

## 📊 Account Data

The application stores five values for each account in the CSV file:

| Field          | Description                    |
| -------------- | ------------------------------ |
| Name           | Account holder's username/name |
| Account Number | Generated account number       |
| Balance        | Current account balance        |
| Loan Amount    | Outstanding loan amount        |
| FD Amount      | Stored fixed deposit amount    |

## 🎯 Project Objective

The main objective of this project is to develop a basic banking simulation while learning Java programming concepts such as:

* Object-oriented programming fundamentals
* Loops and conditional statements
* File handling
* Collections
* Exception handling
* User input validation
* Financial calculations
* CSV data management

## ⚠️ Limitations

This project is intended for educational purposes and is not a real banking system.

* Account authentication uses a username and account number; no password system is implemented.
* Customer details such as Aadhaar, PAN, phone number, and email are collected during account creation but are not stored in the CSV record.
* CSV data is handled using simple comma separation.
* Banking operations are performed one at a time during each execution.
* The application does not provide real financial transactions or secure banking services.

## 🚀 Future Improvements

* Add password-based authentication.
* Store complete customer details securely.
* Add transaction history.
* Prevent duplicate account numbers.
* Improve input validation.
* Add multiple transactions in one session.
* Use a database such as MySQL instead of a CSV file.
* Develop a graphical user interface.

## 👨‍💻 Author

Developed as an educational Java project to practice programming and file-handling concepts.
