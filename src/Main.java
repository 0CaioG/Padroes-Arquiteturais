import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ControleEmpresa controle = new ControleEmpresa();

    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("SISTEMA DE GESTÃO DE EMPRESAS");
        System.out.println("=================================");
        
        int opcao;
        do {
            exibirMenu();
            opcao = lerOpcao();
            executarOpcao(opcao);
        } while (opcao != 0);
        
        System.out.println("Sistema encerrado!");
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("1. Cadastrar Empresa");
        System.out.println("2. Listar Empresas");
        System.out.println("3. Remover Empresa");
        System.out.println("4. Cadastrar Funcionário");
        System.out.println("5. Demitir Funcionário");
        System.out.println("6. Bonificar Funcionário");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao() {
        try {
            String input = scanner.nextLine();
            return Integer.parseInt(input);
        } catch (Exception e) {
            return -1;
        }
    }

    private static void executarOpcao(int opcao) {
        // Removido scanner.nextLine() daqui pois já está sendo tratado em lerOpcao()

        switch (opcao) {
            case 1:
                cadastrarEmpresa();
                break;
            case 2:
                listarEmpresas();
                break;
            case 3:
                removerEmpresa();
                break;
            case 4:
                cadastrarFuncionario();
                break;
            case 5:
                demitirFuncionario();
                break;
            case 6:
                bonificarFuncionario();
                break;
            case 0:
                System.out.println("Encerrando sistema...");
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void cadastrarEmpresa() {
        System.out.println("\n--- CADASTRO DE EMPRESA ---");
        System.out.print("Nome da empresa: ");
        String nome = scanner.nextLine();
        
        Empresa empresa = controle.cadastrarEmpresa(nome);
        if (empresa != null) {
            System.out.println("Empresa '" + nome + "' cadastrada com sucesso!");
        }
    }

    private static void listarEmpresas() {
        System.out.println("\n--- LISTA DE EMPRESAS ---");
        controle.listarEmpresas();
    }

    private static void removerEmpresa() {
        System.out.println("\n--- REMOVER EMPRESA ---");
        System.out.print("Nome da empresa a remover: ");
        String nome = scanner.nextLine();
        
        if (controle.removerEmpresa(nome)) {
            System.out.println("Empresa removida com sucesso!");
        } else {
            System.out.println("Empresa não encontrada!");
        }
    }

    private static void cadastrarFuncionario() {
        System.out.println("\n--- CADASTRO DE FUNCIONÁRÍO ---");
        
        System.out.print("Nome da empresa: ");
        String nomeEmpresa = scanner.nextLine();
        
        System.out.print("Nome do funcionário: ");
        String nome = scanner.nextLine();
        
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        
        System.out.print("Salário: R$ ");
        Double salario = scanner.nextDouble();
        scanner.nextLine();
        
        System.out.println("Tipo de funcionário:");
        System.out.println("1 - Gerente");
        System.out.println("2 - Empregado");
        System.out.print("Escolha: ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        try {
            Funcionario funcionario = controle.cadastrarFuncionarioEmpresa(nomeEmpresa, tipo, nome, cpf, salario);
            if (funcionario != null) {
                System.out.println("Funcionário cadastrado com sucesso!");
            } else {
                System.out.println("Erro ao cadastrar funcionário! Verifique se a empresa existe.");
            }
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void demitirFuncionario() {
        System.out.println("\n--- DEMITIR FUNCIONÁRIO ---");
        System.out.print("Nome da empresa: ");
        String nomeEmpresa = scanner.nextLine();
        
        System.out.print("CPF do funcionário: ");
        String cpf = scanner.nextLine();
        
        if (controle.demitirFuncionarioEmpresa(nomeEmpresa, cpf)) {
            System.out.println("Funcionário demitido com sucesso!");
        } else {
            System.out.println("Funcionário ou empresa não encontrados!");
        }
    }

    private static void bonificarFuncionario() {
        System.out.println("\n--- BONIFICAR FUNCIONÁRIO ---");
        System.out.print("Nome da empresa: ");
        String nomeEmpresa = scanner.nextLine();
        
        System.out.print("CPF do funcionário: ");
        String cpf = scanner.nextLine();
        
        System.out.print("Valor da bonificação: ");
        Double bonificacao = scanner.nextDouble();
        scanner.nextLine();
        
        controle.bonificarFuncionario(nomeEmpresa, cpf, bonificacao);
    }
}