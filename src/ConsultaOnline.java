public class ConsultaOnline extends Consulta {

    private String linkVideo; // Link para a chamada de vídeo

    public ConsultaOnline(String dataConsulta, String horario, String descricao, Medico medico, Paciente paciente, String linkVideo) {
        super(dataConsulta, horario, descricao, medico, paciente);
        this.linkVideo = linkVideo;
    }

    @Override
    public void confirmarConsulta() {
        System.out.println("Consulta online confirmada entre " + getMedico().getNome() + " e " + getPaciente().getNome() +
                ". Acesse pelo link: " + linkVideo);
    }

    @Override
    public String toString() {
        return super.toString() + " (Online) - Link: " + linkVideo;
    }
}
