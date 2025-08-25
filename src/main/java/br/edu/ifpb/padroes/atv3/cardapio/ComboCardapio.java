package br.edu.ifpb.padroes.atv3.cardapio;

import java.util.ArrayList;
import java.util.List;

public class ComboCardapio implements ComponenteCardapio {

    private final String nome;
    private final double descontoPercentual; // Ex: 0.1 para 10%
    private final List<ComponenteCardapio> itens = new ArrayList<>();

    public ComboCardapio(String nome, double descontoPercentual) {
        this.nome = nome;
        this.descontoPercentual = descontoPercentual;
    }

    public void adicionar(ComponenteCardapio item) {
        this.itens.add(item);
    }

    public void remover(ComponenteCardapio item) {
        this.itens.remove(item);
    }

    @Override
    public double getPreco() {
        double precoTotalSemDesconto = 0;
        for (ComponenteCardapio item : itens) {
            precoTotalSemDesconto += item.getPreco();
        }

        // Aplica o desconto
        double precoFinal = precoTotalSemDesconto * (1 - descontoPercentual);
        return precoFinal;
    }

    @Override
    public void exibir(String indentacao) {
        System.out.printf("%s+ %s (Desconto: %.0f%%) - Preço do Combo: R$ %.2f%n",
                indentacao, nome, descontoPercentual * 100, getPreco());

        for (ComponenteCardapio item : itens) {
            item.exibir(indentacao + "  ");
        }
    }
}