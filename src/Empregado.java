public class Empregado extends Funcionario{

    public Empregado(String nome, String cpf, Double salario) {
        super(nome, cpf, salario);
    }

    @Override
    public void aplicarBonificacao(Double comissao){
        salario = salario+comissao;
        System.out.println("O novo salario com a comissão aplicada é de: R$"+salario);
    }
}
