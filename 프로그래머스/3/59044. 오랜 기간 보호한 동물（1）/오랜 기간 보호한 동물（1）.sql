select t1.NAME, t1.DATETIME
from ANIMAL_INS t1
left join ANIMAL_OUTS t2 on t1.ANIMAL_ID = t2.ANIMAL_ID
where t2.DATETIME is null
order by t1.DATETIME
limit 3