INSERT INTO aplicativos (id, descricao) VALUES (1, 'App 1');
INSERT INTO aplicativos (id, descricao) VALUES (2, 'App 2');
INSERT INTO aplicativos (id, descricao) VALUES (3, 'App 3');
INSERT INTO aplicativos (id, descricao) VALUES (4, 'App 4');

INSERT INTO clientes (id, name, email) VALUES (1, 'Cliente 1', 'cliente1@email.com');
INSERT INTO clientes (id, name, email) VALUES (2, 'Cliente 2', 'cliente2@email.com');
INSERT INTO clientes (id, name, email) VALUES (3, 'Cliente 3', 'cliente3@email.com');
INSERT INTO clientes (id, name, email) VALUES (4, 'Cliente 4', 'cliente4@email.com');

INSERT INTO assinaturas (id, id_aplicativo, id_cliente, data_inicio, data_fim) VALUES (1, 1, 1, '2024-01-01', '2024-12-01');