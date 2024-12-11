import java.io.*;

public class GerenciadorArquivo implements Arquivo {

    @Override
    public void escreverArquivo(String caminho, String conteudo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminho))) {
            writer.write(conteudo);
            System.out.println("Conteúdo gravado no arquivo com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    @Override
    public String lerArquivo(String caminho) {
        StringBuilder conteudo = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(caminho))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                conteudo.append(linha).append("\n");
            }
            System.out.println("Conteúdo lido com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        return conteudo.toString();
    }
}
