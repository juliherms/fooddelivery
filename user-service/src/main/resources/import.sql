INSERT INTO `user` (username,password,enabled,name,email) VALUES ('juliherms','12345',1,'Juliherms Vasconcelos','juliherms321@gmail.com');
INSERT INTO `user` (username,password,enabled,name,email) VALUES ('usuario','12345',1,'usuario teste','usuario@gmail.com');

INSERT INTO `role` (name) VALUES ('ROLE_USER');
INSERT INTO `role` (name) VALUES ('ROLE_ADMIN');

INSERT INTO `usuarios_roles` (user_id,role_id) VALUES (1,1);
INSERT INTO `usuarios_roles` (user_id,role_id) VALUES (2,2);
INSERT INTO `usuarios_roles` (user_id,role_id) VALUES (2,1);
