-- 코드를 입력하세요
SELECT f.flavor from FIRST_HALF as f
    inner join ICECREAM_INFO as i
    on f.flavor = i.flavor and i.ingredient_type = "fruit_based"
where f.total_order > 3000
order by total_order desc