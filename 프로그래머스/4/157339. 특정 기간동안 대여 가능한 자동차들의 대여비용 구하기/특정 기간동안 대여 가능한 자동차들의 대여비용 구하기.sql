/*
where)
자동차 종류가 세단 or SUV
2022.11.1 <= 대여 가능 날짜  <= 2022.11.30
50만원 <= 30일 대여금액 < 200만원

select)
id, 종류, 대여금액fee(정수)

order)
fee desc, 자동차종류 asc, id desc
*/

with available_car_list as (
    select distinct car_id
    from car_rental_company_rental_history
    where start_date <= "2022-11-30" and end_date >= "2022-11-1"
),
cars as (
    select *
    from car_rental_company_discount_plan as c
    where c.car_type in ("세단", "SUV") and c.duration_type = "30일 이상"
),
result as (
    select 
        a.car_id,
        a.car_type,
        round(((a.daily_fee * (1 - sub.discount_rate / 100)) * 30), 0) as fee
    from car_rental_company_car as a
        join (select * from cars) as sub
        on a.car_type = sub.car_type
    where
        (a.car_type in ("세단", "SUV"))
        and 
        (a.car_id not in (select * from available_car_list))
)

select * from result
where fee >= 500000 and fee < 2000000
order by fee desc, car_type asc, car_id desc