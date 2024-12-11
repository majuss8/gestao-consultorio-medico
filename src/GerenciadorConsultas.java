import java.util.ArrayList;
import java.util.List;

public class GerenciadorConsultas implements GestaoConsultas {

    // Lista para armazenar as consultas
    private List<Consulta> consultas;

    public GerenciadorConsultas() {
        this.consultas = new ArrayList<>();
    }

    @Override
    public void agendarConsulta(String data, String horario, String descricao, Medico medico, Paciente paciente, boolean online, String linkVideo) {
        String idGerado = "C-" + (consultas.size() + 1); // Gerar um identificador único para a consulta.

        Consulta novaConsulta;

        // Definindo se é consulta presencial ou online
        if (online) {
            novaConsulta = new ConsultaOnline(data, horario, descricao, medico, paciente, linkVideo);
        } else {
            novaConsulta = new ConsultaPresencial(data, horario, descricao, medico, paciente);
        }

        consultas.add(novaConsulta);
        System.out.println("Consulta agendada com sucesso: " + novaConsulta);
    }

    @Override
    public void cancelarConsulta(String idConsulta) {
        for (int i = 0; i < consultas.size(); i++) {
            if (consultas.get(i).getId().equals(idConsulta)) {
                consultas.remove(i);
                System.out.println("Consulta cancelada com sucesso.");
                return;
            }
        }
        System.out.println("Consulta não encontrada.");
    }

    @Override
    public void visualizarConsultas() {
        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta encontrada.");
        } else {
            System.out.println("Lista de Consultas:");
            for (Consulta consulta : consultas) {
                System.out.println(consulta);
            }
        }
    }
}
