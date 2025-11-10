# 관리자의 실수로 일부 동물의 입양일이 잘못 입력되었습니다. 
# 보호 시작일 > 입양일이 더 빠른 동물의 아이디와 이름을 조회하는 SQL문을 작성해주세요. 
# 보호 시작일이 빠른 순

select i.ANIMAL_ID, i.NAME
from ANIMAL_INS i
join ANIMAL_OUTS o on i.ANIMAL_ID = o.ANIMAL_ID
where i.DATETIME > o.DATETIME
order by i.DATETIME