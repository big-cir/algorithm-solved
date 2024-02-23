select year(t2.SALES_DATE) as YEAR, month(t2.SALES_DATE) as MONTH, t1.GENDER as GENDER, count(distinct t1.USER_ID) as USERS
from USER_INFO t1
join ONLINE_SALE t2 on t1.USER_ID = t2.USER_ID
where t1.GENDER is not null
group by YEAR, MONTH, GENDER
order by YEAR, MONTH, GENDER