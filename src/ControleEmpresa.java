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
        // Adicionando uma mensagem de debug para identificar o problema
        System.out.println("Erro: Empresa '" + nomeEmpresa + "' não encontrada ou dados inválidos!");
        return null;
    }

    public Empresa buscarEmpresa(String nome){
        for(Empresa e : empresasCadastradas){
            if(e.nome.equals(nome)){  // Corrigido para usar equals em vez de ==
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
        if (empresa != null) {  // Adicionando verificação de null
            Funcionario funcionario = empresa.buscarFuncionario(cpf);
            if (funcionario != null) {  // Adicionando verificação de null
                funcionario.aplicarBonificacao(bonificacao);
            } else {
                System.out.println("Erro: Funcionário com CPF '" + cpf + "' não encontrado!");
            }
        } else {
            System.out.println("Erro: Empresa '" + nomeEmpresa + "' não encontrada!");
        }
    }

    public void listarEmpresas(){
        for (Empresa e : empresasCadastradas){
            System.out.println("Empresa: "+e.nome);
            System.out.println("Funcionarios: ");
            e.mostraTodosFuncionarios();
        }
    }

}
