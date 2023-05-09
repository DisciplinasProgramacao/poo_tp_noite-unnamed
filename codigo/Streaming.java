import java.util.HashMap;
import java.util.ArrayList;

public class Streaming {
    // "Cliente" é o tipo da chave que foi utilizada e o segundo "Cliente" é o tipo do valor associado a essa chave. "Clientes" é o nome dado para a variavel HashMap.
    private HashMap<Cliente, Integer> Clientes;
    private HashMap<Serie, Integer> Series;
    private Cliente contaAtual;


    /**
         Construtor da classe Steaming
         
        @param contaAtual a conta atual que o cliente está
        o construtor também está criando os objetos hash corretamente  
        */

    public Streaming(Cliente contaAtual){
        this.contaAtual = contaAtual;
        this.Series = new HashMap<Serie, Integer>();
        this.Clientes = new HashMap<Cliente, Integer>();
    }

    /**
     * Método para o usuário fazer login com sua conta
     * 
     * @param email email do usuario
     * @param senha senha do usuario
     */

    public void login(String email, String senha) {
    for (Cliente cliente : Clientes.keySet()) {
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
     * Método para buscar uma serie por nome, os métodos "buscarSeriesGenero" e "buscarSeriesIdioma" fazem a mesma coisa só que com filtros
     * diferentes
     * 
     * @param nomeSerie nome da serie a ser buscada
     * @param listaDeSeries lista de series para fazer a busca
     * @return novo array list com o resultado da busca
     */

        public ArrayList<Serie> buscarSeriesNome(String nomeSerie, ArrayList<Serie> listaDeSeries) {
            ArrayList<Serie> resultadoDaBusca = new ArrayList<>();
            for (Serie serie : listaDeSeries) {
                if (serie.nome.equals(nomeSerie)) {
                    resultadoDaBusca.add(serie);
                }
            }
            return resultadoDaBusca;
        }

        public ArrayList<Serie> buscarSeriesGenero(String genero, ArrayList<Serie> listaDeGeneros) {
            ArrayList<Serie> resultadoDaBusca = new ArrayList<>();
            for (Serie serie : listaDeGeneros) {
                if (serie.genero.equals(genero)) {
                    resultadoDaBusca.add(serie);
             }
            }
         return resultadoDaBusca;
      }

        public ArrayList<Serie> buscarSeriesIdioma(String idioma, ArrayList<Serie> listaDeIdiomas) {
            ArrayList<Serie> resultadoDaBusca = new ArrayList<>();
            for (Serie serie : listaDeIdiomas) {
              if (serie.idioma.equals(idioma)) {
                  resultadoDaBusca.add(serie);
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
            cliente.seriesAssistidas.addLast(serie);
        }
    
        //método para remover uma serie da lista de series assistidas
    
        /**
          Remove uma série da lista de séries assistidas
          @param nomeDaSerie nome da série a ser removida
         */
        public void retirarDaListaAssistidas(String nomeDaSerie, Cliente cliente) {
            if (Serie.temNome(nomeDaSerie)) {
            for (Serie serie : cliente.seriesAssistidas)
                cliente.seriesAssistidas.remove(serie);
            }
        }

        /**
         * método para adicionar uma serie na lista de series para ver futuramente
         * 
         * @param serie serie a ser adicionada na lista
         * @param cliente instancia para a classe cliente
         */
        public void adicionarSerieFutura(Serie serie, Cliente cliente){
            cliente.seriesFuturas.add(serie);
        }

        /**
         * Remove uma série da lista de séries para ver futuramente
         * @param nomeDaSerie nome da serie a ser removida
         * @param cliente instancia para a classe cliente
         */
        public void retirarDaListaFutura(String nomeDaSerie, Cliente cliente) {
            if (Serie.temNome(nomeDaSerie)) {
            for (Serie serie : cliente.seriesFuturas)
                cliente.seriesFuturas.remove(serie);
            }
        }
}