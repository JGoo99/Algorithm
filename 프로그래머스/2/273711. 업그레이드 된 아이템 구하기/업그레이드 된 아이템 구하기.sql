/*
where)
rarity = RARE
을 parent_item_no 로 갖는

order)
item_id
*/

select t.item_id, i.item_name, i.rarity
from item_tree as t
    join item_info as i
    on t.item_id = i.item_id
where t.parent_item_id in (select item_id
                             from item_info
                             where rarity = "RARE")
order by t.item_id desc