package br.edu.ifpb.padroes.atv3.musicas.servico;

import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;
import java.util.HashMap;
import java.util.Map;

public class EstatisticasArtistasDecorator extends TocadorDecorator {
    private static final Map<String, Integer> contagemPorArtista = new HashMap<>();

    public EstatisticasArtistasDecorator(Tocador tocador) {
        super(tocador);
    }

    @Override
    public void tocar(Musica musica) {
        super.tocar(musica);
        contagemPorArtista.merge(musica.artista(), 1, Integer::sum);
        System.out.println("    [STATS] Artistas mais tocados: " + contagemPorArtista);
    }
}