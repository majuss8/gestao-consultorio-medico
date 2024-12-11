public abstract class Pessoa {
    // Atributos
    private String cpf;
    private String nome;
    private String telefone;
    private String dataNascimento;
    private String endereco;

    // Construtor
    public Pessoa(String cpf, String nome, String telefone, String dataNascimento, String endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
    }

    // Getters e Setters
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    // Método abstrato para exibir informações
    public abstract void exibirInformacoes();

    // Método para atualizar os dados
    public void atualizarDados(String nome, String telefone, String dataNascimento, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        System.out.println("Dados atualizados com sucesso!");
    }
}
