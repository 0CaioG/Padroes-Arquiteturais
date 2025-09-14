public class Empregado extends Funcionario{

    public Empregado(String nome, String cpf, Double salario) {
        super(nome, cpf, salario);
    }

    public void aplicarComissao(Double comissao){
        salario = salario+comissao;
        System.out.println("O novo salario com a comissão aplicada é de: R$"+salario);
    }
}
