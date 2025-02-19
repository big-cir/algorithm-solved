select CAR_TYPE, count(*) as CARS
from CAR_RENTAL_COMPANY_CAR
where OPTIONS regexp '가죽시트|통풍시트|열선시트'
group by CAR_TYPE
order by CAR_TYPE asc;