
---

# SECTION 12: SQL FUNCTIONS & CASE STATEMENT

---

## 1. What are SQL Functions?

**SQL functions** are predefined routines that perform operations on data and return a result.

📌 Used for:
- Data transformation
- Calculations
- Formatting output
- Conditional logic

---

## 2. Types of SQL Functions

| Type | Description |
|----|------------|
| Single-row (Scalar) Functions | Operate on one row |
| Aggregate Functions | Operate on multiple rows |

📌 Aggregate functions are already covered in Section 4

---

## PART A: SINGLE-ROW (SCALAR) FUNCTIONS

---

## 3. String Functions

### 3.1 UPPER() and LOWER()

```sql
SELECT UPPER(name), LOWER(name)
FROM employee;

✔️ Converts text to upper/lower case
```

---

3.2 LENGTH()
```
SELECT name, LENGTH(name)
FROM employee;
```
✔️ Returns number of characters


---

3.3 SUBSTRING() / SUBSTR()
```
SELECT SUBSTRING(name, 1, 3)
FROM employee;
```
✔️ Extracts part of string


---

3.4 CONCAT()
```
SELECT CONCAT(first_name, ' ', last_name)
FROM employee;
```
✔️ Joins strings


---

3.5 TRIM()
```
SELECT TRIM(name)
FROM employee;
```
✔️ Removes leading & trailing spaces


---

4. Numeric Functions

4.1 ROUND()
```
SELECT ROUND(123.456, 2);
```
✔️ Rounds to decimal places


---

4.2 CEIL() and FLOOR()
```
SELECT CEIL(12.1), FLOOR(12.9);
```
✔️ Rounds up / down


---

4.3 ABS()
```
SELECT ABS(-50);
```
✔️ Returns absolute value


---

5. Date & Time Functions

5.1 CURRENT_DATE / CURDATE()
```
SELECT CURRENT_DATE;
```

---

5.2 NOW()
```
SELECT NOW();
```
✔️ Returns current date & time


---

5.3 DATE_ADD()
```
SELECT DATE_ADD(CURRENT_DATE, INTERVAL 7 DAY);
```
✔️ Adds days/months/years


---

5.4 DATEDIFF()
```
SELECT DATEDIFF('2025-01-10', '2025-01-01');
```
✔️ Returns difference in days


---

6. NULL Handling Functions

6.1 IFNULL()
```
SELECT IFNULL(salary, 0)
FROM employee;
```
✔️ Replaces NULL with value


---

6.2 COALESCE()
```
SELECT COALESCE(salary, bonus, 0)
FROM employee;
```
✔️ Returns first non-NULL value


---

PART B: CASE STATEMENT (VERY IMPORTANT ⭐⭐⭐)


---

7. What is CASE Statement?

CASE is a conditional expression used to apply IF–ELSE logic in SQL queries.

📌 Frequently asked in interviews
📌 Used in reports and analytics


---

8. CASE Syntax

CASE
    WHEN condition THEN result
    WHEN condition THEN result
    ELSE result
END


---

9. CASE Example – Salary Grade
```
SELECT name, salary,
CASE
    WHEN salary >= 70000 THEN 'High'
    WHEN salary >= 40000 THEN 'Medium'
    ELSE 'Low'
END AS salary_grade
FROM employee;
```

---

10. CASE with UPDATE
```
UPDATE employee
SET bonus =
CASE
    WHEN salary > 60000 THEN 5000
    ELSE 2000
END;
```

---

11. CASE with ORDER BY (Advanced)
```
SELECT * FROM employee
ORDER BY
CASE
    WHEN dept = 'IT' THEN 1
    WHEN dept = 'HR' THEN 2
    ELSE 3
END;
```

---

Key Points to Remember

Scalar functions work row by row

NULL must be handled explicitly

CASE replaces IF-ELSE

CASE can be used in SELECT, WHERE, ORDER BY, UPDATE



---

Interview Questions

Basic

1. What are SQL functions?


2. Difference between scalar and aggregate functions?


3. What does CONCAT() do?




---

Intermediate

4. Difference between IFNULL and COALESCE?


5. Can CASE be used in WHERE clause?


6. Difference between CASE and IF?




---

Advanced

7. CASE vs DECODE?


8. How to handle NULL values?


9. Can CASE be nested?




---

Scenario-Based Questions

Scenario 1

Display “Active” or “Inactive” based on status.
```
SELECT name,
CASE
    WHEN status = 1 THEN 'Active'
    ELSE 'Inactive'
END
FROM employee;
```

---

Scenario 2

Replace NULL salary with 0.
```
SELECT IFNULL(salary, 0)
FROM employee;
```

---

Scenario 3

Assign bonus based on salary range.

CASE
    WHEN salary > 70000 THEN 10000
    WHEN salary > 40000 THEN 5000
    ELSE 2000
END


---

Practice Questions

1. Use CASE to assign grades to students.


2. Find employees with NULL bonus and replace with 0.


3. Display employee experience in years using DATEDIFF().


4. Use CASE in ORDER BY to prioritize departments.


5. Difference between COALESCE and IFNULL.




---

End of Section 12

---

