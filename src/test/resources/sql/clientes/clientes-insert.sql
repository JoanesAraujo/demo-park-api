insert into USUARIOS (id, username, password, role) values (100, 'joanescaraujo@gmail.com', '$2a$12$bLGCikJFKvpIjPOoffaYse3ri4bWv1h.8s2MLwRkNJgHFdRRQytfe', 'ROLE_ADMIN');
insert into USUARIOS (id, username, password, role) values (101, 'bia@gmail.com', '$2a$12$bLGCikJFKvpIjPOoffaYse3ri4bWv1h.8s2MLwRkNJgHFdRRQytfe', 'ROLE_CLIENTE');
insert into USUARIOS (id, username, password, role) values (102, 'edjane@gmail.com', '$2a$12$bLGCikJFKvpIjPOoffaYse3ri4bWv1h.8s2MLwRkNJgHFdRRQytfe', 'ROLE_CLIENTE');
insert into USUARIOS (id, username, password, role) values (103, 'virginia@gmail.com', '$2a$12$bLGCikJFKvpIjPOoffaYse3ri4bWv1h.8s2MLwRkNJgHFdRRQytfe', 'ROLE_CLIENTE');

insert into CLIENTES (id, nome, cpf, id_usuario) values (10, 'Bia Antunes', '34289253008', 101);
insert into CLIENTES (id, nome, cpf, id_usuario) values (20, 'Jesse Menezes', '08800720080', 102);