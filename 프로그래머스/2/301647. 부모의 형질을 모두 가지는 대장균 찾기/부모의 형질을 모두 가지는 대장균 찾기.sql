/*
where)
부모의 형질을 모두 보유한

select)
id, genotype, parent_genotype

order)
id asc
*/

select cur.id, cur.genotype, parent.genotype as parent_genotype
from ecoli_data as cur, ecoli_data as parent
where cur.parent_id = parent.id
    and cur.genotype & parent.genotype = parent.genotype
order by cur.id asc