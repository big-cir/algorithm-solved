select t3.AUTHOR_ID, t3.AUTHOR_NAME, t1.CATEGORY, sum(t1.PRICE * t2.SALES) as TOTAL_SALES
from BOOK t1
join BOOK_SALES t2 on t1.BOOK_ID = t2.BOOK_ID
join AUTHOR t3 on t1.AUTHOR_ID = t3.AUTHOR_ID
where date_format(SALES_DATE, '%Y-%m') = '2022-01'
group by t3.AUTHOR_ID, t3.AUTHOR_NAME, t1.CATEGORY
order by t3.AUTHOR_ID, t1.CATEGORY desc