import java.util.LinkedList;

public class Cliente {
    private int id;
    private String nome;
    private String senha;
    private LinkedList<Serie> seriesFuturas;
    private LinkedList<Serie> seriesAssistidas;
    

     /**
         Construtor da classe Cliente
         
        @param id id do cliente
        @param nome nome do cliente
        @param senha senha do cliente
        @param seriesFuturas lista de series para ver futuramente
        @param seriesAssistidas lista de series assistidas pelo cliente  
        */

    public Cliente(int id, String nome, String senha, LinkedList<Serie> seriesFuturas, LinkedList<Serie> seriesAssistidas){
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.seriesFuturas = seriesFuturas;
        this.seriesAssistidas = seriesAssistidas;
    }

    //método para adicionar uma serie na lista de series para ver futuramente
    public void adicionarSerieFutura(Serie serie){
        seriesFuturas.add(serie);
    }

    //método para remover uma serie da lista de series para ver futuramente
    /**
      Remove uma série da lista de séries para ver
      @param nomeDaSerie nome da série a ser removida
     */
    public void retirarDaLista(String nomeDaSerie) {
        if (Serie.temNome(nomeDaSerie)) {
        for (Serie serie : seriesFuturas)
                seriesFuturas.remove(serie);
        }
    }

    //método para adicionar uma serie na lista de series assistidas
    public void adicionarSerieAssitida(Serie serie){
        seriesAssistidas.add(serie);
    }

    //método para remover uma serie da lista de series assistidas

    /**
      Remove uma série da lista de séries assistidas
      @param nomeDaSerie nome da série a ser removida
     */
    public void retirarDaListaAssistidas(String nomeDaSerie) {
        if (Serie.temNome(nomeDaSerie)) {
        for (Serie serie : seriesAssistidas)
            seriesAssistidas.remove(serie);
        }
    }

    //método para buscar uma serie na lista de series para assistir futuramente e adicionar em uma outra lista de resultados encontrados
    /**
     * 
     * @return lista de series encontradas
    */
    public LinkedList<Serie> buscarSerie(){
        LinkedList<Serie> resuldadoDaBusca = new LinkedList<Serie>();
        for (Serie serie : seriesFuturas){
            resuldadoDaBusca.add(serie);
        }
        return resuldadoDaBusca;
    }
}