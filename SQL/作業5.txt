--1.
select getdate() as '系統日期';

--2.
select empno,ename,sal,cast(sal*1.15 as int ) as 'New Salary'
from emp;

--3.
select empno,ename,sal,cast(sal*1.15 AS int) as 'New Salary',cast((sal*1.15 - sal) as int) as 'Increase'
from emp;

--4.
select ename,datediff(month,hiredate,getdate()) as 'MONTH_WORKED'
from emp;

--5.
select CONCAT(ename,' earns ',cast(sal as varchar),' monthly but wants ',cast(sal*3 as varchar)) as 'Dream Salaries'
from emp;

--6.
select ename,'$' + convert(varchar(15),sal) as 'SALARY'
from emp;

--7.
select ename,iif(comm is null,'No Commision',cast(comm as varchar)) 'COMMISION'
from emp;

--8.
select ename+replicate(' ',15-len(ename))+replicate('*',sal/100) as 'EMPLOYEE_AND_THEIR_SALARIES'
from emp;

--9.
select replicate('*',sal/100)
from emp;