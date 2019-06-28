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
