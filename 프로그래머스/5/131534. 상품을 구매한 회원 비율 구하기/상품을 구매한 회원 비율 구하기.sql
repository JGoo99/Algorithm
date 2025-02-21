/*
where)
2021 가입

2021 가입한 회원 중 상품을 구매한 회원 수 / 2021 가입한 회원 수 -> 소수점 두번째에서 반올림

년, 월 별로 출력

order)
년 asc, month asc
*/

with users as (
    select user_id
    from user_info
    where year(joined) = 2021
)

select
    year(sales_date) as year,
    month(sales_date) as month,
    count(distinct user_id) as purchased_users,
    round(count(distinct user_id) / (select count(*) from users), 1) as purchased_ratio
from online_sale
where user_id in (select * from users)
group by year, month
order by year asc, month asc