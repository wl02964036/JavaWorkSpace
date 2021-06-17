--1.
select*
from dept;

--2.
SELECT empno,ename,job,hiredate
from emp;

--3.
select distinct job
from emp;

--4.
SELECT empno as "Emp#",ename as "Employee",job as "Job",hiredate as "Hire Date"
from emp;

--5.
select ename +' ,'+job as "Employee and Title"
from emp;
