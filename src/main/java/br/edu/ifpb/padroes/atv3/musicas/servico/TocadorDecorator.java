package br.edu.ifpb.padroes.atv3.musicas.servico;

import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;

public abstract class TocadorDecorator implements Tocador {
    protected Tocador tocadorDecorado;

    public TocadorDecorator(Tocador tocador) {
        this.tocadorDecorado = tocador;
    }

    @Override
    public void tocar(Musica musica) {
        tocadorDecorado.tocar(musica);
    }
}