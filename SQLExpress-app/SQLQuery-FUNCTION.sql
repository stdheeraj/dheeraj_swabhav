USE aurionpro;
GO

CREATE FUNCTION getDate(@Date INT)

RETURNS INT

AS

RETURN WITH 
	--	SELECT convert(varchar(10), getdate(), 110)
		

GO
--EXECUTE getAvgSal();

select getdate(), cast(
convert(varchar(10), getdate(), 110) as datetime
)