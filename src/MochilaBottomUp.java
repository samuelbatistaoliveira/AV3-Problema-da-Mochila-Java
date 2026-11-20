
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MochilaBottomUp {

    // Representa o resultado final do algoritmo.
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

        // Calcula o peso total dos itens selecionados.
        public int getPesoTotal() {
            int pesoTotal = 0;

            for (Item item : itensEscolhidos) {
                pesoTotal += item.getPeso();
            }

            return pesoTotal;
        }
    }

    // Resolve o problema usando programação dinâmica Bottom-up.
    public static Resultado resolver(Item[] itens, int capacidade) {

        int n = itens.length;

        // Cria a tabela de programação dinâmica.
        int[][] tabela = new int[n + 1][capacidade + 1];

        // Preenche a tabela considerando cada item.
        for (int i = 1; i <= n; i++) {

            Item itemAtual = itens[i - 1];

            for (int w = 0; w <= capacidade; w++) {

                // Opção 1: não incluir o item.
                tabela[i][w] = tabela[i - 1][w];

                // Opção 2: incluir o item, caso ele caiba.
                if (itemAtual.getPeso() <= w) {

                    int valorComItem = itemAtual.getValor()
                            + tabela[i - 1][w - itemAtual.getPeso()];

                    // Armazena a alternativa de maior valor.
                    tabela[i][w] = Math.max(
                            tabela[i][w],
                            valorComItem
                    );
                }
            }
        }

        // Recupera os itens que formam a solução ótima.
        List<Item> escolhidos = new ArrayList<>();

        int capacidadeRestante = capacidade;

        for (int i = n; i > 0; i--) {

            Item itemAtual = itens[i - 1];

            // Inclui o item somente se melhorar o valor.
            if (itemAtual.getPeso() <= capacidadeRestante
                    && itemAtual.getValor()
                    + tabela[i - 1][capacidadeRestante
                    - itemAtual.getPeso()]
                    > tabela[i - 1][capacidadeRestante]) {

                escolhidos.add(itemAtual);

                // Atualiza a capacidade restante.
                capacidadeRestante -= itemAtual.getPeso();
            }
        }

        // Organiza os itens na ordem original.
        Collections.reverse(escolhidos);

        return new Resultado(
                tabela[n][capacidade],
                escolhidos
        );
    }
}
