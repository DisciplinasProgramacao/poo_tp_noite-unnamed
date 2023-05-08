import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
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

        /**
         * método para ler o arquivo espectadores.csv e obter as suas informações
         * 
         * @param caminhoArquivo o caminho onde está o arquivo é passado por parametro
         * @return retorna a lista de espectadores da serie
         * @throws FileNotFoundException
         */

        public List<Cliente> lerArquivoEspectadores(String caminhoArquivo) throws FileNotFoundException {
            List<Cliente> espectadores = new ArrayList<>();
            Scanner scanner = new Scanner(new File(caminhoArquivo));
            scanner.nextLine(); // descarta a primeira linha
            while (scanner.hasNextLine()) {
                String[] dados = scanner.nextLine().split(";");
                int id = Integer.parseInt(dados[0]);
                String nome = dados[1];
                String senha = dados[2];
                String email = dados[3];
                LinkedList<Serie> seriesFuturas = new LinkedList<>();
                LinkedList<Serie> seriesAssistidas = new LinkedList<>();
                Cliente cliente = new Cliente(id, nome, senha, email, seriesFuturas, seriesAssistidas);
                espectadores.add(cliente);
            }
            scanner.close();
            return espectadores;
        }
    

        /**
         * método para ler o arquivo series.csv e obter suas informações
         * 
         * @param caminhoArquivo o caminho onde está o arquivo é passado por parametro
         * @return retorna a lista de series de acordo com o arquivo
         * @throws FileNotFoundException
         */

        public List<Serie> lerArquivoSeries(String caminhoArquivo) throws FileNotFoundException {
            List<Serie> series = new ArrayList<>();
            Scanner scanner = new Scanner(new File(caminhoArquivo));
            scanner.nextLine(); // descarta a primeira linha
            while (scanner.hasNextLine()) {
                String[] dados = scanner.nextLine().split(";");
                int id = Integer.parseInt(dados[0]);
                String nome = dados[1];
                String idioma = dados[2];
                String genero = dados[3];
                Serie serie = new Serie(nome, idioma, genero, 0, id);
                series.add(serie);
            }
            scanner.close();
            return series;
        }
        
        /**
         * método para ler o arquivo audiencia.csv e obter suas informações
         * 
         * @param caminhoArquivo o caminho onde está o arquivo é passado por parametro
         * @return retorna a uma lista de audiencias da serie
         * @throws FileNotFoundException
         */
        public List<Serie> lerArquivoAudiencia(String caminhoArquivo) throws FileNotFoundException {
            List<Serie> audiencias = new ArrayList<>();
            Scanner scanner = new Scanner(new File(caminhoArquivo));
            scanner.nextLine(); // descarta a primeira linha
            while (scanner.hasNextLine()) {
                String[] dados = scanner.nextLine().split(";");
                Serie audiencia = new Serie(dados[0], dados[1], dados[2], 0, 0);
                audiencias.add(audiencia);
            }
            scanner.close();
            return audiencias;
        }
}