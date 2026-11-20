
import java.util.ArrayList;
import java.util.List;

public class MochilaTopDown {

    // Armazena o valor máximo e os itens selecionados.
    public static class Resultado {
        private final int valorMaximo;
        private final List<Item> itensEscolhidos;

        public Resultado(int valorMaximo, List<Item> itensEscolhidos) {
            this.valorMaximo = valorMaximo;
            this.itensEscolhidos = itensEscolhidos;
        }

        public int getValorMaximo() {
            return valorMaximo;
        }

        public List<Item> getItensEscolhidos() {
            return itensEscolhidos;
        }

        public int getPesoTotal() {
            int pesoTotal = 0;

            for (Item item : itensEscolhidos) {
                pesoTotal += item.getPeso();
            }

            return pesoTotal;
        }
    }

    // Inicia a resolução com uma tabela de memoização.
    public static Resultado resolver(Item[] itens, int capacidade) {

        Resultado[][] memo =
                new Resultado[itens.length + 1][capacidade + 1];

        return calcular(itens, itens.length, capacidade, memo);
    }

    private static Resultado calcular(
            Item[] itens,
            int n,
            int capacidade,
            Resultado[][] memo) {

        // Caso base: sem itens ou sem capacidade disponível.
        if (n == 0 || capacidade == 0) {
            return new Resultado(0, new ArrayList<>());
        }

        // Reutiliza o resultado se já foi calculado.
        if (memo[n][capacidade] != null) {
            return memo[n][capacidade];
        }

        Item itemAtual = itens[n - 1];
        Resultado melhorResultado;

        // Se o item não cabe, ele é descartado.
        if (itemAtual.getPeso() > capacidade) {
            melhorResultado = calcular(
                    itens, n - 1, capacidade, memo
            );

        } else {

            // Opção 1: não incluir o item.
            Resultado semItem = calcular(
                    itens, n - 1, capacidade, memo
            );

            // Opção 2: incluir o item.
            Resultado anterior = calcular(
                    itens,
                    n - 1,
                    capacidade - itemAtual.getPeso(),
                    memo
            );

            int valorComItem =
                    anterior.getValorMaximo() + itemAtual.getValor();

            if (valorComItem > semItem.getValorMaximo()) {

                List<Item> escolhidos = new ArrayList<>(
                        anterior.getItensEscolhidos()
                );

                escolhidos.add(itemAtual);

                melhorResultado = new Resultado(
                        valorComItem, escolhidos
                );

            } else {
                melhorResultado = semItem;
            }
        }

        // Salva o resultado para evitar cálculos repetidos.
        memo[n][capacidade] = melhorResultado;

        return melhorResultado;
    }
}
