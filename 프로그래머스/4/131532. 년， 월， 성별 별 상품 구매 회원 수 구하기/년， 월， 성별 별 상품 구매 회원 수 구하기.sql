/*
where)
년, 월, 성별 별로
상품을 구매한 회원수

성별 정보 없는 경우 제외

order)
년, 월, 성별 asc
*/

select
    year(a.sales_date) as year,
    month(a.sales_date) as month,
    b.gender,
    count(distinct b.user_id) as users
from online_sale as a
    join user_info as b
    on (a.user_id = b.user_id) and (gender is not null)
group by year, month, b.gender
order by year asc, month asc, b.gender asc
    
