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

        System.out.println("Problema da Mochila - AV3");

        for (int capacidade : capacidades) {
            System.out.println("Capacidade: " + capacidade);
        }
    }
}