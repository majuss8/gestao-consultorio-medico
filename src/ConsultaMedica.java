public class ConsultaMedica extends Consulta {
    public ConsultaMedica(String dataConsulta, String horario, String descricao, Medico medico, Paciente paciente) {
        super(dataConsulta, horario, descricao, medico, paciente);
    }

    @Override
    public void confirmarConsulta() {
        System.out.println("Consulta confirmada para o paciente " + getPaciente().getNome() +
                " com o médico " + getMedico().getNome() +
                " na data " + getData() + " às " + getHorario() + ".");
    }
}
