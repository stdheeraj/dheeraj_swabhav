CREATE NONCLUSTERED INDEX name_clustered_index
ON Persons (LastName,FirstName);


CREATE TABLE Persons (
    ID int NOT NULL PRIMARY KEY,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Age int,
    CONSTRAINT UC_Person UNIQUE (LastName)
);

GO
CREATE PROCEDURE SelectByJob @JOB varchar(9)
AS
SELECT *
FROM EMP
WHERE JOB =@JOB
GO;

CREATE FUNCTION helloworldfunction()
RETURNS varchar(20)
AS 
BEGIN
	 RETURN 'Hello world'
END;

GO
SELECT DBO.helloworldfunction() AS WISH
GO


DROP FUNCTION helloworldfunction
