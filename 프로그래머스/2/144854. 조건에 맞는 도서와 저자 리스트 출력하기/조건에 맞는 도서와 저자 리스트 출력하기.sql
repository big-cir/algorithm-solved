select t1.BOOK_ID, t2.AUTHOR_NAME, date_format(t1.PUBLISHED_DATE, '%Y-%m-%d') as PUBLISHED_DATE
from BOOK t1
join AUTHOR t2 on t1.AUTHOR_ID = t2.AUTHOR_ID
where t1.CATEGORY = '경제'
order by t1.PUBLISHED_DATE