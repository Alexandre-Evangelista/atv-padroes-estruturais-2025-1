package br.edu.ifpb.padroes.atv3.musicas.servico;

import br.edu.ifpb.padroes.atv3.musicas.abcd.ClienteHttpABCD;
import br.edu.ifpb.padroes.atv3.musicas.abcd.Musica;
import java.util.List;

public class ServicoMusicaABCD implements ServicoMusica {
    private final ClienteHttpABCD cliente = new ClienteHttpABCD();

    @Override
    public List<Musica> listarMusicas() {
        System.out.println("Buscando músicas do serviço ABCD...");
        return cliente.listarMusicas();
    }
}