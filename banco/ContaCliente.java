
//Marcos Adriano de Vasconcelos Gonçalves - 03318132
//Se Wan Pereira da Silva - 03317694


package banco;
import java.util.Scanner;

public class ContaCliente {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
         
        Cliente cliente1 = new Cliente("Marcos Vasconcelos", "999999999-99");
        Conta conta1 = new Conta(cliente1);

        Cliente cliente2 = new Cliente("Adriano Gonçalves", "888888888-88");
        Conta conta2 = new Conta(cliente2);

//        cliente1.mostraCliente();
//        conta1.mostraConta();
//
//        cliente2.mostraCliente();
//        conta2.mostraConta();

        int cliente = -1;
        while(cliente != 0){
            System.out.println("--------------------------------------");
            System.out.println("Escolha uma das opções a seguir: ");
            System.out.println(cliente1.getNomeCompleto() + " (1)");
            System.out.println(cliente2.getNomeCompleto() + " (2)");
            System.out.println("0 para sair");
            System.out.println("Escolha: ");
            cliente = in.nextInt();
            
            if (cliente == 1) {
                int escolha = -1;
                while (escolha != 0){
                    System.out.println("--------------------------------------");
                    System.out.println("Escolha uma das opções a seguir:");
                    System.out.println("Depositar (1)");
                    System.out.println("Sacar (2)");
                    System.out.println("Transferir (3)");
                    System.out.println("Extrato (4)");
                    System.out.println("Pix (5)");
                    System.out.println("Voltar (0)");
                    System.out.println("Escolha: ");
                    escolha = in.nextInt();
                    if (escolha == 1) {
                        System.out.println("Digite o valor a ser depositado: ");
                        double valorDeposito = in.nextDouble();
                        conta1.deposita(valorDeposito);
                    } else if (escolha == 2){
                        System.out.println("Digite o valor a ser sacado: ");
                        double valorSaque = in.nextDouble();
                        conta1.saca(valorSaque);
                    } else if (escolha == 3){
                        System.out.println("Digite o valor a ser tranferido");
                        double valorTransferencia = in.nextDouble();
                        System.out.println("--------------------------------------");
                        System.out.println("Transferindo para a conta de " + conta2.getCliente() + " ...");
                        conta1.transferePara(conta1, conta2, valorTransferencia);
                        conta1.mostraConta();
                        conta2.mostraConta();
                    } else if (escolha == 4){
                        System.out.println("Seu extrato: \n" + conta1.getExtrato()); 
                        System.out.println("Saldo atual: R$" + conta1.getSaldo());
                    } else if (escolha == 5){
                        System.out.println("Digite o valor do pix");
                        double valorPix = in.nextDouble();
                        System.out.println("Digite a chave pix: ");
                        String chavePix = in.next();
                        if (chavePix == cliente2.getCpf()) {
                            System.out.println("--------------------------------------");
                            System.out.println("Tranferência via pix para a conta de " + conta1.getCliente() + " ...");
                            conta1.pixPara(conta1, conta2, valorPix );
                            conta1.mostraConta();
                            conta2.mostraConta();
                        } else {
                            System.out.println("Chave inválida!");
                        }
                    } else if (escolha == 0){
                        System.out.println("Obrigado!");
                        break;
                    } else {
                        System.out.println("Opção inválida!");
                    }
                }
            } else if (cliente == 2){
                int escolha = -1;
                while (escolha != 0){
                    System.out.println("--------------------------------------");
                    System.out.println("Escolha uma das opções a seguir:");
                    System.out.println("Depositar (1)");
                    System.out.println("Sacar (2)");
                    System.out.println("Transferir (3)");
                    System.out.println("Extrato (4)");
                    System.out.println("Pix (5)");
                    System.out.println("Voltar (0)");
                    System.out.println("Escolha: ");
                    escolha = in.nextInt();
                    if (escolha == 1) {
                        System.out.println("Digite o valor a ser depositado: ");
                        double valorDeposito = in.nextDouble();
                        conta2.deposita(valorDeposito);
                    } else if (escolha == 2){
                        System.out.println("Digite o valor a ser sacado: ");
                        double valorSaque = in.nextDouble();
                        conta2.saca(valorSaque);
                    } else if (escolha == 3){
                        System.out.println("Digite o valor a ser tranferido");
                        double valorTransferencia = in.nextDouble();
                        System.out.println("Transferindo para a conta de " + conta1.getCliente() + " ...");
                        conta1.transferePara(conta2, conta1, valorTransferencia);
                    } else if (escolha == 4){
                        System.out.println("Seu extrato: \n" + conta2.getExtrato());
                        System.out.println("Saldo atual: R$" + conta2.getSaldo());
                    } else if( escolha == 5){
                        System.out.println("Digite o valor do pix");
                        double valorPix = in.nextDouble();
                        System.out.println("Digite a chave pix: ");
                        String chavePix = in.next();
                        if (chavePix == cliente1.getCpf()) {
                            System.out.println("--------------------------------------");
                            System.out.println("Tranferência via pix para a conta de " + conta1.getCliente() + " ...");
                            conta2.pixPara(conta2, conta1, valorPix );
                            conta1.mostraConta();
                            conta2.mostraConta();
                        } else {
                            System.out.println("Chave inválida!");
                        }
                    } else if (escolha == 0){
                        System.out.println("Obrigado!");
                        break;
                    } else {
                        System.out.println("Opção inválida!");
                    }
                }
            } else if (cliente == 0){
                System.out.println("Obrigado!");
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }
}
