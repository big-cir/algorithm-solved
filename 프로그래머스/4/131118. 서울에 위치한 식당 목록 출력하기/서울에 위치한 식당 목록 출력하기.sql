with REST_SCORE as (
    select REST_ID,
        round(avg(REVIEW_SCORE), 2) as SCORE
    from REST_REVIEW
    group by REST_ID
)

select t1.REST_ID, t1.REST_NAME, t1.FOOD_TYPE, t1.FAVORITES, t1.ADDRESS, t2.SCORE
from REST_INFO t1
join REST_SCORE t2 on t2.REST_ID = t1.REST_ID
where ADDRESS like '서울%'
order by t2.SCORE desc, t1.FAVORITES desc;