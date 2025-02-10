select f1.PRODUCT_ID, f1.PRODUCT_NAME, sum(f1.PRICE * f2.AMOUNT) as TOTAL_SALES
from FOOD_PRODUCT f1
join FOOD_ORDER f2 on f2.PRODUCT_ID = f1.PRODUCT_ID
where date_format(f2.PRODUCE_DATE, '%Y-%m') = '2022-05'
group by f1.PRODUCT_ID
order by TOTAL_SALES desc, PRODUCT_ID asc