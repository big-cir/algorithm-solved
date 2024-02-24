select t1.MEMBER_NAME, t2.REVIEW_TEXT, date_format(t2.REVIEW_DATE, '%Y-%m-%d') as REVIEW_DATE
from MEMBER_PROFILE t1
join REST_REVIEW t2 on t1.MEMBER_ID = t2.MEMBER_ID
where t1.MEMBER_ID = (
    select MEMBER_ID
    from REST_REVIEW
    group by MEMBER_ID
    order by count(MEMBER_ID) desc 
    limit 1
    )
order by t2.REVIEW_DATE, t2.REVIEW_TEXT

# 리뷰를 가장 많이 작성한 회원의 리뷰들을 조회
# 1. 회원 이름(MEMBER_NAME), 리뷰 텍스트(REVIEW_TEXT), 리뷰 작성일(REVIEW_DATE) 출력
# 2. 리뷰 작성일(REVIEW_DATE) 기준 asc, 텍스트(REVIEW_TEXT) asc

