SELECT fullname, e.salary
FROM Employee e JOIN 
(Employee emp JOIN Name n
ON emp.names=n.fullname)
ON e.names=n.fullname