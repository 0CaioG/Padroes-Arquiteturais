public class Gerente extends Funcionario{

    public Gerente(String nome, String cpf, Double salario) {
        super(nome, cpf, salario);
    }
    @Override
    public void aplicarBonificacao(Double porcentgem){
        super.salario += super.salario * porcentgem;
        System.out.println("O salario alterado com o bonus agora é de: R$"+salario);
    }
}
