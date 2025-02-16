select ID, 
    (select count(*)
     from ECOLI_DATA t2
     where t1.ID = t2.PARENT_ID
    ) as CHILD_COUNT
from ECOLI_DATA t1
