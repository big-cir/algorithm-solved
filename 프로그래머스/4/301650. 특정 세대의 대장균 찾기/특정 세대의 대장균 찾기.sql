with F_E as (
    select ID
    from ECOLI_DATA
    where PARENT_ID is null
)

select ID
from ECOLI_DATA
where PARENT_ID in (
    select t1.ID
    from ECOLI_DATA t1
    join F_E t2 on t2.ID = t1.PARENT_ID
)
order by ID;