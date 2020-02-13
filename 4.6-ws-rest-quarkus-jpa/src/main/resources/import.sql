insert into Cidade (id, nome, uf) values (1, 'Palmas', 'TO');
insert into Cidade (id, nome, uf) values (2, 'Paraiso', 'TO');
insert into Cidade (id, nome, uf) values (3, 'Porto Nacional', 'TO');

insert into Cliente (id, dataCadastro, nome) values (1, current_date(), 'Manoel');
insert into Cliente (id, dataCadastro, nome) values (2, current_date(), 'Raysa');
insert into Cliente (id, dataCadastro, nome) values (3, current_date(), 'Breno');

insert into Endereco (id, logradouro, cidade_id, cliente_id) values (1, '310 Sul', 1, 1);

insert into Usuario (id, cpf, nome, cidade_id) values (1, '11111111111', 'Maria', 1);
insert into Usuario (id, cpf, nome, cidade_id) values (2, '22222222222', 'Joao', 2);
insert into Usuario (id, cpf, nome, cidade_id) values (3, '33333333333', 'Ana', 1);
insert into Usuario (id, cpf, nome, cidade_id) values (4, '44444444444', 'Helder', 3);