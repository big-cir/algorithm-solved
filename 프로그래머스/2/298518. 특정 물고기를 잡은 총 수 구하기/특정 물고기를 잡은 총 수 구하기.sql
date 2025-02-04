select count(*) as FISH_COUNT
from FISH_INFO t1
where t1.FISH_TYPE in (
    select FISH_TYPE
    from FISH_NAME_INFO
    where FISH_NAME regexp 'BASS|SNAPPER'
)