package com.fred.adivinha;

import java.util.Random;

public class NumeroAleatorio {
    private static Random random = new Random();
    //public int numeroAdivinhar = random.nextInt(10) + 1;


    /**
     *
     * @return devolve um numero etre 1 e 10 // basta fazer /** e ele cria este pedaco de comentario
     */
    public static int proximoNumero() {
        return random.nextInt(10) + 1; // fica mais facil
    }
}
