package program;

public class Conta implements SistemaConta {
    private String nome;
    private String cpf;
    private String numBanco;
    private String numConta;
    private double saldo;

    public Conta(String nome, String cpf, String numBanco, String numConta, double saldo) {
        this.nome = nome;
        this.cpf = cpf;
        this.numBanco = numBanco;
        this.numConta = numConta;
        this.saldo = saldo;
    }
    public Conta(String nome, String numBanco, String numConta) {
        this.nome = nome;
        this.numBanco = numBanco;
        this.numConta = numConta;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumBanco() {
        return numBanco;
    }

    public void setNumBanco(String numBanco) {
        this.numBanco = numBanco;
    }

    public String getNumConta() {
        return numConta;
    }

    public void setNumConta(String numConta) {
        this.numConta = numConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String debitar(double valor) {
        if(valor > this.saldo){
            return "não é possivel fazer essa operação, saldo insuficiente: " + getSaldo();
        }
        this.saldo = saldo - valor;
        return "Seu saldo atual agora é: "+ getSaldo();
    }

    @Override
    public void creditar(double valor) {
        this.saldo = saldo + valor;

    }
}
