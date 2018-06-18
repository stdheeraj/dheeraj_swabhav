SELECT Distinct 'Salary Comparasion' = e.names + ' having higher salary than ' + emp.names
FROM Employee e, Employee emp
WHERE e.salary>2000
AND e.salary > emp.salary