# Employee Records - Solutions

### CTEs

1) Calculate the average salary of all employees

```sql
SELECT
	AVG(salary) AS company_average
FROM employees;
```

2) Calculate the average salary of the employees in each team (hint: you'll need to `JOIN` and `GROUP BY` here)

```sql
SELECT
	departments.id,
	departments.name,
	AVG(salary) AS department_average
FROM employees
INNER JOIN departments
ON employees.department_id = departments.id
GROUP BY departments.id
```

3) Using a CTE find the ratio of each employees salary to their team average, eg. an employee earning £55000 in a team where the average is £50000 has a ratio of 1.1

```sql
WITH department_averages (id, name, department_average) AS (
	SELECT
		departments.id,
		departments.name,
		AVG(salary) AS department_average
	FROM employees
	INNER JOIN departments
	ON employees.department_id = departments.id
	GROUP BY departments.id
)
SELECT
	employees.first_name,
	employees.last_name,
	employees.salary,
	department_averages.name,
	department_averages.department_average,
	employees.salary / department_averages.department_average AS ratio
FROM employees
INNER JOIN department_averages
ON employees.department_id = department_averages.id
```

4) Find the employee with the highest ratio in Argentina

```sql
WITH department_averages (id, name, department_average) AS (
	SELECT
		departments.id,
		departments.name,
		AVG(salary) AS department_average
	FROM employees
	INNER JOIN departments
	ON employees.department_id = departments.id
	GROUP BY departments.id
)
SELECT
	employees.first_name,
	employees.last_name,
	employees.salary,
	department_averages.name,
	department_averages.department_average,
	employees.salary / department_averages.department_average AS ratio
FROM employees
INNER JOIN department_averages
ON employees.department_id = department_averages.id
WHERE employees.country = 'Argentina'
ORDER BY ratio DESC
LIMIT 1
```

5) **Extension:** Add a second CTE calculating the average salary for each country and add a column showing the difference between each employee's salary and their country average

```sql
WITH department_averages (id, name, department_average) AS (
	SELECT
		departments.id,
		departments.name,
		AVG(salary) AS department_average
	FROM employees
	INNER JOIN departments
	ON employees.department_id = departments.id
	GROUP BY departments.id
),
country_averages (name, country_average) AS (
	SELECT
		country,
		AVG(salary)
	FROM employees
	GROUP BY country
)
SELECT
	employees.first_name,
	employees.last_name,
	employees.salary,
	department_averages.name,
	department_averages.department_average,
	employees.salary / department_averages.department_average AS ratio,
	employees.salary - country_averages.country_average AS country_difference
FROM employees
INNER JOIN department_averages
ON employees.department_id = department_averages.id
INNER JOIN country_averages
ON employees.country = country_averages.name
```

---

### Window Functions

1) Find the running total of salary costs as the business has grown and hired more people

```sql
SELECT 
	SUM(salary) OVER (ORDER BY start_date) AS total_salary
FROM employees
```

2) Determine if any employees started on the same day (hint: some sort of ranking may be useful here)

```sql
SELECT 
	RANK() OVER (ORDER BY start_date) AS simple_ranking,
	DENSE_RANK() OVER (ORDER BY start_date) AS dense_ranking
FROM employees
ORDER BY simple_ranking DESC

-- RANK() and DENSE_RANK() handle equally-ranked elements differently. If these numbers match then there are no equally-ranked rows but as soon as two values match the counts will become offset. That has happened here, so the answer is "yes - some employees started on the same day"
```

3) Find how many employees there are from each country

```sql
SELECT
	DISTINCT(country),
	COUNT(*) OVER (PARTITION BY country)
FROM employees
```

4) Show how the average salary cost for each department has changed as the number of employees has increased

```sql
SELECT
	employees.first_name,
	employees.last_name,
	departments.name,
	employees.start_date,
	employees.salary,
	AVG(employees.salary) OVER (PARTITION BY employees.department_id ORDER BY employees.start_date) AS dept_average
FROM employees
INNER JOIN departments
ON employees.department_id = departments.id
ORDER BY employees.start_date
```

5) **Extension:** Research the `EXTRACT` function and use it in conjunction with `PARTITION` and `COUNT` to show how many employees started working for BusinessCorp&#8482; each year. If you're feeling adventurous you could further partition by month...

```sql
<!-- Year only -->

WITH employee_start_dates (id, year, month) AS (
	SELECT
		id,
		EXTRACT(YEAR FROM start_date),
		EXTRACT(MONTH FROM start_date)
	FROM employees
)
SELECT
	DISTINCT(year) AS start_year,
	COUNT(*) OVER (PARTITION BY year) AS new_start_count
FROM employees
INNER JOIN employee_start_dates
ON employees.id = employee_start_dates.id
ORDER BY start_year
```

```sql
<!-- Year and month -->

WITH employee_start_dates (id, year, month) AS (
	SELECT
		id,
		EXTRACT(YEAR FROM start_date),
		EXTRACT(MONTH FROM start_date)
	FROM employees
)
SELECT
	DISTINCT(year) AS start_year,
	month AS start_month,
	COUNT(*) OVER (PARTITION BY year, month) AS new_start_count
FROM employees
INNER JOIN employee_start_dates
ON employees.id = employee_start_dates.id
ORDER BY start_year
```

---

### Combining the two

1) Find the maximum and minimum salaries

```sql
SELECT
	MAX(salary) AS max_salary,
	MIN(salary) AS min_salary
FROM employees;
```

2) Find the difference between the maximum and minimum salaries and each employee's own salary

```sql
SELECT
	first_name,
	last_name,
	salary,
	salary - (MAX(salary) OVER ()) AS max_offset,
	salary - (MIN(salary) OVER ()) AS min_offset
FROM employees;
```

3) Order the employees by start date. Research how to calculate the **standard deviation** in salary values and show how these change as more employees join the company

```sql
SELECT
	first_name,
	last_name,
	start_date,
	salary,
	STDDEV(salary) OVER (ORDER BY start_date) AS salary_std_dev
FROM employees;
```


4) Limit this query to only Research & Development team members and show a rolling value for only the 5 most recent employees.

```sql
SELECT
	first_name,
	last_name,
	departments.name,
	start_date,
	salary,
	STDDEV(salary) OVER (ORDER BY start_date ROWS 5 PRECEDING) AS salary_std_dev
FROM employees
INNER JOIN departments
ON employees.department_id = departments.id
WHERE departments.name = 'Research and Development';
```