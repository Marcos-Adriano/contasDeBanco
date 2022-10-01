package banco;

public class Cliente {
    private String nomeCompleto;
    private String cpf;

    public Cliente(String nomeCompleto, String cpf) {
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
    }
    
    public void mostraCliente(){
        System.out.println("Nome Completo: " + this.getNomeCompleto());
        System.out.println("CPF: " + this.getCpf());
        System.out.println("--------------------------------------");
    }

    public String getNomeCompleto() {
        return this.nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    } 
}
