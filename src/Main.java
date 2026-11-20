
public class Main {
    public static void main(String[] args) {

        Item[] itens = {
                new Item("Lanterna", 2, 6),
                new Item("Barraca", 4, 10),
                new Item("Faca", 1, 3),
                new Item("Cobertor", 3, 7),
                new Item("Cantil", 2, 5),
                new Item("Mapa", 1, 4),
                new Item("Corda", 5, 9)
        };

        int[] capacidades = {6, 10, 15};

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
    }
}
