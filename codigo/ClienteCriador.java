import java.util.LinkedList;

/*
 * A classe ClienteCriador implementa a interface CriadorDeObjeto e define como criar um objeto do tipo Cliente a partir dos dados lidos do arquivo. Para utilizar essa classe para ler os dados dos espectadores.
 * 
 * 
 * 
 * podemos criar uma instância do LeitorArquivo no main e passar o caminho do arquivo e a instância do ClienteCriador para o método lerArquivo dessa forma:
 * 
 *  LeitorArquivo<Cliente> leitorArquivo = new LeitorArquivo<>();
    List<Cliente> espectadores = leitorArquivo.lerArquivo("caminho/do/arquivo", new ClienteCriador());
 */
public class ClienteCriador implements LeitorArquivo.CriadorDeObjeto<Cliente> {

    @Override
    public Cliente criarObjeto(String[] dados) {
        int id = Integer.parseInt(dados[0]);
        String nome = dados[1];
        String senha = dados[2];
        String email = dados[3];
        LinkedList<Serie> seriesFuturas = new LinkedList<>();
        LinkedList<Serie> seriesAssistidas = new LinkedList<>();
        LinkedList<Filmes> filmesFuturos = new LinkedList<>();
        LinkedList<Filmes> filmesAssistidos = new LinkedList<>();
        Cliente cliente = new Cliente(id, nome, senha, email, seriesFuturas, seriesAssistidas, filmesAssistidos, filmesFuturos);
        return cliente;
    }

}
