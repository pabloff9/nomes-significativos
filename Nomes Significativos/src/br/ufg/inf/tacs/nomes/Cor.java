package br.ufg.inf.tacs.nomes;

/**
 * Created by pablo on 09/09/16.
 */
public class Cor {

    public int getNivelDeVermelho() {
        return nivelDeVermelho;
    }

    public int getNivelDeVerde() {
        return nivelDeVerde;
    }

    public int getNivelDeAzul() {
        return nivelDeAzul;
    }

    private int nivelDeVermelho;
    private int nivelDeVerde;
    private int nivelDeAzul;

    private Cor(int vermelho, int verde, int azul) {
        this.nivelDeVermelho = vermelho;
        this.nivelDeVerde = verde;
        this.nivelDeAzul = azul;
    }

    public static Cor aPartirDeRGB8Bits(int vermelho, int verde, int azul) {
        if (estaForaDaFaixa8bits(vermelho) || estaForaDaFaixa8bits(verde)
                || estaForaDaFaixa8bits(azul)) {
            throw new IllegalArgumentException("Os níveis de verde, azul e vermelho devem estar entre 0 e 255.");
        }
        return new Cor(vermelho, verde, azul);
    }

    public static Cor aPartirDeStringHexadecimalRGB(String hexadecimalRGB) {
        if (!hexadecimalRGB.startsWith("#") || hexadecimalRGB.length() != 7 ||
                contemDigitosInvalidos(hexadecimalRGB)) {
            throw new IllegalArgumentException("A string RGB deve estar no formato #ff3500");
        } else {
            String porcaoDoVermelho = hexadecimalRGB.substring(1, 3);
            int nivelDeVermelho = Integer.parseInt(porcaoDoVermelho, 16);

            String porcaoDoVerde = hexadecimalRGB.substring(3, 5);
            int nivelDeVerde = Integer.parseInt(porcaoDoVerde, 16);

            String porcaoDoAzul = hexadecimalRGB.substring(5);
            int nivelDeAzul = Integer.parseInt(porcaoDoAzul);

            return new Cor(nivelDeVermelho, nivelDeVerde, nivelDeAzul);
        }
    }

    private static boolean contemDigitosInvalidos(String hexadecimalRGB) {

        String digitosHexadecimaisValidos =  "0123456789abcdefABCDEF#";

        for (char caractere: hexadecimalRGB.toCharArray()) {
            if (digitosHexadecimaisValidos.indexOf(caractere) == -1) {
                return true;
            }
        }

        return false;

    }

    public String comoHexadecimalRGB() {
        return "#" + Integer.toHexString(this.nivelDeVermelho) +
                Integer.toHexString(this.nivelDeVerde) +
                Integer.toHexString(this.nivelDeAzul);
    }

    private static boolean estaForaDaFaixa8bits(int valorDaCor) {
        return valorDaCor < 0 || valorDaCor > 255;
    }

}
