
SECTION-1-SQL-BASICS.md


---

# SECTION 1: SQL BASICS (FOUNDATION)

---

## 1. What is SQL?

**SQL (Structured Query Language)** is a standard language used to store, retrieve, manipulate, and manage data in relational databases.

- SQL is a **query language**, not a programming language.
- It works mainly with **Relational Database Management Systems (RDBMS)**.

### What SQL Can Do
- Create databases and tables
- Insert, update, delete records
- Retrieve data using queries
- Manage database security
- Control transactions

### Databases that Use SQL
- MySQL
- PostgreSQL
- Oracle
- SQL Server
- SQLite

---

## 2. DBMS vs RDBMS

| Feature | DBMS | RDBMS |
|------|------|------|
| Data Storage | Files | Tables (Rows & Columns) |
| Relationships | ❌ No | ✅ Yes |
| Normalization | ❌ No | ✅ Yes |
| Data Integrity | ❌ Low | ✅ High |
| Examples | File System | MySQL, Oracle |

---

## 3. Types of SQL Commands

SQL commands are categorized into five types:

### 3.1 DDL – Data Definition Language
Used to define and manage database structures.

| Command | Description |
|------|------------|
| CREATE | Create database or table |
| ALTER | Modify table structure |
| DROP | Delete table/database |
| TRUNCATE | Remove all table records |

---

### 3.2 DML – Data Manipulation Language
Used to manipulate table data.

| Command | Description |
|------|------------|
| INSERT | Add new records |
| UPDATE | Modify existing records |
| DELETE | Remove records |

---

### 3.3 DQL – Data Query Language
Used to retrieve data.

| Command |
|------|
| SELECT |

---

### 3.4 DCL – Data Control Language
Used to control user access.

| Command |
|------|
| GRANT |
| REVOKE |

---

### 3.5 TCL – Transaction Control Language
Used to manage transactions.

| Command |
|------|
| COMMIT |
| ROLLBACK |
| SAVEPOINT |

---

## 4. SQL Data Types

### Numeric Data Types
- INT
- FLOAT
- DECIMAL

### Character Data Types
- CHAR
- VARCHAR
- TEXT

### Date and Time Data Types
- DATE
- TIME
- DATETIME
- TIMESTAMP

---

## 5. Creating Database and Table

### Create Database
```sql
CREATE DATABASE company;

Use Database

USE company;

Create Table

CREATE TABLE employee (
    emp_id INT PRIMARY KEY,
    name VARCHAR(50),
    salary DECIMAL(10,2),
    dept VARCHAR(30)
);
```

---

6. Constraints in SQL

Constraints enforce rules on data.

Types of Constraints

Constraint	Description

PRIMARY KEY	Unique + Not Null
FOREIGN KEY	References another table
UNIQUE	Ensures unique values
NOT NULL	Prevents NULL values
CHECK	Validates condition
DEFAULT	Assigns default value


Constraint Example

CREATE TABLE student (
    id INT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    age INT CHECK (age >= 18),
    country VARCHAR(20) DEFAULT 'India'
);


---

Key Points to Remember

SQL is case-insensitive

Each table must have a primary key

DDL commands auto-commit

TRUNCATE is faster than DELETE

DELETE supports rollback, TRUNCATE does not



---

Interview Questions

Basic

1. What is SQL?


2. Difference between DBMS and RDBMS?


3. What are SQL commands?


4. What is a database?



Intermediate

5. Difference between DELETE, TRUNCATE, and DROP?


6. What are constraints?


7. Can a table have multiple primary keys?


8. What is DEFAULT constraint?



Advanced

9. Is SQL procedural or non-procedural?


10. Why is TRUNCATE faster than DELETE?


11. Can we rollback TRUNCATE?




---

Scenario-Based Questions

Scenario 1

Remove all records but keep table structure.
Answer: TRUNCATE

Scenario 2

Delete specific records from a table.
Answer: DELETE with WHERE

Scenario 3

Ensure salary is always greater than zero.
Answer: CHECK constraint


---

Practice Questions

1. Create a table department with:

dept_id (Primary Key)

dept_name (Not Null)

location (Default: Chennai)



2. What happens if NULL is inserted into a NOT NULL column?


3. Write SQL to drop a database named test_db.

