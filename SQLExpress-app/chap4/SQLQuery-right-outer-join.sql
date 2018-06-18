SELECT fullname, salary
FROM Employee e Right OUTER JOIN Name n
ON e.names=n.fullname