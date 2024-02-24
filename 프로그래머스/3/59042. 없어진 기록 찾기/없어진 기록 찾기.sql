select t1.ANIMAL_ID, t1.NAME
from ANIMAL_OUTS t1
left outer join ANIMAL_INS t2 on t1.ANIMAL_ID = t2.ANIMAL_ID
where t2.ANIMAL_ID is null
order by t1.ANIMAL_ID

# 보호소에 들어온 기록이 없는 동물의 ID와 이름을 ID 순으로 조회