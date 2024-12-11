public class Paciente extends Usuario {
    private String historicoMedico;

    public Paciente(String cpf, String nome, String telefone, String dataNascimento, String endereco, String historicoMedico) {
        super(cpf, nome, telefone, dataNascimento, endereco);
        this.historicoMedico = historicoMedico;
    }

    public String getHistoricoMedico() {
        return historicoMedico;
    }

    @Override
    public void fazerLogin() {
        System.out.println("Login realizado com sucesso pelo paciente: " + getNome());
    }

    @Override
    public void fazerCadastro() {
        System.out.println("Cadastro realizado com sucesso para o paciente: " + getNome());
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Informações do Paciente:");
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Histórico Médico: " + historicoMedico);
    }

    @Override
    public String toString() {
        return "Paciente [Nome: " + getNome() + ", CPF: " + getCpf() + ", Histórico Médico: " + historicoMedico + "]";
    }
}
