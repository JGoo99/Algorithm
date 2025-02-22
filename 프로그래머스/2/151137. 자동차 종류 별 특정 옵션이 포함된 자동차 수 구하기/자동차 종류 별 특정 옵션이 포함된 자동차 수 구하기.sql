/*
where)
특정 옵션 포함

자동차 종류별로 몇대(cars)

order)
종류 asc
*/

select car_type, count(car_id) as cars
from car_rental_company_car
where options like "%통풍시트%" or options like "%열선시트%" or options like "%가죽시트%" 
group by car_type
order by car_type asc