--1.
select round(max(sal),0) as 'Maximum',round(min(sal),0) as 'Minimum',round(sum(sal),0) as 'Sum',round(avg(sal),0) as 'Average'
from emp;

--2.
select job,min(sal),max(sal),sum(sal),avg(sal)
from emp
group by job;

--3.
select job,count(ename)
from emp
group by job;

--4.
select count(distinct mgr) as 'Number of Managers'
from emp;

--5.
select (max(sal)-min(sal)) as 'DIFFERENCE'
from emp;

--6.
select mgr,min(sal)
from emp
where mgr is not null
group by mgr
having min(sal)>=1000
order by min(sal) desc;

--7.
select year(hiredate) 'HireDate', count(hiredate) 'hire in 1980 to 1983'
from emp
where year(hiredate) between 1980 and 1983
group by year(hiredate);