SELECT names, salary, new_salary = NULLIF(salary,0)
FROM Employee e FULL OUTER JOIN Name n
ON e.names=n.fullname


