# vendor-reconciliation
Java-based transaction reconciliation application that compares two CSV files using transaction reference numbers and amounts to identify matching and mismatched transactions.
## Project Overview

This application reads transaction data from two CSV files:

- `vendor.csv` – Contains vendor transaction details.
- `ledger.csv` – Contains ledger transaction details.

The application compares transactions using the **transaction reference number** and **amount** to identify matching and mismatched transactions.

The main goal of this project is to demonstrate a simple and reliable approach to transaction reconciliation using Java.

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- CSV File Handling
- Collections
- File I/O

## Project Structure

```text
supervity-vendor-reconciliation/
│
├── src/
│   ├── Main.java
│   ├── Transaction.java
│   ├── CsvReader.java
│   └── ReconciliationService.java
│
├── data/
│   ├── vendor.csv
│   └── ledger.csv
│
└── README.md
