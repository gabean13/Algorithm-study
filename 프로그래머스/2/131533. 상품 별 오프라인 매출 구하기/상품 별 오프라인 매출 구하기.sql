select p.PRODUCT_CODE, sum(sales_amount)*p.price as SALES
from PRODUCT p
natural join OFFLINE_SALE o
group by p.product_id
order by SALES desc, PRODUCT_CODE;