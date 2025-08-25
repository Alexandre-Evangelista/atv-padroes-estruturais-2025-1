package br.edu.ifpb.padroes.atv3.musicas.servico;

import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;
import java.util.List;

public class ServicoMusicaProxy implements ServicoMusica {
    private final ServicoMusica servicoMusicaReal;
    private List<Musica> cache;

    public ServicoMusicaProxy() {
        this.servicoMusicaReal = new ServicoMusicaAgregado();
    }

    @Override
    public List<Musica> listarMusicas() {
        if (cache == null) {
            System.out.println("Cache vazio. Buscando músicas de todos os serviços...");
            this.cache = servicoMusicaReal.listarMusicas();
        } else {
            System.out.println("Retornando lista de músicas do cache.");
        }
        return this.cache;
    }

    public void limparCache() {
        this.cache = null;
    }
}