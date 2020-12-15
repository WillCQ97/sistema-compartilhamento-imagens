package br.ufes.sgi.model;

import br.ufes.sgi.memento.ZeladorImagem;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MementoImagemTest {

    public MementoImagemTest() {
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
    public void CT06() throws Exception {
        Imagem imagem = new Imagem(1, "C:\\Users\\55289\\Pictures\\dogs");
        ZeladorImagem zelador = ZeladorImagem.getInstancia();
        zelador.add(imagem.criar());

        Imagem imagemGuardada = new Imagem();
        imagemGuardada.restaurar(zelador.getUltimo());

        assertEquals(imagemGuardada.getId(), imagem.getId());
        assertEquals(imagemGuardada.getCaminho(), imagem.getCaminho());

    }
}
