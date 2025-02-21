/*
where)
리뷰를 가장 많이 작성한 회원의 리뷰

select)
회원 이름, 리뷰 텍스트, 리뷰 작성일

order)
리뷰 작성일 asc, 텍스트 asc
*/

with sub as (
select member_id
from rest_review
group by member_id
order by count(*) desc
limit 1
)

select m.member_name, r.review_text, date_format(r.review_date, "%Y-%m-%d")
from member_profile as m
    join rest_review as r
    on (m.member_id = r.member_id)
where m.member_id in (select * from sub)
order by r.review_date asc, review_text asc
