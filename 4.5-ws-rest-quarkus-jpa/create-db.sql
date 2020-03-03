drop database if exists cadastro_rest;
create database cadastro_rest;
use cadastro_rest;

CREATE TABLE `Cidade` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `uf` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

CREATE TABLE `Cliente` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dataCadastro` date DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `Endereco` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `logradouro` varchar(255) DEFAULT NULL,
  `cidade_id` bigint(20) DEFAULT NULL,
  `cliente_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKsq6fa88clryv3uqsbgvva4fne` (`cidade_id`),
  KEY `FK5xgtdcjgh43ld8p50nrnkibku` (`cliente_id`),
  CONSTRAINT `FK5xgtdcjgh43ld8p50nrnkibku` FOREIGN KEY (`cliente_id`) REFERENCES `Cliente` (`id`),
  CONSTRAINT `FKsq6fa88clryv3uqsbgvva4fne` FOREIGN KEY (`cidade_id`) REFERENCES `Cidade` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

CREATE TABLE `Usuario` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cpf` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `cidade_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK44rheunl1yevdmlj08i369a3x` (`cidade_id`),
  CONSTRAINT `FK44rheunl1yevdmlj08i369a3x` FOREIGN KEY (`cidade_id`) REFERENCES `Cidade` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

insert into Cidade (id, nome, uf) values (1, "Palmas", "TO");
insert into Cidade (id, nome, uf) values (2, "Araguaina", "TO");
insert into Cidade (id, nome, uf) values (3, "Gurupi", "TO");
insert into Cidade (id, nome, uf) values (4, "4Porto Nacional", "TO");

insert into Usuario (id, cpf, nome, cidade_id) values (1, "11111111111", "Manoel", 1);
insert into Usuario (id, cpf, nome, cidade_id) values (2, "22222222222", "Maria", 1);
insert into Usuario (id, cpf, nome, cidade_id) values (3, "33333333333", "Raimundo", 2);

insert into Cliente (id, nome) values (1, "Jose");
insert into Cliente (id, nome) values (2, "Pedro");
insert into Cliente (id, nome) values (3, "Rosana");

insert into Endereco (logradouro, cidade_id, cliente_id) values ("Rua 1", 1, 1);
insert into Endereco (logradouro, cidade_id, cliente_id) values ("Rua 1", 1, 2);
insert into Endereco (logradouro, cidade_id, cliente_id) values ("Rua 2", 2, 3);

