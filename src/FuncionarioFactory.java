public class FuncionarioFactory {

    public Funcionario criarFuncionario(int tipo, String cpf, String nome, Double salario){
        if(tipo == 1){
            Gerente g = new Gerente(nome,cpf,salario);
            return g;
        }else {
            Empregado e = new Empregado(nome,cpf,salario);
            return e;
        }
    }
}
