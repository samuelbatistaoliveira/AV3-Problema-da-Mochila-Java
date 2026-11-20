
public class Main {
    public static void main(String[] args) {

        // Itens obrigatórios do problema da mochila
        Item[] itens = {
                new Item("Lanterna", 2, 6),
                new Item("Barraca", 4, 10),
                new Item("Faca", 1, 3),
                new Item("Cobertor", 3, 7),
                new Item("Cantil", 2, 5),
                new Item("Mapa", 1, 4),
                new Item("Corda", 5, 9)
        };

        // Capacidades exigidas pelo professor
        int[] capacidades = {6, 10, 15};

        // ==========================================
        // VERSÃO A - RECURSÃO INGÊNUA
        // ==========================================

        System.out.println("=== RECURSÃO INGÊNUA ===");

        for (int capacidade : capacidades) {

            MochilaRecursiva.Resultado resultado =
                    MochilaRecursiva.resolver(itens, capacidade);

            System.out.println("\nCapacidade: " + capacidade);
            System.out.println("Valor máximo: "
                    + resultado.getValorMaximo());
            System.out.println("Peso total: "
                    + resultado.getPesoTotal());

            System.out.println("Itens escolhidos:");

            for (Item item : resultado.getItensEscolhidos()) {
                System.out.println("- " + item.getNome());
            }
        }

        // ==========================================
        // VERSÃO B - TOP-DOWN COM MEMOIZAÇÃO
        // ==========================================

        System.out.println("\n=== TOP-DOWN ===");

        for (int capacidade : capacidades) {

            MochilaTopDown.Resultado resultado =
                    MochilaTopDown.resolver(itens, capacidade);

            System.out.println("\nCapacidade: " + capacidade);
            System.out.println("Valor máximo: "
                    + resultado.getValorMaximo());
            System.out.println("Peso total: "
                    + resultado.getPesoTotal());

            System.out.println("Itens escolhidos:");

            for (Item item : resultado.getItensEscolhidos()) {
                System.out.println("- " + item.getNome());
            }
        }

        // ==========================================
        // VERSÃO C - BOTTOM-UP COM TABULAÇÃO
        // ==========================================

        System.out.println("\n=== BOTTOM-UP ===");

        for (int capacidade : capacidades) {

            MochilaBottomUp.Resultado resultado =
                    MochilaBottomUp.resolver(itens, capacidade);

            System.out.println("\nCapacidade: " + capacidade);
            System.out.println("Valor máximo: "
                    + resultado.getValorMaximo());
            System.out.println("Peso total: "
                    + resultado.getPesoTotal());

            System.out.println("Itens escolhidos:");

            for (Item item : resultado.getItensEscolhidos()) {
                System.out.println("- " + item.getNome());
            }
        }
    }
}
