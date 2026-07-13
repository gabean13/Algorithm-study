-- 코드를 입력하세요
-- 식당 ID, 식당 이름, 음식 종류, 즐겨찾기수, 주소, 리뷰 평균 점수(소수점 세 번째 자리에서 반올림)를 조회
--  평균점수를 기준으로 내림차순 정렬, 즐겨찾기수를 기준으로 내림차순 정렬
select ri.REST_ID, ri.REST_NAME, ri.FOOD_TYPE, ri.FAVORITES, ri.ADDRESS, ROUND(AVG(rr.REVIEW_SCORE), 2) as SCORE
from REST_INFO ri
inner join REST_REVIEW rr 
on ri.REST_ID = rr.REST_ID
where ri.ADDRESS LIKE '서울%'
group by ri.REST_ID
order by SCORE DESC, ri.FAVORITES DESC;