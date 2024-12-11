public interface Arquivo {
    // Métodos para leitura e escrita de arquivos

    void escreverArquivo(String caminho, String conteudo);
    String lerArquivo(String caminho);
}