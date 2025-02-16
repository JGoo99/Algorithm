/*
where)
동일 회원이 동일 상품 재구매

order)
회원 id, 상품 id
*/

select user_id, product_id
from online_sale
group by user_id, product_id
having count(*) > 1
order by user_id asc, product_id desc