SELECT fullname, salary
FROM Employee e LEFT JOIN Name n
ON e.names=n.fullname