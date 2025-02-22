/*
where)
2022.1
카테고리별 도서 판매량

order)
카테고리명 asc
*/

select category, sum(a.sales) as total_sales
from book_sales as a
    join book as b
    on a.book_id = b.book_id
where year(a.sales_date) = 2022 and month(a.sales_date) = 1
group by b.category
order by b.category asc