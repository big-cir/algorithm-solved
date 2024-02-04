select t1.TITLE, t1.BOARD_ID, t2.REPLY_ID, t2.WRITER_ID, t2.CONTENTS, date_format(t2.CREATED_DATE, '%Y-%m-%d') as CREATED_DATE
from USED_GOODS_BOARD t1
inner join USED_GOODS_REPLY t2 on t1.BOARD_ID = t2.BOARD_ID
where date_format(t1.CREATED_DATE, '%Y-%m') = '2022-10'
order by t2.CREATED_DATE asc, t1.TITLE asc

