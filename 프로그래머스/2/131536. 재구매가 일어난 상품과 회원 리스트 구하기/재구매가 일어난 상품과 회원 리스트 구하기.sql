-- 코드를 입력하세요
-- ONLINE_SALE 테이블에서 동일한 회원이 동일한 상품을 재구매한 데이터를 구하여, 
-- 재구매한 회원 ID와 재구매한 상품 ID를 출력
-- 결과는 회원 ID를 기준으로 오름차순 정렬, 상품 ID를 기준으로 내림차순 
SELECT USER_Id, PRODUCT_ID
FROM ONLINE_SALE 
group by USER_Id, PRODUCT_ID
    having count(ONLINE_SALE_ID) > 1
order by USER_ID ASC, PRODUCT_ID DESC;