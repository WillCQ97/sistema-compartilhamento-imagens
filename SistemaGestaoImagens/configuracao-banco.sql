DROP TABLE IF EXISTS usuario;
CREATE TABLE usuario (idUsuario INTEGER PRIMARY KEY AUTOINCREMENT, usuario STRING, senha STRING, nome STRING, admin BOOLEAN);
INSERT INTO usuario VALUES (1, 'gabriel', 'admin123', 'Gabriel', true);
INSERT INTO usuario VALUES (2, 'willcq', 'random', 'Willian', false);

DROP TABLE IF EXISTS notificacao;
CREATE TABLE notificacao (idNotificacao INTEGER PRIMARY KEY AUTOINCREMENT, descricao STRING, idUsuario INTEGER);

DROP TABLE IF EXISTS imagem;
CREATE TABLE imagem (idImagem INTEGER PRIMARY KEY AUTOINCREMENT, caminho STRING);

DROP TABLE IF EXISTS permissao;
CREATE TABLE permissao (idUsuario INTEGER, idImagem INTEGER, visualizar BOOLEAN, excluir BOOLEAN, compartilhar BOOLEAN);
