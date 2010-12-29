
drop table modos_entrada        cascade constraints;
drop table clientes             cascade constraints;
drop table funcionarios         cascade constraints;
drop table maquinas             cascade constraints;
drop table registos_manutencao  cascade constraints;
drop table pisos                cascade constraints;
drop table lugares              cascade constraints;
drop table bilhetes             cascade constraints;
drop table registos_lugares     cascade constraints;

CREATE TABLE bilhetes (
  id_bilhete            varchar2(4),
  data_hora_entrada     date,
  data_hora_pagamento   date,
  data_hora_saida       date,
  
  CONSTRAINT id_bilhete_pk
    PRIMARY KEY (id_bilhete)
);

CREATE TABLE pisos (
  id_piso     varchar2(2),
  n_lugares   varchar2(3),
  estado      varchar2(2),
  
  CONSTRAINT id_piso_pk
    PRIMARY KEY (id_piso)
);

CREATE TABLE lugares (
  id_lugar    varchar2(4),
  id_piso     varchar2(2),
  estado      varchar2(2),
  
  CONSTRAINT id_lugar_pk
    PRIMARY KEY (id_lugar),
  CONSTRAINT id_piso_fk
    FOREIGN KEY (id_piso)
    REFERENCES pisos(id_piso)
);

CREATE TABLE registos_lugares (
  id_lugar            varchar2(4),
  data_hora_ocupado   date,
  data_hora_livre     date,
  
  CONSTRAINT id_lugar_fk
    FOREIGN KEY (id_lugar)
    REFERENCES lugares(id_lugar)
);

CREATE TABLE funcionarios (
  id_funcionario        varchar2(8),
  nome_funcionario      varchar2(100),
  palavra_chave         varchar2(8),
  
  CONSTRAINT id_funcionario_pk
    PRIMARY KEY (id_funcionario)
);

CREATE TABLE maquinas (
  id_maquina            varchar2(8),
  id_piso               varchar2(8),
  localizacao           varchar2(100),
  montante              varchar2(5),
  
  CONSTRAINT id_maquina_pk
    PRIMARY KEY (id_maquina),
  CONSTRAINT id_piso_maquina_fk
    FOREIGN KEY (id_piso)
    REFERENCES pisos(id_piso)
);

CREATE TABLE registos_manutencao (
  id_maquina            varchar2(8),
  operacao              varchar2(500),
  data_hora_manutencao  date,
  tempo_gasto           varchar2(10),
  id_funcionario        varchar2(8),
  
  CONSTRAINT id_maquina_manut_pk
    FOREIGN KEY (id_maquina)
    REFERENCES maquinas(id_maquina),
  CONSTRAINT id_funcionario_manut_fk
    FOREIGN KEY (id_funcionario)
    REFERENCES funcionarios(id_funcionario)
);

CREATE TABLE modos_entrada (
  id_entrada      varchar2(4),
  modo_entrada    varchar2(100),
  
  CONSTRAINT modos_entrada_pk
    PRIMARY KEY (id_entrada)
);

CREATE TABLE clientes (
  id_cliente      varchar2(8),
  nome            varchar2(100),
  id_entrada      varchar2(4),
  matricula       varchar2(9),
  nib             varchar2(22),
  
  CONSTRAINT clientes_pk
    PRIMARY KEY (id_cliente),
  CONSTRAINT clientes_fk
     FOREIGN KEY (id_entrada)
     REFERENCES modos_entrada(id_entrada)
);


/*

insert into registos VALUES ('0001',to_date('2009-01-23 14:30','yyyy-mm-dd hh24:mi') , null,null,null);

SELECT to_char(data_hora_manutencao, 'hh24') FROM registos_manutencao;
SELECT to_char(data_hora_manutencao, 'ss') FROM registos_manutencao;

SELECT EXTRACT(YEAR FROM DATE) FROM registos;
SELECT EXTRACT(year FROM (SELECT data_entrada FROM registos )) ano FROM dual;
SELECT EXTRACT(month FROM (SELECT data_entrada FROM registos )) mes FROM dual;
*/
