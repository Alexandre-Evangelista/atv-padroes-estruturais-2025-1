package br.edu.ifpb.padroes.atv3.musicas.servico;

import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;

public class TocadorMusicaImpl implements Tocador {
    @Override
    public void tocar(Musica musica) {
        if (musica == null)
            throw new MusicaNaoEncontradaException();

        System.out.println("▶️ Tocando musica: " + musica.titulo() + " - " + musica.artista());
    }
}