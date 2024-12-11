import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Repositorio repositorio = new Repositorio();

        ControladorMedico controladorMedico = new ControladorMedico(repositorio);
        ControladorPaciente controladorPaciente = new ControladorPaciente(repositorio);
        ControladorConsulta controladorConsulta = new ControladorConsulta(repositorio);

        int opcao;

        do {
            System.out.println("\n--- Sistema de Gestão de Consultórios ---");
            System.out.println("1 - Cadastrar Médico");
            System.out.println("2 - Cadastrar Paciente");
            System.out.println("3 - Agendar Consulta");
            System.out.println("4 - Editar Consulta");
            System.out.println("5 - Listar Médicos");
            System.out.println("6 - Listar Pacientes");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (opcao) {
                    case 1:
                        controladorMedico.adicionarMedico();
                        break;
                    case 2:
                        controladorPaciente.adicionarPaciente();
                        break;
                    case 3:
                        controladorConsulta.adicionarConsulta();
                        break;
                    case 4:
                        controladorConsulta.editarConsulta();
                        break;
                    case 5:
                        controladorMedico.listarMedicos();
                        break;
                    case 6:
                        controladorPaciente.listarPacientes();
                        break;
                    case 0:
                        System.out.println("Saindo do sistema...");
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } catch (Exception e) {
                System.err.println("Erro: " + e.getMessage());
            }
        } while (opcao != 0);

        scanner.close();
    }
}
