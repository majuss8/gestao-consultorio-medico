import java.util.HashMap;
import java.util.Map;

public class GerenciadorPagamento {

    private Map<String, Double> pagamentos;

    public GerenciadorPagamento() {
        pagamentos = new HashMap<>();
    }

    public void realizarPagamento(double valor) throws PagamentoInvalidoException {
        if (valor <= 0) {
            throw new PagamentoInvalidoException("Erro: Valor do pagamento deve ser maior que zero.");
        }

        String idPagamento = "P-" + (pagamentos.size() + 1);
        pagamentos.put(idPagamento, valor);
        System.out.println("Pagamento realizado com sucesso. ID: " + idPagamento);
    }

    public void cancelarPagamento(String idPagamento) throws ConsultaNaoEncontradaException {
        if (!pagamentos.containsKey(idPagamento)) {
            throw new ConsultaNaoEncontradaException("Erro: Pagamento não encontrado.");
        }

        pagamentos.remove(idPagamento);
        System.out.println("Pagamento cancelado com sucesso.");
    }

    public Map<String, Double> getPagamentos() {
        return pagamentos;
    }
}
