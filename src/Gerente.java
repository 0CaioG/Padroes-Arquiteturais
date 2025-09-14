public class Gerente extends Funcionario{

    public Gerente(String nome, String cpf, Double salario) {
        super(nome, cpf, salario);
    }

    public void aplicarBonus(){
        super.salario = super.salario * 1.1;
        System.out.println("O salario alterado com o bonus agora é de: R$"+salario);
    }
}
