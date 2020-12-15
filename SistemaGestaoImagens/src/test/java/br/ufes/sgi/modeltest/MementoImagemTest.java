/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.sgi.modeltest;

import br.ufes.sgi.memento.ZeladorImagem;
import br.ufes.sgi.model.Imagem;
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
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
