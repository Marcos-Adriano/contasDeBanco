package banco;
public class Conta {
//    aux para auto incremento do numero da conta
    private static int id = 1;

    private int numero;
    private String cliente, extrato;
    private double saldo;

    public Conta(Cliente este){
        this.cliente = este.getNomeCompleto();
        this.numero = id++;
        this.saldo = 0;
        this.extrato ="";
    }

    public void mostraConta(){
        System.out.println("Número da conta: " + this.getNumero());
        System.out.println("Cliente: " + this.getCliente());
        System.out.println("Saldo: R$" + this.getSaldo());
        System.out.println("Extrato: " + this.getExtrato());
        System.out.println("--------------------------------------");
    }

    public int getNumero() {
        return this.numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCliente() {
        return this.cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getExtrato() {
        return this.extrato;
    }

    public void setExtrato(String extrato) {
        this.extrato = this.getExtrato() + extrato + "\n";
    }

    public void deposita(double valorDeposito) {
        if (this.getSaldo() + valorDeposito > 1000) {
            System.out.println("limite de saldo ultrapassado! (R$1.000,00), tente novamente");
            System.out.println("--------------------------------------");
        } else {
            this.setSaldo(this.getSaldo() + valorDeposito);
            System.out.println("Depósito realizado com sucesso na conta de " + this.getCliente());
            this.setExtrato("Depósito: R$" + valorDeposito);
            System.out.println("--------------------------------------");
        }  
    }

    public void saca(double valorSaque){
        if (this.getSaldo() >= valorSaque) {
                this.setSaldo(this.getSaldo() - valorSaque);
                System.out.println("Saque realizado com sucesso da conta de " + this.getCliente());
                this.setExtrato("Saque: R$" + valorSaque);
                System.out.println("--------------------------------------");
            } else {
                System.out.println("Saldo insuficiente para saque");
                System.out.println("--------------------------------------");
            }
    }

    public void transferePara(Conta de, Conta para, double valorTransferido){
        if (de.getSaldo() - (valorTransferido)*0.01 - valorTransferido < 0) {
            System.out.println("Saldo insuficiente para tranferência -> Saldo: R$" + de.getSaldo());
            System.out.println("Taxa de transferência: " + valorTransferido*0.01);
            System.out.println("Saldo mínimo desejado: " + (valorTransferido*0.01 + valorTransferido));
            System.out.println("--------------------------------------");
        } else {
            if (para.getSaldo() + valorTransferido > 1000) {
                System.out.println("Limite de R$1.000,00 da conta de " + para.getCliente() + " excedido, tente novamente");
                System.out.println("--------------------------------------");
            } else {
                de.setSaldo(de.getSaldo() - valorTransferido - (valorTransferido)*0.01);
                para.setSaldo(para.getSaldo() + valorTransferido);
                System.out.println("Tranferência realizada com sucesso!");
                de.setExtrato("Tranferência de R$ " + valorTransferido + " para " + para.getCliente() + "\n");
                de.setExtrato("Taxa de transferência : R$" + (valorTransferido)*0.01 + "\n");
                para.setExtrato("Tranferência recebida de R$ " + valorTransferido + " de " + de.getCliente() + "\n");
                System.out.println("--------------------------------------");
                }
        }
    }

    public void pixPara(Conta de, Conta para, double valorTransferido){
        if (de.getSaldo() - valorTransferido < 0) {
            System.out.println("Saldo insuficiente para tranferência -> Saldo: R$" + de.getSaldo());
            System.out.println("--------------------------------------");
        } else {
            if (para.getSaldo() + valorTransferido > 1000) {
                System.out.println("Limite de R$1.000,00 da conta de " + para.getCliente() + " excedido, tente novamente");
                System.out.println("--------------------------------------");
            } else {
                de.setSaldo(de.getSaldo() - valorTransferido);
                para.setSaldo(para.getSaldo() + valorTransferido);
                System.out.println("Pix realizado com sucesso!");
                de.setExtrato("Pix de R$ " + valorTransferido + " para " + para.getCliente() + "\n");
                para.setExtrato("Pix recebido de R$ " + valorTransferido + " de " + de.getCliente() + "\n");
                System.out.println("--------------------------------------");
            }
        }
    }
}