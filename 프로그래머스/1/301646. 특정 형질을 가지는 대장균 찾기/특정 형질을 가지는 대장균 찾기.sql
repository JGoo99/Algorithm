/*
2번 형질 x and 1번이나 3번 형질 o
개체수 출력
*/

select count(genotype) as COUNT
from ecoli_data
where genotype & 2 != 2
    and (genotype & 4 = 4 || genotype & 1 = 1)