/*
where)
서울에 위치한

select)
리뷰 평균 점수는 소수점 세번재 자리에서 반올림
아이디, 이름, 종류, 즐찾수, 주소, 리뷰평균점수

order)
평균점수 desc, 즐겨찾기수 desc
*/

# select * from rest_info
# where address like "%서울%"

select 
    i.rest_id,
    i.rest_name,
    i.food_type,
    i.favorites,
    i.address,
    round(avg(r.review_score), 2) as score
from rest_info as i
    join rest_review as r
    on i.rest_id = r.rest_id
group by i.rest_id
having i.address like "서울%"
order by avg(r.review_score) desc, i.favorites desc
