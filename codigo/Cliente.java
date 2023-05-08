import java.util.LinkedList;

public class Cliente {
    private int id;
    private String nome;
    private String senha;
    private String email;
    public LinkedList<Serie> seriesFuturas;
    public LinkedList<Serie> seriesAssistidas;
    

     /**
         Construtor da classe Cliente
         
        @param id id do cliente
        @param nome nome do cliente
        @param senha senha do cliente
        @param seriesFuturas lista de series para ver futuramente
        @param seriesAssistidas lista de series assistidas pelo cliente  
        */

    public Cliente(int id, String nome, String senha, String email, LinkedList<Serie> seriesFuturas, LinkedList<Serie> seriesAssistidas){
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.seriesFuturas = seriesFuturas;
        this.seriesAssistidas = seriesAssistidas;
    }

    public LinkedList<Serie> getSeriesAssistidas(){
        return seriesAssistidas;
    }

    public String getEmail(){
        return this.email;
    }

    public String getSenha(){
        return senha;
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