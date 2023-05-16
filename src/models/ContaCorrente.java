package models;

import java.util.Random;

public class ContaCorrente {
    private String titular;
    private double saldo;
    private double valor_em_juizo;
    private String cpf;
    private String cartao;
    private String senha;
    private double cheque_especial;
    private double limite_cartao;
    private double limite_cheque_especial;
    private int numero;
    private String agencia;
    private String[] chave_pix;
    private String[] extrato;
    private double juros_cheque = .2;

    public ContaCorrente(String titular, String cpf, String senha) {
        this.titular = titular;
        this.cpf = cpf;
        this.senha = senha;
        this.saldo = 0;
        this.valor_em_juizo = 0;
        this.limite_cheque_especial = 500;
        this.cheque_especial = 0;
        this.limite_cartao = 0;

        this.agencia = "0001";
        this.numero = (1000000 % new Random().nextInt()) + 1000;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public String getTitular() {
        return this.titular + "[" + this.cpf + "]";
    }

    public double getLimiteChequeEspecialTotal() {
        return this.limite_cheque_especial;
    }

    public double getLimiteChequeEspecialAtual() {
        return this.cheque_especial;
    }

    public void depositar(double valor) {
        if(this.saldo < 0) {
            valor += this.saldo * (this.juros_cheque);
            this.cheque_especial += (valor - (this.saldo*-1));
        }

        this.saldo += valor;

        if (valor_em_juizo > 0) {
            valor_em_juizo -= valor;
        }
    }

    public void sacar(double valor) {
        // verificar se o saldo + cheque permite o saque
        if(this.saldo + this.cheque_especial >= valor) {
            if(this.saldo < valor) {
                this.cheque_especial -= (valor - this.saldo);
            }

            this.saldo -= valor;
        }else {
            System.out.println("Não pode sacar");
        }
    }

    public void transferir(String agencia, int conta, double valor) {
        if(this.saldo + this.cheque_especial >= valor) {
            if(this.saldo < valor) {
                this.cheque_especial -= (valor - this.saldo);
            }

            this.saldo -= valor;
        }else {
            System.out.println("Não pode transferir");
        }
    }

    public void transferirPix(String pix, double valor) {
        if(this.saldo + this.cheque_especial >= valor) {
            if(this.saldo < valor) {
                this.cheque_especial -= (valor - this.saldo);
            }

            this.saldo -= valor;
        }else {
            System.out.println("Não pode transferir");
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }
}