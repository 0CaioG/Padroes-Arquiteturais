import java.util.ArrayList;

public class ControleEmpresa {
    public FuncionarioFactory fabrica;
    ArrayList<Empresa> empresasCadastradas;


    public ControleEmpresa(){
        fabrica = new FuncionarioFactory();
        empresasCadastradas = new ArrayList<>();
    }

    public Empresa cadastrarEmpresa(String nome){
        Empresa novaEmpresa = new Empresa(nome);
        empresasCadastradas.add(novaEmpresa);
        return novaEmpresa;
    }

    public Funcionario cadastrarFuncionarioEmpresa(String nomeEmpresa , int tipoFuncionario, String nome, String cpf, Double salario){
        Empresa empresa = buscarEmpresa(nomeEmpresa);
        if(empresa != null){
            Funcionario novoFuncionario = fabrica.criarFuncionario(tipoFuncionario,cpf,nome,salario);
            empresa.adicionarFuncionario(novoFuncionario);
            return novoFuncionario;
        }
        return null;
    }

    public Empresa buscarEmpresa(String nome){
        for(Empresa e : empresasCadastradas){
            if(e.nome == nome){
                return e;
            }
        }
        return null;
    }

    public boolean demitirFuncionarioEmpresa(String nomeEmpresa, String cpf){
        Empresa empresa = buscarEmpresa(nomeEmpresa);
        if(empresa!= null){
            return empresa.removerFuncionario(cpf);
        }
        return false;
    }

    public boolean removerEmpresa(String nome){
        Empresa empresa = buscarEmpresa(nome);
        if(empresa != null){
            empresasCadastradas.remove(empresa);
            return true;
        }
        return false;
    }

    public void bonificarFuncionario(String nomeEmpresa, String cpf, Double bonificacao){
        Empresa empresa = buscarEmpresa(nomeEmpresa);
        Funcionario funcionario = empresa.buscarFuncionario(cpf);
        funcionario.aplicarBonificacao(bonificacao);
    }

    public void listarEmpresas(){
        for (Empresa e : empresasCadastradas){
            System.out.println("Empresa: "+e.nome);
            System.out.println("Funcionarios: ");
            e.mostraTodosFuncionarios();
        }
    }

}
