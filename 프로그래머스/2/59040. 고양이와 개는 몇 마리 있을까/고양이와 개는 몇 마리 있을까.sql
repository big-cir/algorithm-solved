select ANIMAL_TYPE, count(*) as count
from ANIMAL_INS
where ANIMAL_TYPE regexp 'Cat|Dog'
group by ANIMAL_TYPE
order by ANIMAL_TYPE