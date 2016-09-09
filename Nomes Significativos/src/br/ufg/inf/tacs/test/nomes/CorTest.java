package br.ufg.inf.tacs.test.nomes;

import br.ufg.inf.tacs.nomes.Cor;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pablo on 09/09/16.
 */
public class CorTest {
    @Test
    public void testAPartirDeRGB8Bits() throws Exception {
        Cor cor = Cor.aPartirDeRGB8Bits(243, 255, 1);
        assertEquals(243, cor.getNivelDeVermelho());
        assertEquals(255, cor.getNivelDeVerde());
        assertEquals(1, cor.getNivelDeAzul());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAPartirDeRGB8BitsComDigitoMaiorDoQue255() throws Exception {
        Cor cor = Cor.aPartirDeRGB8Bits(243, 255, 256);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAPartirDeRGB8BitsComDigitoMenorDoQueZero() throws Exception {
        Cor cor = Cor.aPartirDeRGB8Bits(243, -1, 12);
    }

    @Test
    public void testAPartirDeStringHexadecimalRGB() throws Exception {
        Cor branco = Cor.aPartirDeStringHexadecimalRGB("#ffffff");
        assertEquals(255, branco.getNivelDeVermelho());
        assertEquals(255, branco.getNivelDeVerde());
        assertEquals(255, branco.getNivelDeAzul());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAPartirDeStringHexadecimalRGBSemJogoDaVelha() throws Exception {
        Cor cor = Cor.aPartirDeStringHexadecimalRGB("ff4432");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAPartirDeStringHexadecimalRGBDigitosInvalidos() throws Exception {
        Cor cor = Cor.aPartirDeStringHexadecimalRGB("fg4432");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAPartirDeStringHexadecimalRGBMuitosDigitos() throws Exception {
        Cor cor = Cor.aPartirDeStringHexadecimalRGB("#00ff4432");
    }

    @Test
    public void testComoHexadecimalRGB() throws Exception {
        Cor branco = Cor.aPartirDeRGB8Bits(255, 255, 255);
        assertEquals("#ffffff", branco.comoHexadecimalRGB());
    }

}