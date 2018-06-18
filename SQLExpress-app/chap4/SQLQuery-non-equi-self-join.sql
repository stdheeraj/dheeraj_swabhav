SELECT Distinct 'Salary Comparasion' = e.names + ' having higher salary than ' + emp.names
FROM Employee e INNER JOIN Employee emp
ON e.salary > emp.salary
WHERE e.salary>2000