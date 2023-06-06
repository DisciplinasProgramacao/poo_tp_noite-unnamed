public class Conteudos {
    protected int id;
    protected String nome;
    protected String idioma;
    protected String genero;
    protected int qtdVisualizacoes = 1;

    /**
    * Construtor da classe Conteudos
    * 
    * @param genero gênero da conteudo
    * @param nome   nome da conteudo
    * @param idioma idioma da conteudo
    * @param qtdVisualizacoes  quantidade de visualizações do conteudo
    */

    public Conteudos(String nome, String idioma, String genero, int qtdVisualizacoes, int id) {
        this.nome = nome;
        this.idioma = idioma;
        this.genero = genero;
        this.qtdVisualizacoes = qtdVisualizacoes;
        this.id = id;
    }

        
        
    public static boolean temNome(String nome) {
        return nome.equals(nome);
    }

    //método para adicionar mais 1 visualização no conteudo se alguem assistir ela
    protected void adicionarQtdVisualizacoes(int qtdVisualizacoes){
        qtdVisualizacoes++;
    }
}
