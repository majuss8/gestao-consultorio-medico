import java.util.Scanner;

public class ControladorMedico {
    private Repositorio repositorio;
    private Scanner scanner;

    public ControladorMedico(Repositorio repositorio) {
        this.repositorio = repositorio; // Repositório é injetado aqui.
        this.scanner = new Scanner(System.in);
    }

    public void adicionarMedico() {
        try {
            System.out.print("Digite o nome do(a) Médico(a): ");
            String nome = scanner.nextLine();
            System.out.print("Digite o CPF: ");
            String cpf = scanner.nextLine();
            System.out.print("Digite o telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("Digite a Data de Nascimento: ");
            String dataNascimento = scanner.nextLine();
            System.out.print("Digite o Endereço: ");
            String endereco = scanner.nextLine();
            System.out.print("Digite a especialidade: ");
            String especialidade = scanner.nextLine();
            System.out.print("Digite o CRM: ");
            String crm = scanner.nextLine();

            // Checar se o CRM ou CPF já existe no repositório
            if (repositorio.buscarMedico(crm)) {
                throw new Exception("Erro: CRM já cadastrado no sistema.");
            }

            if (repositorio.buscarPaciente(cpf)) {
                throw new Exception("Erro: CPF já cadastrado no sistema.");
            }

            Medico medico = new Medico(cpf, nome, telefone, dataNascimento, endereco, especialidade, crm);
            repositorio.adicionarMedico(medico);
            System.out.println("Médico adicionado com sucesso!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void listarMedicos() {
        try {
            repositorio.listarMedicos();
        } catch (Exception e) {
            System.err.println("Erro ao listar médicos: " + e.getMessage());
        }
    }

    public void editarMedico() {
        try {
            System.out.print("Digite o CRM do médico a ser editado: ");
            String crm = scanner.nextLine();

            Medico medico = repositorio.getMedicoPorCRM(crm);
            if (medico != null) {
                System.out.print("Digite o novo nome: ");
                medico.setNome(scanner.nextLine());
                System.out.print("Digite o novo telefone: ");
                medico.setTelefone(scanner.nextLine());
                System.out.print("Digite a nova Data de Nascimento: ");
                medico.setDataNascimento(scanner.nextLine());
                System.out.print("Digite o novo endereco: ");
                medico.setEndereco(scanner.nextLine());
                System.out.println("Médico atualizado com sucesso!");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void excluirMedico() {
        try {
            System.out.print("Digite o CRM do médico a ser excluído: ");
            String crm = scanner.nextLine();
            repositorio.excluirMedico(crm);
            System.out.println("Médico removido com sucesso!");
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
