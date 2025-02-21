/*
where)
2022.8 ~ 2022.10 총 대여 횟수 5회 이상

월별
자동차 id별
총 대여 횟수 records

order)
month asc, car_id desc
특정 월의 총대여횟수 0인 경우 제외
*/

with sub as (
    select history_id, car_id
    from car_rental_company_rental_history
    where (start_date >= "2022-08-01" and start_date < "2022-11-01")
    group by car_id
    having count(car_id) >= 5
)

select
    month(start_date) as month,
    car_id,
    count(history_id) as records
from car_rental_company_rental_history as a
where car_id in (select car_id from sub)
    and
    (start_date >= "2022-08-01" and start_date < "2022-11-01")
group by month, car_id
order by month asc, car_id desc