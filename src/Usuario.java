public abstract class Usuario extends Pessoa {
    // Construtor
    public Usuario(String cpf, String nome, String telefone, String dataNascimento, String endereco) {
        super(cpf, nome, telefone, dataNascimento, endereco);
    }

    // Métodos abstratos
    public abstract void fazerLogin();

    public abstract void fazerCadastro();
}