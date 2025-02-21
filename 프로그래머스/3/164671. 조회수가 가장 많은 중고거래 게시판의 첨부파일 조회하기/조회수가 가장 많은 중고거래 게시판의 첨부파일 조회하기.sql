/*
where)
조회수가 가장 높은 게시물

첨부파일 경로 조회

order)
fileid desc
*/

with top_board as (
    select *
    from used_goods_board as a
    order by a.views desc
    limit 1
)

select
    concat("/home/grep/src/", board_id, "/", file_id, file_name, file_ext) as file_path
from used_goods_file
where board_id in (select board_id from top_board)
order by file_id desc