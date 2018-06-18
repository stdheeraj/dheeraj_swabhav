INSERT INTO Names(fullname)
  SELECT names
  FROM   Employee
  WHERE  salary > 2600