/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.sgi.modeltest;

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
public class UsuarioTest {

    public UsuarioTest() {
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
    public void CT04() {
        int idEsperado = 1;
        String usuarioEsperado = "gabriel.kls";
        String senhaEsperado = "12345";
        String nomeEsperado = "Gabriel";
        boolean adminEsperado = true;
        Usuario usuario = new Usuario(idEsperado, usuarioEsperado, senhaEsperado, nomeEsperado, adminEsperado);

        assertEquals(idEsperado, usuario.getId());
        assertEquals(usuarioEsperado, usuario.getUsuario());
        assertEquals(senhaEsperado, usuario.getSenha());
        assertEquals(nomeEsperado, usuario.getNome());
        assertEquals(adminEsperado, usuario.isAdmin());

    }
}
