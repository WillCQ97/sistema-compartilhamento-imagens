package br.ufes.sgi.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PermissaoTest {

    public PermissaoTest() {
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
    public void CT03() {
        int idEsperado = 1;
        Usuario usuarioEsperado = new Usuario(2, "gabriel.kls", "1234", "Gabriel", true);
        Imagem imagemEsperado = new Imagem(5, "C:\\Users\\55289\\Pictures\\dogs\\dog1.png");
        boolean visualizarEsperado = false;
        boolean excluirEsperado = false;
        boolean compartilharEsperado = false;
        Permissao permissao = new Permissao(idEsperado, usuarioEsperado, imagemEsperado, visualizarEsperado, excluirEsperado, compartilharEsperado);

        assertEquals(idEsperado, permissao.getId());
        assertEquals(usuarioEsperado.getId(), permissao.getUsuario().getId());
        assertEquals(imagemEsperado.getId(), permissao.getImagem().getId());
        assertEquals(visualizarEsperado, permissao.isVisualizar());
        assertEquals(compartilharEsperado, permissao.isCompartilhar());
        assertEquals(excluirEsperado, permissao.isExcluir());
    }
}
