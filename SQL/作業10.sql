--1.
create table DEPARTMENT
(
id numeric(7) not null,
name varchar(24) not null,
);

--2.
insert into DEPARTMENT(id,name)
select deptno,dname
from dept;

--3.
create table EMPLOYEE
(
id numeric(7) not null,
last_name varchar(24) not null,
first_name varchar(24),
dept_id numeric(7)
);

--4.
alter table EMPLOYEE
alter column last_name varchar(40);

--5.
select empno 'ID',ename 'LAST_NAME',deptno 'DEPT_ID'
into EMPLOYEE2
from emp;

--6.
drop table EMPLOYEE;

--7.
exec sp_rename 'EMPLOYEE2','EMPLOYEE';

--8.
alter table EMPLOYEE
drop column last_name ;

--9.
alter table EMPLOYEE
add SALARY numeric(7);


--10.
alter table EMPLOYEE
add constraint EMPLOYEE_ID_PK primary key (ID);

--11.
alter table EMPLOYEE
add constraint EMPLOYEE_DEPT_ID_FK foreign key (DEPT_ID) references department(id);