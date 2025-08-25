package br.edu.ifpb.padroes.atv3.musicas.servico;

import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamingFacade {
    private final ServicoMusica servicoMusica;

    public StreamingFacade() {
        this.servicoMusica = new ServicoMusicaProxy();
    }

    public List<Musica> buscarPorTitulo(String titulo) {
        return servicoMusica.listarMusicas().stream()
                .filter(m -> m.titulo().equalsIgnoreCase(titulo))
                .collect(Collectors.toList());
    }

    public Optional<Musica> buscarUmaPorTitulo(String titulo) {
        return servicoMusica.listarMusicas().stream()
                .filter(m -> m.titulo().equalsIgnoreCase(titulo))
                .findFirst();
    }

    public List<Musica> buscarPorArtista(String artista) {
        return servicoMusica.listarMusicas().stream()
                .filter(m -> m.artista().equalsIgnoreCase(artista))
                .collect(Collectors.toList());
    }

    public List<Musica> buscarPorGenero(String genero) {
        return servicoMusica.listarMusicas().stream()
                .filter(m -> m.genero().equalsIgnoreCase(genero))
                .collect(Collectors.toList());
    }

    public List<Musica> listarTodas() {
        return servicoMusica.listarMusicas();
    }

    // Método simplificado para tocar música com funcionalidades adicionais (Decorators)
    public void tocarMusica(String titulo, boolean comLogContagem, boolean comEstatisticasArtista) {
        Optional<Musica> musicaOpt = buscarUmaPorTitulo(titulo);

        if (musicaOpt.isPresent()) {
            Tocador tocadorFinal = new TocadorMusicaImpl();
            if (comLogContagem) {
                tocadorFinal = new LogContagemMusicasDecorator(tocadorFinal);
            }
            if (comEstatisticasArtista) {
                tocadorFinal = new EstatisticasArtistasDecorator(tocadorFinal);
            }
            tocadorFinal.tocar(musicaOpt.get());
        } else {
            System.err.println("Música '" + titulo + "' não encontrada!");
        }
    }
}