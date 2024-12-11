public abstract class Consulta {
    // Contador estático para gerar IDs únicos
    private static int contadorId = 1;

    private String id;
    private String dataConsulta;
    private String horario;
    private String descricao;
    private Medico medico;
    private Paciente paciente;

    public Consulta(String dataConsulta, String horario, String descricao, Medico medico, Paciente paciente) {
        this.id = String.valueOf(contadorId++); // Gera um ID único
        this.dataConsulta = dataConsulta;
        this.horario = horario;
        this.descricao = descricao;
        this.medico = medico;
        this.paciente = paciente;
    }

    // Métodos Getters
    public String getId() {
        return id;
    }

    public String getData() {
        return dataConsulta;
    }

    public String getHorario() {
        return horario;
    }

    public String getDescricao() {
        return descricao;
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    // Métodos Setters (Adicionados para manipulação dinâmica)
    public void setData(String novaData) {
        this.dataConsulta = novaData;
    }

    public void setHorario(String novoHorario) {
        this.horario = novoHorario;
    }

    public void setDescricao(String novaDescricao) {
        this.descricao = novaDescricao;
    }

    // Método abstrato
    public abstract void confirmarConsulta();

    @Override
    public String toString() {
        return "Consulta [ID: " + id + ", Data: " + dataConsulta + ", Horário: " + horario +
                ", Descrição: " + descricao + ", Médico: " + medico.getNome() +
                ", Paciente: " + paciente.getNome() + "]";
    }
}
