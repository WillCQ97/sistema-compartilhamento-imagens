package br.ufes.sgi.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SolicitacaoTest {

    public SolicitacaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void CT01() {
        int idEsperado1 = 1;
        String usuarioEsperado1 = "gabriel.kls";
        String senhaEsperado1 = "12345";
        String nomeEsperado1 = "Gabriel";
        boolean adminEsperado1 = true;
        Usuario usuario1 = new Usuario(idEsperado1, usuarioEsperado1, senhaEsperado1, nomeEsperado1, adminEsperado1);

        int idEsperado2 = 5;
        String usuarioEsperado2 = "gabriel.kls";
        String senhaEsperado2 = "12345";
        String nomeEsperado2 = "Gabriel";
        boolean adminEsperado2 = true;
        Usuario admin1 = new Usuario(idEsperado2, usuarioEsperado2, senhaEsperado2, nomeEsperado2, adminEsperado2);

        int idEsperadoImagem = 1;
        String caminhoEsperado = "C:\\Users\\55289\\Pictures\\dogs";

        Imagem imagem = new Imagem(1, "C:\\Users\\55289\\Pictures\\dogs");

        String descricaoEsperada = "Solicitacao para visualizar";
        int idEsperadoSolicitacao = 5;

        Solicitacao solicitacao = new Solicitacao(idEsperadoSolicitacao, usuario1, admin1, imagem, descricaoEsperada);

        assertEquals(idEsperadoSolicitacao, solicitacao.getId());
        assertEquals(idEsperado1, solicitacao.getUsuarioSolicitante().getId());
        assertEquals(idEsperadoImagem, solicitacao.getImagem().getId());
        assertEquals(idEsperado2, solicitacao.getAdminSolicitado().getId());
        assertEquals(descricaoEsperada, solicitacao.getDescricao());
        assertEquals(imagem.getCaminho(), caminhoEsperado);

    }
}
