import java.util.LinkedList;

public class Cliente {
    private int id;
    private String nome;
    private String senha;
    private String email;
    public LinkedList<IConteudos> conteudosFuturos;
    public LinkedList<IConteudos> conteudosAssistidos;
    

     /**
         Construtor da classe Cliente
         
        @param id id do cliente
        @param nome nome do cliente
        @param senha senha do cliente
        @param conteudosFuturos lista de Conteudos para ver futuramente
        @param conteudosAssistidos lista de Conteudos assistidas pelo cliente  
        */

    public Cliente(int id, String nome, String senha, String email, LinkedList<IConteudos> conteudosFuturos, LinkedList<IConteudos> conteudosAssistidos){
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.conteudosFuturos = conteudosFuturos;
        this.conteudosAssistidos = conteudosAssistidos;
    }

    public LinkedList<IConteudos> getConteudosAssistidos(){
        return conteudosAssistidos;
    }


    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail(){
        return this.email;
    }

    public String getSenha(){
        return senha;
    }


    /**
     * 
     * @return lista de series encontradas
    */
    public LinkedList<IConteudos> buscarConteudo(){
        LinkedList<IConteudos> resuldadoDaBusca = new LinkedList<IConteudos>();
        for (IConteudos serie : this.conteudosFuturos){
            resuldadoDaBusca.add(serie);
        }
        return resuldadoDaBusca;
    }

    public void retirarDaListaFutura(String nomeDaSerie) {
        for(IConteudos conteudo : conteudosFuturos){
            if(conteudo.getNome().equals(nomeDaSerie)){
                conteudosFuturos.remove(conteudo);
            }
        }
    }
}