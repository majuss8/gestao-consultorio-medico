public interface GestaoConsultas {
    void agendarConsulta(String data, String horario, String descricao, Medico medico, Paciente paciente, boolean online, String linkVideo);
    void cancelarConsulta(String idConsulta);
    void visualizarConsultas();
}