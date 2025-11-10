select f.ID, n.FISH_NAME, f.LENGTH
from FISH_INFO f
join FISH_NAME_INFO n
on f.FISH_TYPE = n.FISH_TYPE
where f.LENGTH = (
    select max(LENGTH)
    from FISH_INFO
    where FISH_TYPE=f.FISH_TYPE
);