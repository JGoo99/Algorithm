/*
where)
bass, snapper 수 출력
*/

select count(*) as FISH_COUNT
from fish_info
where fish_type in (select fish_type
                    from fish_name_info
                    where fish_name = "BASS" || fish_name = "SNAPPER")
