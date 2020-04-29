package com.fred.adivinha;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class NumerosAleatoriosUnitTest {
    @Test
    public void NumerosAleatorios_isCorrect() {
        for(int i=0; i < 10000000; i++) {
            int n = NumeroAleatorio.proximoNumero();

            assertTrue(n >= 1 && n <= 10);
        }
    }
}