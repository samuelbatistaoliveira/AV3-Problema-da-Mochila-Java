
import java.util.ArrayList;
import java.util.List;

public class MochilaRecursiva {

    // Armazena o resultado de uma solução.
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

    // Resolve o problema utilizando recursão ingênua.
    public static Resultado resolver(Item[] itens, int capacidade) {
        return calcular(itens, itens.length, capacidade);
    }

    private static Resultado calcular(Item[] itens, int n, int capacidade) {

        // Caso base: não existem itens ou não há capacidade.
        if (n == 0 || capacidade == 0) {
            return new Resultado(0, new ArrayList<>());
        }

        Item itemAtual = itens[n - 1];

        // Se o item não cabe, ele não pode ser escolhido.
        if (itemAtual.getPeso() > capacidade) {
            return calcular(itens, n - 1, capacidade);
        }

        // Opção 1: não incluir o item atual.
        Resultado semItem = calcular(itens, n - 1, capacidade);

        // Opção 2: incluir o item atual.
        Resultado anterior = calcular(
                itens,
                n - 1,
                capacidade - itemAtual.getPeso()
        );

        int valorComItem = anterior.getValorMaximo()
                + itemAtual.getValor();

        // Escolhe a alternativa com maior valor.
        if (valorComItem > semItem.getValorMaximo()) {
            List<Item> escolhidos = new ArrayList<>(
                    anterior.getItensEscolhidos()
            );

            escolhidos.add(itemAtual);

            return new Resultado(valorComItem, escolhidos);
        }

        return semItem;
    }
}
