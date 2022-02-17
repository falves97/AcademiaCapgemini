package test;

import app.Utils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UtilsTest {

    @Test
    public void deveSerUmaEscadaDeTamanho6() {
        String escadaBase =     "     *\n" +
                                "    **\n" +
                                "   ***\n" +
                                "  ****\n" +
                                " *****\n" +
                                "******";

        String escadaComp = Utils.escada(6);
        Assertions.assertEquals(escadaBase, escadaComp);
    }

    @Test
    public void deveLancarUmaException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Utils.escada(-1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Utils.escada(0));
    }

    @Test
    public void deveRetornarQueFalta4CaracteresPraSenhaSerForte() {
        Assertions.assertEquals(4, Utils.senhaForte("```"));
    }

    @Test
    public void deveRetornarQueFalta3CaracteresPraSenhaSerForte() {
        Assertions.assertEquals(3, Utils.senhaForte("Ya3"));
        Assertions.assertEquals(3, Utils.senhaForte("YC4"));
        Assertions.assertEquals(3, Utils.senhaForte("YCDADA"));
        Assertions.assertEquals(3, Utils.senhaForte("hfhfhf"));
    }

    @Test
    public void deveRetornarQueFalta2CaracteresPraSenhaSerForte() {
        Assertions.assertEquals(2, Utils.senhaForte("Ya3a"));
        Assertions.assertEquals(2, Utils.senhaForte("Yaffa"));
    }

    @Test
    public void deveRetornarQueFalta1CaracteresPraSenhaSerForte() {
        Assertions.assertEquals(1, Utils.senhaForte("Ya3&a"));
    }

    @Test
    public void deveRetornar0() {
        Assertions.assertEquals(0, Utils.senhaForte("Ya3&aa"));
    }

    @Test
    public void deveRetornarONumeroDeAnagramasIgualA3() {
        Assertions.assertEquals(2, Utils.anagramas("ovo"));
        Assertions.assertEquals(3, Utils.anagramas("ifailuhkqq"));
    }
}
