import java.util.HashMap;
import java.util.ArrayList;

public class Streaming {
    private HashMap<Cliente, Integer> clientes;
    private HashMap<IConteudos, Integer> conteudos;
    private Cliente contaAtual;

    
    /**Construtor da classe Streaming */
    public Streaming(){
        this.conteudos = new HashMap<IConteudos, Integer>();
        this.clientes = new HashMap<Cliente, Integer>();
    }

    /**
     * Método para o usuário fazer login com sua conta
     * 
     * @param email email do usuario
     * @param senha senha do usuario
     */
    public void login(String email, String senha) {
    for (Cliente cliente : clientes.keySet()) {
        if (cliente.getEmail().equals(email) && cliente.getSenha().equals(senha)) {
            this.contaAtual = cliente;
            return;
            }
        }
        System.out.println("Login ou senha incorretos");
    }

    //Método para o usuario deslogar de sua conta
    public void logout() {
        this.contaAtual = null;
    }
    

    /**
     * Método para buscar um conteudo por nome, os métodos "buscarConteudoGenero" e "buscarConteudoIdioma" fazem a mesma coisa só que com filtros
     * diferentes
     * 
     * @param nomeConteudo nome da serie a ser buscada
     * @return novo array list com o resultado da busca
     */
        public ArrayList<Serie> buscarSeriesNome(String nomeSerie, ArrayList<Serie> listaDeSeries) {
            ArrayList<Serie> resultadoDaBusca = new ArrayList<>();
            for (Serie serie : listaDeSeries) {
                if (serie.getNome().equals(nomeSerie)) {
                    resultadoDaBusca.add(serie);
                }
            }
            return resultadoDaBusca;
        }

        public ArrayList<Serie> buscarSeriesGenero(String genero, ArrayList<Serie> listaDeGeneros) {
            ArrayList<Serie> resultadoDaBusca = new ArrayList<>();
            for (Serie serie : listaDeGeneros) {
                if (serie.getGenero().equals(genero)) {
                    resultadoDaBusca.add(serie);
             }
            }
         return resultadoDaBusca;
      }

        public ArrayList<Serie> buscarSeriesIdioma(String idioma, ArrayList<Serie> listaDeIdiomas) {
            ArrayList<Serie> resultadoDaBusca = new ArrayList<>();
            for (Serie serie : listaDeIdiomas) {
              if (serie.getIdioma().equals(idioma)) {
                  resultadoDaBusca.add(serie);
              }
            }
         return resultadoDaBusca;
      }

      /**
     * Método para buscar um filme por nome, os métodos "buscarFilmeGenero" e "buscarFilmeIdioma" fazem a mesma coisa só que com filtros
     * diferentes
     * 
     * @param nomeFilme nome do filme a ser buscad
     * @param listaDeSeries lista de series para fazer a busca
     * @return novo array list com o resultado da busca
     */

     public ArrayList<Filmes> buscarFilmeNome(String nomeFilme, ArrayList<Filmes> listaDeFilmes) {
        ArrayList<Filmes> resultadoDaBusca = new ArrayList<>();
        for (Filmes filme : listaDeFilmes) {
            if (filme.getNome().equals(nomeFilme)) {
                resultadoDaBusca.add(filme);
            }
        }
        return resultadoDaBusca;
    }

    public ArrayList<Filmes> buscarFilmeGenero(String genero, ArrayList<Filmes> listaDeFilmes) {
        ArrayList<Filmes> resultadoDaBusca = new ArrayList<>();
        for (Filmes filme : listaDeFilmes) {
            if (filme.getGenero().equals(genero)) {
                resultadoDaBusca.add(filme);
            }
        }
        return resultadoDaBusca;
    }

    public ArrayList<Filmes> buscarFilmeIdioma(String idioma, ArrayList<Filmes> listaDeFilmes) {
        ArrayList<Filmes> resultadoDaBusca = new ArrayList<>();
        for (Filmes filme : listaDeFilmes) {
            if (filme.getNome().equals(idioma)) {
                resultadoDaBusca.add(filme);
            }
        }
        return resultadoDaBusca;
    }

        /**
         * método para adicionar uma série em uma linked list chamada seriesAssistidas
         * 
         * @param serie serie a ser adicionada na lista
         * @param cliente instancia para a classe cliente
         */
        public void adicionarSerieAssistida(Serie serie, Cliente cliente) {
            cliente.conteudosAssistidos.addLast(serie);
        }
    
        
    

        /**
         * método para adicionar uma serie na lista de series para ver futuramente
         * 
         * @param serie serie a ser adicionada na lista
         * @param cliente instancia para a classe cliente
         */
        public void adicionarSerieFutura(Serie serie, Cliente cliente){
            cliente.conteudosFuturos.add(serie);
        }

        /**
         * Remove uma série da lista de séries para ver futuramente
         * @param nomeDaSerie nome da serie a ser removida
         * @param cliente instancia para a classe cliente
         */
        public void retirarDaListaFutura(String nomeDaSerie, Cliente cliente) {
            cliente.retirarDaListaFutura(nomeDaSerie);
        }


        /**
         * método para adicionar um filme em uma linked list chamada filmesAssistidos
         * 
         * @param filme filme a ser adicionado na lista
         * @param cliente instancia para a classe cliente
         */
        
}