select t1.ID, t2.FISH_NAME, t1.LENGTH
from FISH_INFO t1
join FISH_NAME_INFO t2 on t1.FISH_TYPE = t2.FISH_TYPE
where t1.FISH_TYPE in (
    select FISH_TYPE
    from FISH_INFO
    group by FISH_TYPE
    having LENGTH = max(LENGTH)
)
order by ID asc;