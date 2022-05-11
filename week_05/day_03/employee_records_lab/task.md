# Task - Employee Records

The major corporation BusinessCorp&#8482; wants to do some analysis of varioius metrics around its employees and have contracted the job out to you. They have provided you with two SQL files, you will need to write the queries which will extract the data they are looking for.

## Setup

- Create a database to run the files against
- Use the `psql -d database -f file` command to run the SQL files
- Before starting to write the queries take some time to look at the data and figure out the relationships between the tables - maybe even draw an ERD to help.

## Tasks

### CTEs

1) Calculate the average salary of all employees

```sql
<!--Copy solution here-->
```

2) Calculate the average salary of the employees in each team (hint: you'll need to `JOIN` and `GROUP BY` here)

3) Using a CTE find the ratio of each employees salary to their team average, eg. an employee earning £55000 in a team where the average is £50000 has a ratio of 1.1

4) Find the employee with the highest ratio in Argentina

5) **Extension:** Add a second CTE calculating the average salary for each country and add a column showing the difference between each employee's salary and their country average

---

### Window Functions

1) Find the running total of salary costs as the business has grown and hired more people

2) Determine if any employees started on the same day (hint: some sort of ranking may be useful here)

3) Find how many employees there are from each country

4) Show how the average salary cost for each department has changed as the number of employees has increased

5) **Extension:** Research the `EXTRACT` function and use it in conjunction with `PARTITION` and `COUNT` to show how many employees started working for BusinessCorp&#8482; each year. If you're feeling adventurous you could further partition by month...

---

### Combining the two

1) Find the maximum and minimum salaries

2) Find the difference between the maximum and minimum salaries and each employee's own salary

3) Order the employees by start date. Research how to calculate the **median** salary value and the **standard deviation** in salary values and show how these change as more employees join the company

4) Limit this query to only Research & Development team members and show a rolling value for only the 5 most recent employees.

