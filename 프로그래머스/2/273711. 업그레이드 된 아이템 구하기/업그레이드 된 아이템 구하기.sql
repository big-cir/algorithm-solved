select ITEM_ID, ITEM_NAME, RARITY
from ITEM_INFO
where ITEM_ID in (
    select s1.ITEM_ID
    from ITEM_TREE s1
    join ITEM_INFO s2 on s2.ITEM_ID = s1.PARENT_ITEM_ID and s2.RARITY = 'RARE'
    where s1.PARENT_ITEM_ID is not null
)
order by ITEM_ID desc;