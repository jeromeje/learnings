
---

# SECTION 4: AGGREGATE FUNCTIONS & GROUP BY

---

## 1. What are Aggregate Functions?

**Aggregate functions** perform calculations on a **set of rows** and return **a single value**.

They are commonly used in:
- Reports
- Dashboards
- Analytics queries
- Interview problem statements

---

## 2. Common Aggregate Functions

| Function | Description |
|--------|-------------|
| COUNT() | Counts rows |
| SUM() | Adds values |
| AVG() | Calculates average |
| MIN() | Finds minimum value |
| MAX() | Finds maximum value |

---

## 3. COUNT()

### Purpose
Counts number of rows.

```sql
SELECT COUNT(*) FROM employee;

Count Specific Column (ignores NULLs)

SELECT COUNT(salary) FROM employee;
```
📌 COUNT(*) counts all rows
📌 COUNT(column) ignores NULL values


---

4. SUM()

Purpose

Calculates total of numeric column.
`
SELECT SUM(salary) FROM employee;
`

---

5. AVG()

Purpose

Calculates average value.
`
SELECT AVG(salary) FROM employee;
`
📌 NULL values are ignored


---

6. MIN() and MAX()
`
SELECT MIN(salary), MAX(salary)
FROM employee;
`
Used to find:

Lowest salary

Highest marks

Oldest / newest record



---

7. GROUP BY Clause (VERY IMPORTANT ⭐⭐⭐)

Purpose

Groups rows that have the same values and applies aggregate functions on each group.


---

Syntax
`
SELECT column, AGG_FUNCTION(column)
FROM table
GROUP BY column;
`

---

Example
`
SELECT dept, COUNT(*)
FROM employee
GROUP BY dept;
`
✔️ Counts employees in each department


---

Multiple Columns in GROUP BY
`
SELECT dept, job_role, AVG(salary)
FROM employee
GROUP BY dept, job_role;
`

---

8. GROUP BY Rules (INTERVIEW FAVORITE ⭐)

1. Columns in SELECT (non-aggregated) must be in GROUP BY


2. GROUP BY comes after WHERE


3. GROUP BY comes before HAVING




---

9. HAVING Clause

Purpose

Filters groups, not rows.

📌 WHERE → filters rows
📌 HAVING → filters groups


---

Example
`
SELECT dept, COUNT(*)
FROM employee
GROUP BY dept
HAVING COUNT(*) > 5;
`
✔️ Shows departments with more than 5 employees


---

10. WHERE vs HAVING (VERY IMPORTANT ⭐)

Feature	WHERE	HAVING

Filters	Rows	Groups
Used With	Normal columns	Aggregate functions
Position	Before GROUP BY	After GROUP BY



---

11. Execution Order (INTERVIEW TRICK ⭐)

1. FROM


2. WHERE


3. GROUP BY


4. HAVING


5. SELECT


6. ORDER BY




---

Key Points to Remember

Aggregate functions return single value

GROUP BY groups rows

HAVING is mandatory for filtering aggregates

WHERE cannot be used with aggregate functions

COUNT(column) ignores NULL



---

Interview Questions

Basic

1. What are aggregate functions?


2. Difference between COUNT(*) and COUNT(column)?


3. What does GROUP BY do?




---

Intermediate

4. Difference between WHERE and HAVING?


5. Can we use WHERE with aggregate functions?


6. Can GROUP BY use multiple columns?




---

Advanced

7. What happens if GROUP BY rules are violated?


8. Can HAVING exist without GROUP BY?


9. How does SQL internally process GROUP BY?




---

Scenario-Based Questions

Scenario 1

Find total salary per department.
`
SELECT dept, SUM(salary)
FROM employee
GROUP BY dept;
`

---

Scenario 2

Find departments with average salary > 50,000.
`
SELECT dept, AVG(salary)
FROM employee
GROUP BY dept
HAVING AVG(salary) > 50000;
`

---

Scenario 3

Count employees per department where salary > 30,000.
`
SELECT dept, COUNT(*)
FROM employee
WHERE salary > 30000
GROUP BY dept;
`

---

Practice Questions

1. Find maximum salary in each department.


2. Display departments having more than 10 employees.


3. Find average salary of IT department.


4. Count number of employees with non-null salary.


5. Find minimum salary for each job role.



