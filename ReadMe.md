# Advanced Car Dealership Management System

## 📌 Description of the Project
The **Advanced Car Dealership Management System** is a Java console-based application that enhances a basic vehicle inventory tool by introducing contract management for vehicle sales and leases. Staff can now not only manage vehicles (add, remove, search) but also process **Sales** and **Lease** contracts, compute total prices and monthly payments, and persist all contract data in a separate CSV file.

This project emphasizes **object-oriented programming**, **file I/O**, **inheritance with abstract classes**, and **real-world business logic** using Java. It's a great project for learning how to structure larger applications and simulate real dealership workflows.

---

## 📊 Class Diagram
*[Class Diagram](AdvancedCarDealerShipClassDiagram.png)*
Key Classes:
- `Vehicle`
- `Dealership`
- `Contract` (Abstract)
    - `SalesContract`
    - `LeaseContract`
- `ContractDataManager`
- `UserInterface`

---

## 🧑‍💼 User Stories
- As a dealership staff member, I want to view all vehicles in the inventory.
- As a staff member, I want to search for vehicles by price, make/model, year, color, mileage, or type.
- As a staff member, I want to add a new vehicle to the inventory so it appears in future searches.
- As a staff member, I want to remove a vehicle by VIN so that the inventory stays current.
- As a staff member, I want to create either a **Sales** or **Lease** contract for a selected vehicle.
- As a staff member, I want the total price and monthly payment to be calculated automatically.
- As a staff member, I want all contracts to be saved in a `contracts_with_headings.csv` file for future reference.

---

## ⚙️ Setup

### Prerequisites
- **IntelliJ IDEA**: [Download IntelliJ](https://www.jetbrains.com/idea/)
- **Java SDK 17+**: Make sure Java is installed and configured

### Running the Application in IntelliJ
1. Open IntelliJ IDEA.
2. Go to `File → Open`, then select the project folder.
3. Wait for IntelliJ to index all project files.
4. Navigate to `Program.java` (contains `main` method).
5. Right-click the file → `Run 'Program.main()'` to launch the console interface.

---

## 🛠 Technologies Used
- **Java 17+** – Programming Language
- `java.util.*` – Scanner, ArrayList
- `java.io.*` – FileReader, BufferedReader, FileWriter, BufferedWriter
- **OOP Concepts** – Inheritance, Abstraction, Encapsulation
- **CSV-Based File I/O** – Inventory & contract persistence

---

## 💾 File Format

### `dealership.csv`
Stores vehicle inventory:
