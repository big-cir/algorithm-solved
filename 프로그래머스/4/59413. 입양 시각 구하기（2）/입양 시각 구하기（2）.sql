set @hour := 0;

with recursive INIT_HOUR as (
    select 0 as HOUR
    union all
    select (@hour := @hour + 1) from INIT_HOUR where @hour < 23
)

select t1.HOUR as HOUR, count(t2.DATETIME) as COUNT
from INIT_HOUR t1
left join ANIMAL_OUTS t2 on t1.HOUR = hour(t2.DATETIME)
group by HOUR
order by HOUR asc;