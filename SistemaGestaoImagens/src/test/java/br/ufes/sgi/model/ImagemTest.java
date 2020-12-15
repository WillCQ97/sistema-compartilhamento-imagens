package br.ufes.sgi.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImagemTest {

    public ImagemTest() {
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
        String caminhoEsperado = "C:\\Users\\55289\\Pictures\\dogs";

        Imagem imagem = new Imagem(1, "C:\\Users\\55289\\Pictures\\dogs");

        assertEquals(imagem, new Imagem(1, "C:\\Users\\55289\\Pictures\\dogs"));//verifica a instancia
        assertEquals(imagem.getCaminho(), caminhoEsperado);//verifica o caminho
        assertEquals(imagem.getId(), idEsperado);//verifica o id/verifica o caminho
    }

}
