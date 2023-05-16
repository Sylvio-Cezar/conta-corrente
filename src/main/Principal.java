package main;
import models.ContaCorrente;

public class Principal {

    public static void main(String[] args) {
        ContaCorrente conta = new ContaCorrente("Sylvio", "999.999.999-99", "0123456789");

        System.out.println(conta.getTitular());

        System.out.println(conta.getSaldo());

        conta.depositar(100);

        System.out.println(conta.getSaldo());

        conta.sacar(200);

        System.out.println(conta.getSaldo());
        System.out.println(conta.getLimiteChequeEspecialAtual());
    }

}