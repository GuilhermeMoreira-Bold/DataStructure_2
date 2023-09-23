package src.controller;

public class Movimentacoes {
    private static int vezesMovimentado;

    public static int getVezesMovimentado() {
        return vezesMovimentado;
    }

    public static void movimentou() {
        Movimentacoes.vezesMovimentado++;
    }

}
