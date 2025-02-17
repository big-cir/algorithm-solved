with col_count as (
    select ID, 
        percent_rank() over (order by SIZE_OF_COLONY desc) as col_rank
    from ECOLI_DATA
)

select ID, 
    case
        when col_rank <= 0.25 then 'CRITICAL'
        when col_rank <= 0.50 then 'HIGH'
        when col_rank <= 0.75 then 'MEDIUM'
        else 'LOW'
    end as COLONY_NAME
from col_count
order by ID asc