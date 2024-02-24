select t1.PRODUCT_ID, t1.PRODUCT_NAME, sum(t1.PRICE * t2.AMOUNT) as TOTAL_SALES
from FOOD_PRODUCT t1
join FOOD_ORDER t2 on t1.PRODUCT_ID = t2.PRODUCT_ID
where date_format(PRODUCE_DATE, '%Y-%m') = '2022-05'
group by t1.PRODUCT_ID
order by TOTAL_SALES desc, t1.PRODUCT_ID


# 1. 생산일자(PRODUCE_DATE)가 2022-05
# 2. 총 매출 기준으로 내림차순, 식품 ID 오름차순