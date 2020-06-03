insert into Cidade (nome, uf) values ("Palmas", "TO"), ("Araguaina", "TO"), ("Gurupi", "TO"), ("Porto Nacional", "TO");
insert into Usuario (cpf, nome, cidade_id) values ("11111111111", "Manoel", 1), ("22222222222", "Maria", 1), ("33333333333", "Raimundo", 2);
insert into Cliente (nome) values ("Jose"), ("Pedro"), ("Rosana");
insert into Endereco (logradouro, cidade_id, cliente_id) values ("Rua 1", 1, 1), ("Rua 1", 1, 2), ("Rua 2", 2, 3);