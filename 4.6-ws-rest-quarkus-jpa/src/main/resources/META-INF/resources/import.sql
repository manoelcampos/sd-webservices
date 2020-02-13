insert into Cidade (nome, uf) values ("Palmas", "TO");
insert into Cidade (nome, uf) values ("Paraiso", "TO");
insert into Cidade (nome, uf) values ("Porto Nacional", "TO");

insert into Cliente (dataCadastro, nome) values (current_date(), "Manoel");
insert into Cliente (dataCadastro, nome) values (current_date(), "Raysa");
insert into Cliente (dataCadastro, nome) values (current_date(), "Breno");

insert into Endereco (logradouro, cidade_id, cliente_id) values ("310 Sul", 1, 1);

insert into Usuario (cpf, nome, cidade_id) values ("11111111111", "Maria", 1);
insert into Usuario (cpf, nome, cidade_id) values ("22222222222", "Joao", 2);
insert into Usuario (cpf, nome, cidade_id) values ("33333333333", "Ana", 1);
insert into Usuario (cpf, nome, cidade_id) values ("44444444444", "Helder", 3);