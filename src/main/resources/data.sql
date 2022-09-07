INSERT INTO USUARIO(nome, email, senha) VALUES ('Aluno', 'aluno@email.com',
'$2a$10$MlsKgypPexnXnIloFKF3bu1NUAgXJfFmQ.TZjeElGcVc3IqpNXqze');

INSERT INTO CURSO(nome, categoria) VALUES ('Spring Boot', 'Programação');
INSERT INTO CURSO(nome, categoria) VALUES ('HTML 5', 'Front-end');
INSERT INTO CURSO(nome, categoria) VALUES ('Vega 8', 'Edição de Videos');
INSERT INTO CURSO(nome, categoria) VALUES ('NodeJS', 'Programação');
INSERT INTO CURSO(nome, categoria) VALUES ('Angula', 'Front-end');

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id)
    VALUES ('Dúvida 1', 'Minha dúvida 1', '2022-05-15 09:58:50.22222+3', 'NAO_RESPONDIDO', '1', '1');
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id)
    VALUES ('Dúvida 2', 'Minha dúvida 2', '2022-05-15 09:58:50.22222', 'NAO_RESPONDIDO', '1', '2');
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id)
    VALUES ('Dúvida 3', 'Minha dúvida 3', '2022-05-15 09:58:50.22222-3', 'NAO_RESPONDIDO', '1', '3');
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id)
    VALUES ('Dúvida 4', 'Minha dúvida 4', '2022-05-15 09:58:50.22222+1', 'NAO_RESPONDIDO', '1', '1');
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, curso_id)
    VALUES ('Dúvida 5', 'Minha dúvida 5', '2022-05-15 09:58:50.22222-1', 'NAO_RESPONDIDO', '1', '2');