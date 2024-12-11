import java.util.Scanner;

public class ControladorPagamento {
    private GerenciadorPagamento gerenciadorPagamento;
    private Scanner scanner;

    public ControladorPagamento() {
        this.gerenciadorPagamento = new GerenciadorPagamento();
        this.scanner = new Scanner(System.in);
    }

    public void realizarPagamento() {
        try {
            System.out.print("Digite o valor do pagamento: ");
            double valor = Double.parseDouble(scanner.nextLine());
            gerenciadorPagamento.realizarPagamento(valor);
        } catch (NumberFormatException e) {
            System.err.println("Erro: Digite um número válido.");
        } catch (PagamentoInvalidoException e) {
            System.err.println(e.getMessage());
        }
    }

    public void cancelarPagamento() {
        try {
            System.out.print("Digite o ID do pagamento a ser cancelado: ");
            String idPagamento = scanner.nextLine();
            gerenciadorPagamento.cancelarPagamento(idPagamento);
        } catch (ConsultaNaoEncontradaException e) {
            System.err.println(e.getMessage());
        }
    }

    public void listarPagamentos() {
        if (gerenciadorPagamento.getPagamentos().isEmpty()) {
            System.out.println("Nenhum pagamento encontrado.");
        } else {
            System.out.println("Pagamentos:");
            gerenciadorPagamento.getPagamentos().forEach((id, valor) ->
                    System.out.println("ID: " + id + " | Valor: R$ " + valor)
            );
        }
    }
}
