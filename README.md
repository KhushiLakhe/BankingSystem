Banking System Management Application (Java)

Project Description
The Banking System is a menu-driven Java console application designed to manage basic banking operations efficiently. The application allows users to create bank accounts, deposit money, withdraw money, and check account balances. The system is implemented using Object-Oriented Programming concepts and stores account details dynamically using an ArrayList. To ensure data persistence, file handling is used to save and load account information. The program follows a structured and modular approach for clarity, maintainability, and ease of understanding.

Objectives
To implement Object-Oriented Programming concepts in Java
To perform basic banking operations such as account creation, deposit, withdrawal, and balance enquiry
To use ArrayList for dynamic storage of account records
To implement file handling for permanent data storage
To design a menu-driven console-based application

Features
Menu-driven user interface
Create new bank accounts
Deposit money into an account
Withdraw money from an account
Check account balance
Dynamic storage using ArrayList
Permanent storage using file handling

Concepts Used
Java classes and objects
Encapsulation
Inheritance
Polymorphism
ArrayList collection framework
File handling using ObjectInputStream and ObjectOutputStream
Loops
Conditional statements using switch case
Scanner class for user input handling

Program Flow
Display banking menu options to the user
Accept user choice
Perform the selected banking operation
Create account, deposit money, withdraw money, or check balance
Display appropriate success or error messages
Save data to file before exiting
Repeat the process until the user chooses to exit

Method Description
Method Name | Description
createAccount() | Creates a new bank account and stores it in the ArrayList
deposit() | Deposits a specified amount into an existing account
withdraw() | Withdraws a specified amount from an existing account
checkBalance() | Displays account details and current balance
findAccount() | Searches for an account using account number
saveAccounts() | Saves all account data to a file
loadAccounts() | Loads saved account data from the file
main() | Controls the menu and overall program execution

Input Validation
Account Number must be an integer value entered by the user
Account Holder Name must be a valid string
Deposit amount must be a positive number
Withdrawal amount must not exceed the available balance
Menu choice is restricted to valid options from 1 to 5

Conclusion
The Banking System application successfully demonstrates the use of Object-Oriented Programming principles, ArrayList for dynamic data handling, and file handling for persistent storage. The menu-driven design makes the system user-friendly, and the modular structure improves readability and maintainability. This project serves as a strong foundation for understanding Java-based real-world applications and can be extended further using database connectivity.
