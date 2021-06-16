--1.
create view EMP_VU
as
	select empno,ename 'EMPLOYEE',deptno
	from emp;
go;
--2.
select*
from EMP_VU

--3.
select EMPLOYEE,deptno
from EMP_VU;

--4.
go;
create view DEPT20
as
	select empno 'EMPLOYEE_ID',ename 'EMPLOYEE',deptno 'DEPARTMENT_ID'
	from emp
	where deptno = 20
	with check option;

--5.
exec sp_help dept20
	select*
	from dept20

--6.
update DEPT20
set DEPARTMENT_ID = 30
where EMPLOYEE ='Smith';

--7.
create view SALARY_VU
as
	select e.ename 'Employee',d.dname 'Department',e.sal 'Salary',g.grade 'Grade'
	from emp e join dept d
				on (e.deptno=d.deptno)
			   join salgrade g
				on (e.sal between g.losal and g.hisal); 

--8.
create index emp_deptno_idx
on emp(deptno);

--9.
create sequence DEPT_ID_SEQ
as int
start with 60
increment by 10
maxvalue 200
no cache
no cycle;

--10.
insert into dept(deptno,dname)
values(next value for DEPT_ID_SEQ,'Education'),
	  (next value for DEPT_ID_SEQ,'Administration');