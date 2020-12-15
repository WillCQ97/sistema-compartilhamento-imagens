/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.sgi.model;

import br.ufes.sgi.model.Notificacao;
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void CT02() {
        int idEsperado = 1;
        Usuario usuarioEsperado = new Usuario(1, "rodolpho.rs", "123456", "Rodolpho", true);
        String descricaoEsperado = "Rodolpho foi cadastrado com sucesso";

        Notificacao notificacao = new Notificacao(idEsperado, usuarioEsperado, descricaoEsperado);

        assertEquals(idEsperado, notificacao.getId());
        assertEquals(usuarioEsperado, notificacao.getUsuario());
        assertEquals(descricaoEsperado, notificacao.getDescricao());

    }
}
