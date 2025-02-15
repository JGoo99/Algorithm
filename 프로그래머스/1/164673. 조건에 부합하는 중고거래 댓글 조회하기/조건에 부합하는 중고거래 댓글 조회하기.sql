-- 2022년 10월에 작성된
-- 게시글 제목, 게시글 ID, 댓글 ID, 댓글 작성자 ID, 댓글 내용, 댓글 작성일을 조회
-- 댓글 작성일을 기준으로 오름차순 정렬
-- 댓글 작성일이 같다면 게시글 제목을 기준으로 오름차순 정렬

select b.title, b.board_id, r.reply_id, r.writer_id, r.contents, date_format(r.created_date, "%Y-%m-%d") as created_date
from USED_GOODS_BOARD as b
    inner join USED_GOODS_REPLY as r
    on b.board_id = r.board_id
where date_format(b.created_date, "%Y-%m") = "2022-10" 
order by r.created_date, b.title
