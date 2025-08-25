package br.edu.ifpb.padroes.atv3.musicas.servico;

import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;
import java.util.ArrayList;
import java.util.List;

public class ServicoMusicaAgregado implements ServicoMusica {
    private final List<ServicoMusica> servicos;

    public ServicoMusicaAgregado() {
        this.servicos = List.of(new ServicoMusicaABCD(), new ServicoMusicaXPTOAdapter());
    }

    @Override
    public List<Musica> listarMusicas() {
        List<Musica> todasAsMusicas = new ArrayList<>();
        for (ServicoMusica servico : servicos) {
            todasAsMusicas.addAll(servico.listarMusicas());
        }
        return todasAsMusicas;
    }
}