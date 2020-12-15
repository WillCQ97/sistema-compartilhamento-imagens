/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.sgi.modeltest;

import br.ufes.sgi.model.Imagem;
import br.ufes.sgi.model.Permissao;
import br.ufes.sgi.model.Usuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 55289
 */
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
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
