import java.util.HashMap;
import java.util.Map;

public class Repositorio {
    private Map<String, Medico> medicos;
    private Map<String, Paciente> pacientes;
    private Map<String, Consulta> consultas;

    public Repositorio() {
        medicos = new HashMap<>();
        pacientes = new HashMap<>();
        consultas = new HashMap<>();
    }

    public void adicionarMedico(Medico medico) throws Exception {
        if (medicos.containsKey(medico.getCrm())) {
            throw new Exception("Erro: Médico já cadastrado no sistema.");
        }
        medicos.put(medico.getCrm(), medico);
    }

    public boolean buscarMedico(String crm) {
        return medicos.containsKey(crm);
    }

    public Medico getMedicoPorCRM(String crm) {
        return medicos.getOrDefault(crm, null);
    }

    public boolean excluirMedico(String crm) throws Exception {
        if (!medicos.containsKey(crm)) {
            throw new Exception("Erro: Médico não encontrado.");
        }
        medicos.remove(crm);
        return true;
    }

    public void listarMedicos() {
        if (medicos.isEmpty()) {
            System.out.println("Nenhum médico cadastrado.");
        } else {
            medicos.values().forEach(System.out::println);
        }
    }

    public boolean buscarPaciente(String cpf) {
        return pacientes.containsKey(cpf);
    }

    public Paciente getPacientePorCPF(String cpf) throws Exception {
        if (!pacientes.containsKey(cpf)) {
            throw new Exception("Erro: Paciente não encontrado.");
        }
        return pacientes.get(cpf);
    }

    public void adicionarPaciente(Paciente paciente) throws Exception {
        if (pacientes.containsKey(paciente.getCpf())) {
            throw new Exception("Erro: Paciente já cadastrado no sistema.");
        }
        pacientes.put(paciente.getCpf(), paciente);
    }

    public void adicionarConsulta(Consulta consulta) throws Exception {
        if (consultas.containsKey(consulta.getId())) {
            throw new Exception("Erro: Consulta já existe no sistema.");
        }
        consultas.put(consulta.getId(), consulta);
        System.out.println("Consulta adicionada com sucesso.");
    }

    public void alterarConsulta(String idConsulta, String novaData, String novoHorario, String novaDescricao) throws Exception {
        if (!consultas.containsKey(idConsulta)) {
            throw new Exception("Erro: Consulta não encontrada.");
        }

        Consulta consulta = consultas.get(idConsulta);
        consulta.setData(novaData);
        consulta.setHorario(novoHorario);
        consulta.setDescricao(novaDescricao);

        System.out.println("Consulta alterada com sucesso.");
    }

    public void listarPacientes() {
        if (pacientes.isEmpty()) {
            System.out.println("Nenhum paciente cadastrado.");
        } else {
            pacientes.values().forEach(System.out::println);
        }
    }

    /**
     * Atualiza as informações de um paciente no sistema.
     */
    public void atualizarPaciente(Paciente paciente) {
        if (pacientes.containsKey(paciente.getCpf())) {
            pacientes.put(paciente.getCpf(), paciente);
            System.out.println("Paciente atualizado com sucesso.");
        } else {
            System.out.println("Erro: Paciente não encontrado no sistema.");
        }
    }

    /**
     * Remove um paciente pelo CPF do sistema.
     * Retorna true se a operação foi bem-suced, false caso o paciente não exista.
     */
    public boolean removerPacientePorCPF(String cpf) {
        if (pacientes.containsKey(cpf)) {
            pacientes.remove(cpf);
            System.out.println("Paciente removido com sucesso.");
            return true;
        } else {
            System.out.println("Erro: Paciente não encontrado no sistema.");
            return false;
        }
    }
}
