package br.ufes.sgi.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

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

    @Test
    public void CT01() {
        int idEsperado = 1;
        String apelidoEsperado = "gabriel.kls";
        String senhaEsperado = "12345";
        String nomeEsperado = "Gabriel";
        boolean adminEsperado = true;
        Usuario usuario = new Usuario(idEsperado, apelidoEsperado, senhaEsperado, nomeEsperado, adminEsperado);

        assertEquals(idEsperado, usuario.getId());
        assertEquals(apelidoEsperado, usuario.getApelido());
        assertEquals(senhaEsperado, usuario.getSenha());
        assertEquals(nomeEsperado, usuario.getNome());
        assertEquals(adminEsperado, usuario.isAdmin());

    }
}
