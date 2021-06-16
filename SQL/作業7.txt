--1.
select e.ename,e.deptno,d.dname,d.loc
from emp e join dept d on e.deptno =d.deptno;

--2.
select e.ename,e.comm,d.dname,d.loc
from emp e join dept d on e.deptno = d.deptno
where e.comm>0;

--3.
select e.ename, d.dname
from emp e join dept d on e.deptno = d.deptno
where ename like '%A%';

--4.
select e.ename,e.job,d.deptno,d.dname
from emp e join dept d on e.deptno = d.deptno
where loc = 'DALLAS';

--5.
select e.ename 'Employee',e.empno 'Emp#',m.ename 'Manager',e.mgr 'Mgr#'
from emp e join emp m on e.mgr = m.empno;

--6.
select e.ename,e.job,d.dname,e.sal,b.grade
from (emp e join dept d on e.deptno =d.deptno) join salgrade b on (e.sal between b.losal and b.hisal);

--7.
select e.ename 'Employee',e.hiredate 'Emp Hiredate',m.ename 'Manager',m.hiredate 'Mgr Hiredate'
from emp e join emp m on e.mgr = m.empno
where e.hiredate < m.hiredate;

--8.
select d.dname 'dname',d.loc 'loc',count(d.deptno) 'Number of People',cast(round(avg(e.sal),2) as decimal(7,2)) 'Salary'
from emp e join dept d on e.deptno = d.deptno
group by d.deptno,d.loc,d.dname