# select month(START_DATE) as MONTH, CAR_ID, count(HISTORY_ID) as RECORDS
# from CAR_RENTAL_COMPANY_RENTAL_HISTORY
# where date_format(START_DATE, '%Y') = 2022
#     and month(START_DATE) >= 8
#     and date_format(END_DATE, '%Y') = 2022
#     and month(END_DATE) <= 10
# group by CAR_ID
# having count(CAR_ID) >= 5
# order by MONTH, CAR_ID desc

select month(START_DATE) as MONTH, CAR_ID, count(*) as RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY
where date_format(START_DATE, '%Y-%m') between '2022-08' and '2022-10'
    and CAR_ID in (
        select CAR_ID
        from CAR_RENTAL_COMPANY_RENTAL_HISTORY
        where date_format(START_DATE, '%Y-%m') between '2022-08' and '2022-10'
        group by CAR_ID
        having count(CAR_ID) >= 5
    )
group by CAR_ID, MONTH
having RECORDS > 0
order by MONTH, CAR_ID desc

# 1. 2022-08 ~ 2022-10
# 2. 대여 횟수 5회
# 3. 대여 횟수가 0이면 제외