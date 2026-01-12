--V2: Migration que adiciona a coluna rank nos cadastros

ALTER TABLE tb_cadastro
ADD COLUMN rank VARCHAR(255);