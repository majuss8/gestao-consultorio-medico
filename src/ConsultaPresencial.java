public class ConsultaPresencial extends Consulta {

    public ConsultaPresencial(String dataConsulta, String horario, String descricao, Medico medico, Paciente paciente) {
        super(dataConsulta, horario, descricao, medico, paciente);
    }

    @Override
    public void confirmarConsulta() {
        System.out.println("Consulta presencial confirmada entre " + getMedico().getNome() + " e " + getPaciente().getNome());
    }

    @Override
    public String toString() {
        return super.toString() + " (Presencial)";
    }
}
