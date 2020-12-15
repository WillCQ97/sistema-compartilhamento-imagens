/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.sgi.modeltest;

import br.ufes.sgi.model.Imagem;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author 55289
 */
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void CT01() {

        int idEsperado = 1;
        String caminhoEsperado = "C:\\Users\\55289\\Pictures\\dogs";

        Imagem imagem = new Imagem(1, "C:\\Users\\55289\\Pictures\\dogs");

        assertEquals(imagem, new Imagem(1, "C:\\Users\\55289\\Pictures\\dogs"));//verifica a instancia
        assertEquals(imagem.getCaminho(), caminhoEsperado);//verifica o caminho
        assertEquals(imagem.getId(), idEsperado);//verifica o id
    }

}
