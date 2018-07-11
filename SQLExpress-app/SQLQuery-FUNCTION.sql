--*GET CURRENT DATE
GO
CREATE FUNCTION getCurrentDate()
RETURNS VARCHAR(10)
AS
BEGIN
RETURN (SELECT convert(varchar(10), getdate(), 112))
END	
GO

--* DISPLAY CURRENT DATE
SELECT DBO.getCurrentDate() AS [CURRENT DATE]


--select cast(convert(varchar(10), getdate(), 112) as VARCHAR(10))
--* DROP FUNCTION
DROP FUNCTION getCurrentDate;