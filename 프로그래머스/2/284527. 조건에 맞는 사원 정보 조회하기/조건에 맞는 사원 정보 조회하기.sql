/*
where)
2022년 한해 평가 점수가 가장 높은 사원
*/

select
    sum(score) as score,
    a.emp_no,
    emp_name,
    position,
    email
from hr_grade as a
    join hr_employees as b
    on a.emp_no = b.emp_no
where year = 2022
group by a.emp_no
order by score desc
limit 1