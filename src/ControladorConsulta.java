import java.util.Scanner;

public class ControladorConsulta {
    private Repositorio repositorio;
    private Scanner scanner;

    public ControladorConsulta(Repositorio repositorio) {
        this.repositorio = repositorio;
        this.scanner = new Scanner(System.in);
    }

    public void adicionarConsulta() {
        try {
            System.out.print("Digite o CPF do paciente: ");
            String cpfPaciente = scanner.nextLine();
            System.out.print("Digite o CRM do médico: ");
            String crmMedico = scanner.nextLine();
            System.out.print("Digite a data da consulta: ");
            String dataConsulta = scanner.nextLine();
            System.out.print("Digite o horário da consulta: ");
            String horario = scanner.nextLine();
            System.out.print("Digite a descrição da consulta: ");
            String descricao = scanner.nextLine();

            if (!repositorio.buscarPaciente(cpfPaciente)) {
                throw new Exception("Erro: Paciente não encontrado.");
            }

            if (!repositorio.buscarMedico(crmMedico)) {
                throw new Exception("Erro: Médico não encontrado.");
            }

            Consulta consulta = new ConsultaMedica(
                    dataConsulta, horario, descricao,
                    repositorio.getMedicoPorCRM(crmMedico),
                    repositorio.getPacientePorCPF(cpfPaciente)
            );

            repositorio.adicionarConsulta(consulta);
            System.out.println("Consulta adicionada com sucesso!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void editarConsulta() {
        try {
            System.out.print("Digite o ID da consulta: ");
            String idConsulta = scanner.nextLine();
            System.out.print("Digite a nova data: ");
            String novaData = scanner.nextLine();
            System.out.print("Digite o novo horário: ");
            String novoHorario = scanner.nextLine();
            System.out.print("Digite a nova descrição: ");
            String novaDescricao = scanner.nextLine();

            repositorio.alterarConsulta(idConsulta, novaData, novoHorario, novaDescricao);
            System.out.println("Consulta alterada com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        }
    }
}
