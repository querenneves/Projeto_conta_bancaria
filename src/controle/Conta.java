package controle;

import interfaces.IConta;
import javax.swing.*;
import modelo.Cliente;

public abstract class Conta implements IConta {
    private static int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;
    private static final double LIMITE_PADRAO = 3000;

    // Conta Poupança
    protected double rendimentos;
    // Conta Corrente
    protected double debitos;
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;
    protected double limiteEmprestimo;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = Conta.SEQUENCIAL++;
        this.saldo = saldo;
        this.cliente = cliente;
        this.limiteEmprestimo =  LIMITE_PADRAO;
    }

    @Override
    public void sacar(double valor) {
        saldo -= valor;
        if(saldo < 0){
            JOptionPane.showMessageDialog(null, "Saldo Insuficiente");
            saldo += valor;
        }

    }

    @Override
    public void depositar(double valor) {
        saldo += valor;

    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);

    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    protected void imprimirInfosComuns(){
        System.out.println(String.format("Cliente: %s", this.cliente.getNome()));
        System.out.println(String.format("Agência: %d", this.agencia));
        System.out.println(String.format("Num Conta: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));

    }
}
