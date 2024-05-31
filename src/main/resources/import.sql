INSERT INTO aplicativos (id, nome, custo_mensal) VALUES (1, 'App 1', 200.00);
INSERT INTO aplicativos (id, nome, custo_mensal) VALUES (2, 'App 2', 150.00);
INSERT INTO aplicativos (id, nome, custo_mensal) VALUES (3, 'App 3', 50.00);
INSERT INTO aplicativos (id, nome, custo_mensal) VALUES (4, 'App 4', 2.00);

INSERT INTO clientes (id, nome, email) VALUES (1, 'Cliente 1', 'cliente1@email.com');
INSERT INTO clientes (id, nome, email) VALUES (2, 'Cliente 2', 'cliente2@email.com');
INSERT INTO clientes (id, nome, email) VALUES (3, 'Cliente 3', 'cliente3@email.com');
INSERT INTO clientes (id, nome, email) VALUES (4, 'Cliente 4', 'cliente4@email.com');

INSERT INTO assinaturas (id, id_aplicativo, id_cliente, inicio_vigencia, fim_vigencia) VALUES (1, 1, 1, '2024-01-01', '2024-12-01');
INSERT INTO assinaturas (id, id_aplicativo, id_cliente, inicio_vigencia, fim_vigencia) VALUES (2, 1, 1, '2024-01-01', '2024-02-01');
INSERT INTO assinaturas (id, id_aplicativo, id_cliente, inicio_vigencia, fim_vigencia) VALUES (3, 1, 2, '2024-01-01', '2024-12-01');