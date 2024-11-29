-- 코드를 작성해주세요
select ID, EMAIL, FIRST_NAME, LAST_NAME
from DEVELOPERS d
where d.skill_code & (
    select sum(s.code)
    from SKILLCODES s
    where s.CATEGORY = 'Front End'
)
order by ID;