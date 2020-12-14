DROP TABLE IF EXISTS usuario;
CREATE TABLE usuario (idUsuario INTEGER PRIMARY KEY AUTOINCREMENT, usuario STRING, senha STRING, nome STRING, admin BOOLEAN);

DROP TABLE IF EXISTS notificacao;
CREATE TABLE notificacao (idNotificacao INTEGER PRIMARY KEY AUTOINCREMENT, descricao STRING, idUsuario INTEGER);

DROP TABLE IF EXISTS imagem;
CREATE TABLE imagem (idImagem INTEGER PRIMARY KEY AUTOINCREMENT, caminho STRING);
INSERT INTO imagem VALUES (1, '~/Imagens/papéis-de-parede/amazing-space-nasa.jpg');

DROP TABLE IF EXISTS permissao;
CREATE TABLE permissao (idPermissao INTEGER PRIMARY KEY AUTOINCREMENT, idUsuario INTEGER, idImagem INTEGER, compartilhar BOOLEAN, excluir BOOLEAN, visualizar BOOLEAN);
INSERT INTO permissao VALUES (1, 1, 1, 1, 1, 1);
