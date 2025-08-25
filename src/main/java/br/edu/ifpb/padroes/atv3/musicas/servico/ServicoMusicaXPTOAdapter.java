package br.edu.ifpb.padroes.atv3.musicas.servico;

import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;
import br.edu.ifpb.padroes.atv3.musicas.xpto.ClientHttpXPTO;
import br.edu.ifpb.padroes.atv3.musicas.xpto.Song;
import java.util.List;
import java.util.stream.Collectors;

public class ServicoMusicaXPTOAdapter implements ServicoMusica {
    private final ClientHttpXPTO client = new ClientHttpXPTO();

    @Override
    public List<Musica> listarMusicas() {
        System.out.println("Buscando músicas do serviço XPTO...");
        List<Song> songs = client.findAll();
        return adaptar(songs);
    }

    private List<Musica> adaptar(List<Song> songs) {
        return songs.stream()
                .map(song -> new Musica(song.id(), song.title(), song.artist(), song.year(), song.genre()))
                .collect(Collectors.toList());
    }
}