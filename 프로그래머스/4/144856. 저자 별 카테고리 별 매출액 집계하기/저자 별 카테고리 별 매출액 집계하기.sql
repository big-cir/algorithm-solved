with sales_count as (
    select BOOK_ID, sum(SALES) as COUNT
    from BOOK_SALES
    where SALES_DATE >= '2022-01-01' and SALES_DATE < '2022-02-01'
    group by BOOK_ID
)

select t1.AUTHOR_ID, t2.AUTHOR_NAME, t1.CATEGORY, sum(t1.PRICE * t3.COUNT) as TOTAL_SALES
from BOOK t1
join AUTHOR t2 on t2.AUTHOR_ID = t1.AUTHOR_ID
join sales_count t3 on t3.BOOK_ID = t1.BOOK_ID
group by t1.AUTHOR_ID, t2.AUTHOR_NAME, t1.CATEGORY
order by t1.AUTHOR_ID asc, t1.CATEGORY desc;