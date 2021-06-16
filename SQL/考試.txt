--1.
select custid '客戶編號',name '客戶名稱',address+','+city+','+state+zip '郵遞地址','('+cast(area as varchar)+')'+phone '聯絡電話'
from customer
order by custid;

--2.??
select custid '客戶編號',count(*) '訂單數',sum(total) '訂單總金額',cast(round(avg(total),2) as decimal(7,2)) '平均訂單金額'
from ord
group by  custid
order by sum(total) desc;

--3.
select c.name '公司名稱',o.ordid '訂單編號',convert(date,o.orderdate) '訂單日期',convert(date,o.shipdate) '出貨日期',o.total '總金額'
from customer c join ord o
				on c.custid = o.custid
where c.custid = (select custid
				  from ord
				  where total=(select max(total)
							   from ord));

--4.
select c.custid '客戶編號',c.name '客戶名稱',sum(o.total) '訂單總金額'
from customer c join ord o
				on c.custid = o.custid
where orderdate between '19870101' and '19871231'
group by c.custid,c.name
order by sum(o.total) desc;

--5.
select pd.prodid '產酩編號',pd.descrip '產品描述',sum(i.qty) '銷售數量',sum(i.itemtot) '銷售金額'
from product pd join item i
				on pd.prodid = i.prodid
group by pd.prodid,pd.descrip
order by sum(i.qty) desc

--6.
select datename(year,orderdate) '銷售年度',sum(total) '銷售總金額',replicate('*',round(sum(total)/1000,0)) '銷售金額星星數'
from ord 
where datename(year,orderdate) between '1986' and '1987' 
group by datename(year,orderdate)

--7.
select c.custid '客戶編號',c.name '客戶名稱',o.ordid '訂單編號',convert(date,o.orderdate) '最早交易金額',o.total '訂單金額'
from customer c join ord o
				on c.custid = o.custid
where orderdate in (select min(orderdate)
				   from ord o2
				   where o.custid = o2.custid)
order by convert(date,o.orderdate);

--8.
select c.repid '業務編號',e.empno '業務姓名',count(c.repid) '接單數量',sum(o.total) '銷售總金額',cast(round(sum(o.total)/count(c.repid),2) as decimal(7,2)) '平均每單金額'
from customer c join emp e
				on c.repid = e.empno
				join ord o
				on c.custid = o.custid
where datename(year,orderdate) = 1987
group by c.repid,e.empno
order by sum(o.total) desc

--9.
create sequence cust_seq
as int
start with 109
increment by 1;

create sequence ord_seq
as int
start with 623
increment by 1;

--10.
alter table customer
add constraint customer_state_ck check (state in ('ca','mn'));
alter table customer
add constraint customer_state_ck check (creditlimit <= 10000);

--11.
alter table item
add constraint item_prodid_fk foreign key(prodid) references product(prodid);
go;

--12.
create view cust_turner_vu
as
	select *
	from customer
	where repid = (select empno
					from emp
					where ename = 'Turner')
go;

--13.

declare @NextAID int;
set @NextAID = next value for cust_seq;
declare @NextBID int;
set @NextBID = next value for ord_seq;

begin transaction;
	insert into customer
	values (@NextAID,'KEN SPORTS','36-41 UNION ST.APT.2G','FLUSHING','NY',11354,718,'539-1899',7499,null);
save transaction tr1;
	insert into ord
	values (@NextBID,'20150115',null,@NextAID,'2015-2-15',1310);
save transaction tr2;
	insert into item
	values (@NextBID,1,100890,56,10,560)
	insert into item
	values (@NextBID,2,200380,4,120,480)
	insert into item
	values (@NextBID,3,100861,45,6,270)
commit tran;