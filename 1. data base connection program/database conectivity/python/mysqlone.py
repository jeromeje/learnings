# program 1: 
# Required Library for mysql connection to python:
# 1. pip install mysql-connector-python

import mysql.connector

# Connect to MySQL
conn = mysql.connector.connect(
    host="localhost",
    user="yourusername",
    password="yourpassword",
    database="yourdatabase"
)

cursor = conn.cursor()

# Example: Create table
cursor.execute("CREATE TABLE IF NOT EXISTS users (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), age INT)")

# Insert
cursor.execute("INSERT INTO users (name, age) VALUES (%s, %s)", ("Bob", 30))
conn.commit()

# Fetch
cursor.execute("SELECT * FROM users")
for row in cursor.fetchall():
    print(row)

conn.close()


# Program 2: 
# Required Library for postgresql connection to python:
# 1.    pip install psycopg2-binary


import psycopg2

# Connect to PostgreSQL
conn = psycopg2.connect(
    host="localhost",
    database="yourdatabase",
    user="yourusername",
    password="yourpassword"
)

cursor = conn.cursor()

# Example: Create table
cursor.execute("CREATE TABLE IF NOT EXISTS users (id SERIAL PRIMARY KEY, name VARCHAR(100), age INT)")

# Insert
cursor.execute("INSERT INTO users (name, age) VALUES (%s, %s)", ("Charlie", 35))
conn.commit()

# Fetch
cursor.execute("SELECT * FROM users")
print(cursor.fetchall())

conn.close()
