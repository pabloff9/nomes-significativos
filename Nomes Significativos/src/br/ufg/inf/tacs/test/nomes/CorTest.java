package br.ufg.inf.tacs.test.nomes;

import br.ufg.inf.tacs.nomes.Cor;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pablo on 09/09/16.
 */
public class CorTest {
    @Test
    public void aPartirDeRGB8Bits() throws Exception {
        Cor cor = Cor.aPartirDeRGB8Bits(243, 255, 1);
        Assert.assertEquals(243, cor.getNivelDeVermelho());
        Assert.assertEquals(255, cor.getNivelDeVerde());
        Assert.assertEquals(1, cor.getNivelDeAzul());
    }

    @Test
    public void aPartirDeStringHexadecimalRGB() throws Exception {

    }

    @Test
    public void comoHexadecimalRGB() throws Exception {

    }

}