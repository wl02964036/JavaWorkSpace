--1.
insert into my_emp
values(1,'Patel','Ralph','rpatel',795);

--2.
insert into my_emp(ID,LAST_NAME,FIRST_NAME,USERID,SALARY)	  
values(2,'Dancs','Betty','bdancs',860);

--3.
insert into my_emp(ID,LAST_NAME,FIRST_NAME,USERID,SALARY)	  
values(3,'Biri','Ben','bbiri',1100),
	  (4,'Newman','Chad','cnewman',750);

--4.
update my_emp
set LAST_NAME = 'Drexler'
where id = 3;

--5.
update my_emp
set SALARY = 1000
where SALARY<900;

--6.
select*
from my_emp;

--7.
delete my_emp
where last_name='Dancs' and first_name='Betty';

--8.
begin transaction;
	update my_emp
		set salary = salary + (salary* 10/100)
		where SALARY>0;
save transaction tr1;
delete my_emp
select*
from my_emp;
rollback tran tr1;
commit;
