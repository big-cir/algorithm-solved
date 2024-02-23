set @num = -1;
select (@num := @num + 1) as HOUR,
    (select count(*)
     from ANIMAL_OUTS
     where hour(DATETIME) = @num
    ) as COUNT
from ANIMAL_OUTS
where @num < 23;
