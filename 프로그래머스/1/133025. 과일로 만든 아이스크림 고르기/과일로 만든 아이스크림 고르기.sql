select t1.FLAVOR
from FIRST_HALF t1, ICECREAM_INFO t2
where t1.TOTAL_ORDER > 3000 and t1.FLAVOR = t2.FLAVOR and t2.INGREDIENT_TYPE = 'fruit_based'
order by t1.TOTAL_ORDER desc