--1.
select ename,sal
from emp
where sal > 2850;

--2.
select empno,ename,deptno
from emp
where empno = 7566;

--3.
select empno,sal
from emp
where empno not between 1500 and 2850;

--4.
select ename,job,hiredate
from emp
where hiredate between '19810220' and '19810501' 
order by hiredate;

--5.
select ename,deptno
from emp
where deptno in(10,30)
order by ename;

--6.
select ename 'Employee',deptno + sal as 'Monthly Salary'
from emp
where (sal>1500) and (deptno in(10,30));

--7.
select ename,job,hiredate
from emp
where hiredate between'19820101'and'19821230';

--8.
select ename,job
from emp
where mgr is null;

--9.
select ename,sal,comm
from emp
where comm>0
order by sal desc, comm desc;

--10.
select ename,job
from emp
where ename like '__A%';

--11.
select ename,mgr,deptno
from emp
where ename like '%L%L%' and( deptno in(30) or mgr=7782);

--12.
select ename,job,sal
from emp
where (job in('Clerk') or job in('Analyst')) and (sal not in(1000,3000,5000));

--13.
select ename,sal,comm
from emp
where comm > sal*1.1;