# select CAR_ID, 
#     (select round(avg(datediff(END_DATE, START_DATE) + 1), 1)
#      from CAR_RENTAL_COMPANY_RENTAL_HISTORY 
#     ) as AVERAGE_DURATION
# from CAR_RENTAL_COMPANY_RENTAL_HISTORY
# group by CAR_ID
# order by AVERAGE_DURATION desc, CAR_ID desc

SELECT CAR_ID, ROUND(AVG(DATEDIFF(END_DATE, START_DATE)+1), 1) AS AVERAGE_DURATION
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
HAVING AVG(DATEDIFF(END_DATE, START_DATE) + 1) >= 7
ORDER BY AVERAGE_DURATION DESC, CAR_ID DESC