--1.
select ename, hiredate
from emp
where deptno =(select deptno
				from emp
				where ename = 'Blake');

--2.
select ename,hiredate
from emp
where hiredate>(select hiredate
				from emp
				where ename = 'Blake');

--3.
select empno,ename,sal
from emp
where sal>(select avg(sal)
			from emp)
order by sal desc;

--4.
select empno,ename
from emp
where deptno in (select deptno
				from emp
				where ename like '%T%'
				group by deptno,ename);

--5.
select ename,deptno,job
from emp
where deptno in(select deptno
				from dept
				where loc ='Dallas');

--6.
select ename,sal
from emp
where mgr in(select empno
			from emp
			where ename = 'King');

--7.
select deptno,ename,job
from emp
where deptno =(select deptno
				from dept
				where dname = 'Sales');

--8.
select empno,ename,sal
from emp
where  sal > (select avg(sal) 
			  from emp) 
		  and deptno in (select deptno
						 from emp
						 where ename like '%T%');													 from emp
														 where ename like '%T%');

--9.														
select ename,deptno,sal
from emp
where deptno in (select deptno
				from emp
				where sal in(select sal
							 from emp
							 where comm >0))
			and sal in(select sal
							 from emp
							 where comm >0);

--10.
SELECT e.ename, e.deptno, e.sal
FROM emp e join (SELECT sal, comm 
				 From emp 
				 Where deptno= ( SELECT deptno FROM  dept WHERE loc='Dallas')) a
			On (e.sal=a.sal) and (isnull(e.comm,-1)=isnull(a.comm,-1));

--11.
select ename,hiredate,sal
from emp
where (sal in(select sal
			from emp
			where ename ='Scott')
		 and comm in(select comm
					from emp
					where ename = 'Scott' and comm is not null))
		and ename not in ('Scott');


--12.
select ename,hiredate,sal
from emp
where sal >all(select sal
				from emp
				where job = 'Clerks');