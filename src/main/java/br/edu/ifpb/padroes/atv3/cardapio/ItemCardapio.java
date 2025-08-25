package br.edu.ifpb.padroes.atv3.cardapio;

public class ItemCardapio implements ComponenteCardapio {

    private final String nome;
    private final double preco;

    public ItemCardapio(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public double getPreco() {
        return this.preco;
    }

    @Override
    public void exibir(String indentacao) {
        System.out.printf("%s- %s: R$ %.2f%n", indentacao, nome, getPreco());
    }
}