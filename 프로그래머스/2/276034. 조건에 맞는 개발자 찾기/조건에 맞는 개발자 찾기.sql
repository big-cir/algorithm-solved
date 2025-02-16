select distinct t1.ID, t1.EMAIL, t1.FIRST_NAME, t1.LAST_NAME
from DEVELOPERS t1
join SKILLCODES t2 on t2.NAME in ('C#', 'Python')
where t1.SKILL_CODE & t2.CODE
order by t1.ID;