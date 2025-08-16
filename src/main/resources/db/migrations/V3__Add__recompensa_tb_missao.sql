-- V3: Migrations para adicionar a coluna de RECOMPENSA na tabela de missao

ALTER TABLE tb_missao
ADD COLUMN recompensa DECIMAL(19,2);