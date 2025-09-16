import java.util.ArrayList;

public class Empresa {
    public ArrayList<Funcionario> funcionarios;
    public String nome;

    public Empresa(String nome) {
        this.funcionarios = new ArrayList<>();
        this.nome = nome;
    }
    public void adicionarFuncionario(Funcionario f){
        funcionarios.add(f);
    }

    public boolean alterarFuncionario(String cpf, String nome, Double salario){
        for(Funcionario f: funcionarios){
            if(f.getCpf() == cpf){
                f.setNome(nome);
                f.setSalario(salario);
                return true;
            }
        }
        return false;
    }

    public boolean removerFuncionario(String cpf){
        for(Funcionario f: funcionarios){
            if(f.getCpf() == cpf){
                funcionarios.remove(f);
                return true;
            }
        }
        return false;
    }

    public void mostraTodosFuncionarios(){
        for(Funcionario f: funcionarios){
            f.mostrarFuncionario();
        }
    }

    public Funcionario buscarFuncionario(String cpf){
        for (Funcionario f : funcionarios){
            if(f.cpf == cpf){
                return  f;
            }
        }
        return null;
    }

}
