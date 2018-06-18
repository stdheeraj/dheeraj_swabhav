DECLARE @a1 FLOAT, @b1 FLOAT
    SET @a1 = 3
    SET @b1 = 2
    SELECT @a1 + @b1 AS 'A1 + B1 = ';


DECLARE @a2 FLOAT, @b2 FLOAT
    SET @a2 = NULL
    SET @b2 = 2
    SELECT @a2 + @b2 AS 'A2 + B2 = ';
    
    
DECLARE @a3 FLOAT, @b3 FLOAT
    SET @a3 = NULL
    SET @b3 = 2
    SELECT ISNULL(@a3, 0) + ISNULL(@b3, 0) AS 'A3 + B3 = '