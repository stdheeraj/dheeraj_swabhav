SELECT fullname, salary
FROM Employee e FULL OUTER JOIN Name n
ON e.names=n.fullname