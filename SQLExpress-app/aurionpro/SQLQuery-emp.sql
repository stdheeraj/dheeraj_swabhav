
--* display all emp in ascending order
SELECT *
FROM EMP
ORDER BY ENAME;


--* display all emp in dept 10
SELECT *
FROM EMP
WHERE DEPTNO = 10;


--* display all emp whose commission is null
SELECT *
FROM EMP
WHERE COMM IS NULL;


--* display emp name in starting with 's'
SELECT ENAME
FROM EMP
WHERE ENAME LIKE 'S%';


--* display emp who are managers
SELECT *
FROM EMP
WHERE EMPNO IN 
			(SELECT MGR
			 FROM EMP
			);


--* display top 2 salary examine emp
SELECT TOP 2 SAL, ENAME
FROM EMP
ORDER BY SAL DESC;


--* display emp name in small case
SELECT LOWER(ENAME) AS ENAME
FROM EMP


--* display emp details with ctc column
SELECT *, CASE 
            WHEN COMM IS NULL 
               THEN SAL*12
               ELSE (SAL+COMM)*12
       END as CTC 
FROM EMP;
--or
SELECT *, (SAL+COALESCE(COMM, 0))*12 AS CTC
FROM EMP


--* all emp in dept in 10 and 20
SELECT *
FROM EMP
WHERE DEPTNO = 10 OR DEPTNO = 20


--* sum of salary of all emp
SELECT SUM(SAL) AS [SUM OF SALARY]
FROM EMP


--* avg salary of all emp
SELECT AVG(SAL) AS [AVG OF SALARY]
FROM EMP


--* all emp in same dept of 'smith'
SELECT *
FROM EMP
WHERE DEPTNO IN 
			(SELECT DEPTNO
			 FROM EMP
			 WHERE ENAME = 'SMITH'
			); 


--* emp having same salary of 'blake'
SELECT *
FROM EMP
WHERE SAL IN 
			(SELECT SAL
			 FROM EMP
			 WHERE ENAME = 'BLAKE'
			); 


--* DEPT WISE NO OF EMP
SELECT DEPTNO, COUNT(*) AS NO_EMP
FROM EMP
GROUP BY DEPTNO;


--* JOB WISE NO OF EMP
SELECT JOB, COUNT(*)AS NO_EMP
FROM EMP
GROUP BY JOB;


--* DEPT WISE, JOB WISE NO OF EMP
SELECT DEPTNO, JOB, COUNT(*) AS NO_EMP
FROM EMP
GROUP BY JOB, DEPTNO;


--* DISPLAY EMP WITH THEIR DEPT NAME
SELECT ENAME, DNAME
FROM EMP E JOIN DEPT D
ON E.DEPTNO = D.DEPTNO;


--* ALL DEPTS WITH EMP IF ANY
SELECT DNAME, ENAME
FROM DEPT D LEFT OUTER JOIN EMP E
ON E.DEPTNO = D.DEPTNO;


--* ALL DEPTS WHICH DOES NOT HAVE AN EMP
SELECT D.DEPTNO,DNAME, ENAME
FROM DEPT D 
LEFT OUTER JOIN EMP E
ON D.DEPTNO = E.DEPTNO
WHERE E.ENAME IS NULL;


--* ALL EMP NAME AND THEIR BOSS
SELECT X.ENAME, ISNULL(Y.ENAME, 'CEO') AS BOSS
FROM EMP X 
LEFT OUTER JOIN EMP Y
ON X.MGR = Y.EMPNO;


--* ALL EMP NAME, DEPT NAME AND HIS MANAGER NAME
SELECT E1.ENAME, D.DNAME, E2.ENAME
FROM EMP E1 
JOIN DEPT D 
ON E1.DEPTNO = D.DEPTNO
LEFT OUTER JOIN EMP E2
ON E1.MGR = E2.EMPNO;


--* DEPT WISE, JOB WISE, SUM OF THE SALARY OF THE EMP 
--* WHOSE SALARY GREATER THAN 2000 AND DISPLAY IN THE 
--* OREDR OF SUM OF SALARY
SELECT DEPTNO, JOB, (SAL+COALESCE(COMM, 0)) AS SUM_SALARY
FROM EMP
WHERE SAL+COALESCE(COMM, 0) > 2000
GROUP BY JOB, DEPTNO, (SAL+COALESCE(COMM, 0))
ORDER BY SAL+COALESCE(COMM, 0) DESC



SELECT *, (SAL+COALESCE(COMM, 0))*12 AS CTC
FROM EMP


--* GET SALARY IN ASCENDING ORDER
 SELECT SAL
 FROM EMP
 ORDER BY SAL;
 

--* check constraint in salary
ALTER TABLE EMP 
ADD CONSTRAINT CHK_SAL_EMP   
CHECK (SAL >= 800 AND SAL <= 5000);

--*INSERT INTO EMP
INSERT INTO EMP VALUES (7000,'DHEERAJ','DEVELOPER',7566,'17-NOV-18',700,NULL,20);

--* GIVE HIKE TO EMP

CREATE PROCEDURE sp_givehike @ENO INT, @HIKE INT
AS
BEGIN
UPDATE EMP
SET SAL += SAL*@HIKE/100
WHERE EMPNO = @ENO
END
GO

EXECUTE sp_givehike 7369, 10

--*TRIGGER FOR CONVERTING UPPER CASE WHILE INSERT

CREATE Trigger ToUpperCaseName 
ON EMP Instead OF INSERT, UPDATE
AS
Begin
    UPDATE  EMP
    SET     ENAME = UPPER(ENAME)
    --WHERE   EMPNO IN (SELECT EMPNO FROM inserted)
End


SELECT *
FROM EMP

INSERT INTO EMP VALUES (7500,'dheeraj','CLERK',7782,'23-JAN-82',1300,NULL,10);


CREATE Trigger Name 
ON EMP Instead Of INSERT, UPDATE
AS
Begin
    INSERT INTO EMP (ENAME) VALUES ()
End

DROP TRIGGER ToUpperCaseName;