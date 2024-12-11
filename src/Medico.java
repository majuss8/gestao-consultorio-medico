public class Medico extends Usuario {
    private String especialidade;
    private String crm;

    public Medico(String cpf, String nome, String telefone, String dataNascimento, String endereco, String especialidade, String crm) {
        super(cpf, nome, telefone, dataNascimento, endereco);
        this.especialidade = especialidade;
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getCrm() {
        return crm;
    }

    @Override
    public void fazerLogin() {
        System.out.println("Login realizado com sucesso pelo médico: " + getNome());
    }

    @Override
    public void fazerCadastro() {
        System.out.println("Cadastro realizado com sucesso para o médico: " + getNome());
    }

    @Override
    public void exibirInformacoes() {
        System.out.println("Informações do Médico:");
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Especialidade: " + especialidade);
        System.out.println("CRM: " + crm);
    }

    @Override
    public String toString() {
        return "Médico [Nome: " + getNome() + ", CPF: " + getCpf() + ", Especialidade: " + especialidade + ", CRM: " + crm + "]";
    }
}
