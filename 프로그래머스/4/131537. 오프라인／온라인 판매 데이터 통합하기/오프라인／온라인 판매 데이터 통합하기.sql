select date_format(SALES_DATE, '%Y-%m-%d') as SALES_DATE,
    PRODUCT_ID, USER_ID, SALES_AMOUNT
from (
    select SALES_DATE, PRODUCT_ID, USER_ID, SALES_AMOUNT
    from ONLINE_SALE
    where date_format(SALES_DATE, '%Y-%m') = '2022-03'
    
    union all
    
    select SALES_DATE, PRODUCT_ID, null as USER_ID, SALES_AMOUNT
    from OFFLINE_SALE
    where date_format(SALES_DATE, '%Y-%m') = '2022-03'
) as combined_sales
order by SALES_DATE, PRODUCT_ID, USER_ID;