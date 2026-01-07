
---

# SECTION 5: SQL JOINS (MOST IMPORTANT ⭐⭐⭐)

---

## 1. What is a JOIN?

A **JOIN** is used to **combine rows from two or more tables** based on a related column between them.

📌 Joins are used when:
- Data is stored in **multiple tables**
- Relationships exist via **Primary Key & Foreign Key**

---

## 2. Why JOINs are Important (Interview Perspective)

- Almost every real-time SQL query uses JOINs
- Used in:
  - Reports
  - Dashboards
  - Applications
  - Analytics
- One of the **top interview elimination topics**

---

## 3. Types of SQL JOINS

| Join Type | Description |
|---------|-------------|
| INNER JOIN | Matching rows from both tables |
| LEFT JOIN | All rows from left table + matching from right |
| RIGHT JOIN | All rows from right table + matching from left |
| FULL OUTER JOIN | All rows from both tables |
| SELF JOIN | Table joined with itself |
| CROSS JOIN | Cartesian product |

---

## Sample Tables Used

### employee
| emp_id | name | dept_id | salary |
|------|------|--------|--------|
| 1 | Ravi | 10 | 50000 |
| 2 | Anu | 20 | 60000 |
| 3 | John | NULL | 45000 |

### department
| dept_id | dept_name |
|-------|-----------|
| 10 | IT |
| 20 | HR |
| 30 | Finance |

---

## 4. INNER JOIN

### Definition
Returns **only matching records** from both tables.

---

### Syntax
```sql
SELECT columns
FROM table1
INNER JOIN table2
ON condition;
```

---

Example
```
SELECT e.name, d.dept_name
FROM employee e
INNER JOIN department d
ON e.dept_id = d.dept_id;
```
✔️ Only employees with valid departments
❌ Employees without department are excluded


---

5. LEFT JOIN (LEFT OUTER JOIN)

Definition

Returns all rows from left table and matching rows from right table.


---

Example
```
SELECT e.name, d.dept_name
FROM employee e
LEFT JOIN department d
ON e.dept_id = d.dept_id;
```
✔️ Includes employees even if department is NULL
❌ NULL appears for unmatched rows


---

6. RIGHT JOIN (RIGHT OUTER JOIN)

Definition

Returns all rows from right table and matching rows from left table.


---

Example
```
SELECT e.name, d.dept_name
FROM employee e
RIGHT JOIN department d
ON e.dept_id = d.dept_id;
```
✔️ Includes departments even without employees


---

7. FULL OUTER JOIN

Definition

Returns all rows from both tables.


---

Example
```
SELECT e.name, d.dept_name
FROM employee e
FULL OUTER JOIN department d
ON e.dept_id = d.dept_id;
```
✔️ Includes matched + unmatched rows from both tables

📌 Not supported directly in MySQL
👉 Use UNION workaround


---

8. SELF JOIN

Definition

A table joined with itself.

Used for:

Employee–Manager relationship

Hierarchical data



---

Example
````
SELECT e1.name AS employee, e2.name AS manager
FROM employee e1
LEFT JOIN employee e2
ON e1.manager_id = e2.emp_id;
````

---

9. CROSS JOIN

Definition

Returns Cartesian product.


---

Example
``
SELECT e.name, d.dept_name
FROM employee e
CROSS JOIN department d;
``
📌 Total rows = rows in table1 × rows in table2
⚠️ Use carefully


---

10. JOIN vs SUBQUERY (INTERVIEW FAVORITE ⭐)

Feature	JOIN	Subquery

Performance	Faster	Slower
Readability	Better	Complex
Usage	Preferred	Conditional


📌 JOIN is preferred in real-time applications


---

11. WHERE vs ON Clause (TRICK QUESTION ⭐)

Clause	Usage

ON	Join condition
WHERE	Filter result

``
-- Correct
SELECT *
FROM employee e
LEFT JOIN department d
ON e.dept_id = d.dept_id
WHERE d.dept_name = 'IT';
``

---

Key Points to Remember

INNER JOIN → matching rows only

LEFT JOIN → all left + matching right

RIGHT JOIN → all right + matching left

FULL JOIN → everything

SELF JOIN → same table

CROSS JOIN → Cartesian product



---

Interview Questions

Basic

1. What is a JOIN?


2. Difference between INNER and LEFT JOIN?


3. What is FOREIGN KEY?




---

Intermediate

4. Difference between JOIN and SUBQUERY?


5. When to use SELF JOIN?


6. Difference between ON and WHERE?




---

Advanced

7. How to implement FULL OUTER JOIN in MySQL?


8. What happens if JOIN condition is missing?


9. Which JOIN is fastest and why?




---

Scenario-Based Questions

Scenario 1

Fetch employees without department.
```
SELECT e.name
FROM employee e
LEFT JOIN department d
ON e.dept_id = d.dept_id
WHERE d.dept_id IS NULL;
```

---

Scenario 2

Find departments with no employees.
```
SELECT d.dept_name
FROM department d
LEFT JOIN employee e
ON d.dept_id = e.dept_id
WHERE e.emp_id IS NULL;
```

---

Scenario 3

Get employee name and department name.
```
SELECT e.name, d.dept_name
FROM employee e
INNER JOIN department d
ON e.dept_id = d.dept_id;
```

---

Practice Questions

1. Write a query to display employee name and salary with department.


2. Find employees who do not belong to any department.


3. Count employees in each department using JOIN.


4. Display department names even if no employees exist.


5. Write a SELF JOIN example.

