select t1.CATEGORY, sum(t2.SALES) as TOTAL_SALES
from BOOK t1
join BOOK_SALES t2 on t1.BOOK_ID = t2.BOOK_ID
where date_format(SALES_DATE, '%Y-%m') = '2022-01'
group by t1.CATEGORY
order by t1.CATEGORY

# 
# 1. 2022-01 판매
# 2. 총 판매량 구하기 SALES
# 3. 카테고리, 총 판매량 출력, 카테고리 오름차순


