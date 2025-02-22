/*
where)
2022.1 도서 판매 데이터

저자별, 카테고리별 매출액

order)
저자 id asc, 카테고리 desc
*/

select b.author_id, c.author_name, b.category, sum(a.sales * b.price) as total_sales
from book_sales as a
    join book as b
    on a.book_id = b.book_id
    join author as c
    on b.author_id = c.author_id
where year(a.sales_date) = 2022 and month(a.sales_date) = 1
group by c.author_id, b.category
order by b.author_id asc, b.category desc