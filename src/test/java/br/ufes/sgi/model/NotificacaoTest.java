package br.ufes.sgi.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class NotificacaoTest {

    public NotificacaoTest() {
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
        int idEsperado = 1;
        Usuario usuarioEsperado = new Usuario(1, "rodolpho.rs", "123456", "Rodolpho", true);
        String descricaoEsperado = "Rodolpho foi cadastrado com sucesso";

        Notificacao notificacao = new Notificacao(idEsperado, usuarioEsperado, descricaoEsperado);

        assertEquals(idEsperado, notificacao.getId());
        assertEquals(usuarioEsperado, notificacao.getUsuario());
        assertEquals(descricaoEsperado, notificacao.getDescricao());

    }
}
