/*
where)
파이썬, c#

order)
id asc
*/

select id, email, first_name, last_name
from developers
where skill_code & (select code
                    from skillcodes
                    where Name = "Python")
    || skill_code & (select code
                    from skillcodes
                    where Name = "C#")
order by id asc