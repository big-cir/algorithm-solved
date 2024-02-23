select t1.FLAVOR
from FIRST_HALF t1
join JULY t2 on t1.FLAVOR = t2.FLAVOR
group by t1.FLAVOR
order by sum(t1.TOTAL_ORDER + t2.TOTAL_ORDER) desc
limit 3