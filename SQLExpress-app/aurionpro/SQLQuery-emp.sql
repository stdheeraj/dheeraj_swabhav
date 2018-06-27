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
--* display emp who are managers
--* display top 2 salary examine emp
--* display emp name in small case
--* display emp details with ctc column
--* all emp in dept in 10 and 20
--* sum of salary of all emp
--* avg salary of all emp
--* all emp in same dept of 'smith'
--* emp having same salary of 'blake'