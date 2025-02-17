select count(*) as COUNT
from ECOLI_DATA
where GENOTYPE & 2 < 1 and (GENOTYPE & 4 or GENOTYPE & 1) > 0;