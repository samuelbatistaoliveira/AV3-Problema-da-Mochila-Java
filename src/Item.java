public class Item {
    private String nome;
    private int peso;
    private int valor;

    public Item(String nome, int peso, int valor) {
        this.nome = nome;
        this.peso = peso;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public int getPeso() {
        return peso;
    }

    public int getValor() {
        return valor;
    }
}