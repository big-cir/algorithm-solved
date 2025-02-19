select t2.INGREDIENT_TYPE, sum(TOTAL_ORDER) as TOTAL_ORDER
from FIRST_HALF t1
join ICECREAM_INFO t2 on t1.FLAVOR = t2.FLAVOR
group by t2.INGREDIENT_TYPE
order by TOTAL_ORDER asc;