select FACTORY_ID, FACTORY_NAME, ADDRESS
from FOOD_FACTORY
# where TLNO like '033%'
where ADDRESS like '강원도%'
order by FACTORY_ID
