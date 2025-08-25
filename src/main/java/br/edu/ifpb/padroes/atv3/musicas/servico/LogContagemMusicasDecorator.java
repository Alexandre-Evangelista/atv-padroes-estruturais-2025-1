package br.edu.ifpb.padroes.atv3.musicas.servico;

import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;

public class LogContagemMusicasDecorator extends TocadorDecorator {
    private static int musicasTocadas = 0;

    public LogContagemMusicasDecorator(Tocador tocador) {
        super(tocador);
    }

    @Override
    public void tocar(Musica musica) {
        super.tocar(musica);
        musicasTocadas++;
        System.out.println("    [LOG] Total de músicas tocadas na sessão: " + musicasTocadas);
    }
}