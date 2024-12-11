public interface Pagamento {
    void realizarPagamento(double valor);
    void cancelarPagamento(String idPagamento);
    String gerarComprovante(String idPagamento);
}
