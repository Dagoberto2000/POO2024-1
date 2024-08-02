package program;

public class ContaEmpresarial extends Conta implements SistemaConta{
    private String cnpj;
    private double saldoEmpresa;
    public ContaEmpresarial(String nome, String cnpj, String numBanco, String numConta, double saldoEmpresa) {
        super(nome, numBanco, numConta);
        this.cnpj = cnpj;
        this.saldoEmpresa = saldoEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public void creditar(double valor) {
        this.saldoEmpresa = saldoEmpresa + valor;
    }

    @Override
    public String debitar(double valor) {
        this.saldoEmpresa = saldoEmpresa - valor;
        return "seu saldo é: " + getSaldo();
    }
}
