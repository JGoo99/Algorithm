-- 가장 큰 물고기 10마리의 ID와 길이를 출력
-- 길이를 기준으로 내림차순 정렬
-- 길이가 같다면 물고기의 ID에 대해 오름차순 정렬
-- D 컬럼명은 ID, 길이 컬럼명은 LENGTH

select id, length
from fish_info
order by length desc, id
limit 10