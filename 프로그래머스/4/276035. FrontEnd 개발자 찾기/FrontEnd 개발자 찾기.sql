-- 코드를 작성해주세요
select ID, EMAIL, FIRST_NAME, LAST_NAME
from DEVELOPERS d
join SKILLCODES s 
on (d.skill_code & s.code) > 0
where s.CATEGORY = 'Front End'
GROUP BY ID, EMAIL, FIRST_NAME, LAST_NAME
order by ID;