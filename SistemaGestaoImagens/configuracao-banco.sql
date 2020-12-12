DROP TABLE IF EXISTS usuario;
CREATE TABLE usuario (idUsuario INTEGER PRIMARY KEY AUTOINCREMENT, nome STRING, usuario STRING, senha STRING, admin BOOLEAN);
INSERT INTO usuario VALUES (1, 'Gabriel', 'gabriel', 'admin123', true);
INSERT INTO usuario VALUES (2, 'Willian', 'willcq', 'random', false);

DROP TABLE IF EXISTS notificacao;
CREATE TABLE notificacao (idNotificacao INTEGER PRIMARY KEY AUTOINCREMENT, descricao STRING, idUsuario INTEGER);

DROP TABLE IF EXISTS imagem;
CREATE TABLE imagem (idImagem INTEGER PRIMARY KEY AUTOINCREMENT, caminho STRING);

DROP TABLE IF EXISTS permissao;
CREATE TABLE permissao (idUsuario INTEGER, idImagem INTEGER, visualizar BOOLEAN, excluir BOOLEAN, compartilhar BOOLEAN);
