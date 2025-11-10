# select 맛
# where 7월 아이스크림 총 주문량 , 상반기의 아이스크림 총 주문량을 더한 값이 
# order by 큰 순서대로 
# limit 3개

select f.FLAVOR
from FIRST_HALF f
join (select flavor, sum(total_order) as TOTAL_ORDER
        from JULY 
        group by flavor) j
    on  j.FLAVOR = f.flavor
order by j.TOTAL_ORDER + f.TOTAL_ORDER desc limit 3