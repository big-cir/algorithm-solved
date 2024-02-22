select MCDP_CD as '진료과코드', count(*) as '5월예약건수'
from APPOINTMENT
where date_format(APNT_YMD, '%Y-%m') = '2022-05'
group by MCDP_CD
order by 5월예약건수, 진료과코드

# 문제
# 1. 2022-05월
# 2. 
# 3. 환자수 기준 오름차순 MCDP_CD 
