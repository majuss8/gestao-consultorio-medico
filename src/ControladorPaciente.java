import java.util.Scanner;

public class ControladorPaciente {
    private Repositorio repositorio;
    private Scanner scanner;

    public ControladorPaciente(Repositorio repositorio) {
        this.repositorio = repositorio; // Recebendo repositório no construtor
        this.scanner = new Scanner(System.in);
    }

    public void adicionarPaciente() throws Exception {
        System.out.print("Digite o nome do paciente: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite o telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Digite a Data de Nascimento: ");
        String dataNascimento = scanner.nextLine();
        System.out.print("Digite o Endereço: ");
        String endereco = scanner.nextLine();
        System.out.print("Digite o Histórico Médico caso tiver: ");
        String historicoMedico = scanner.nextLine();

        Paciente paciente = new Paciente(cpf, nome, telefone, dataNascimento, endereco, historicoMedico);
        repositorio.adicionarPaciente(paciente);
        System.out.println("Paciente adicionado com sucesso!");
    }

    public void listarPacientes() {
        repositorio.listarPacientes();
    }

    public void editarPaciente() throws Exception {
        System.out.print("Digite o CPF do paciente a ser editado: ");
        String cpf = scanner.nextLine();

        Paciente paciente = null;
        try {
            paciente = repositorio.getPacientePorCPF(cpf);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (paciente != null) {
            System.out.print("Digite o novo nome: ");
            String novoNome = scanner.nextLine();
            System.out.print("Digite o novo telefone: ");
            String novoTelefone = scanner.nextLine();
            System.out.print("Digite o novo endereço: ");
            String novoEndereco = scanner.nextLine();
            System.out.print("Digite a nova data de nascimento: ");
            String novaDataNascimento = scanner.nextLine();

            paciente.setNome(novoNome);
            paciente.setTelefone(novoTelefone);
            paciente.setEndereco(novoEndereco);
            paciente.setDataNascimento(novaDataNascimento);

            repositorio.atualizarPaciente(paciente);
            System.out.println("Paciente atualizado com sucesso!");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }

    public void excluirPaciente() throws Exception {
        System.out.print("Digite o CPF do paciente a ser excluído: ");
        String cpf = scanner.nextLine();

        if (repositorio.removerPacientePorCPF(cpf)) {
            System.out.println("Paciente removido com sucesso!");
        } else {
            System.out.println("Paciente não encontrado.");
        }
    }
}
