public class Filmes extends Conteudos{
    protected int tempoDuracao;

        /**
        * Construtor da classe Filme
        * 
        * @param genero gênero da filme
        * @param nome   nome da filme
        * @param idioma idioma da filme
        * @param qtdVisualizacoes  quantidade de visualizações da filme
        * @param tempoDuracao duracao de um filme
        */

        public Filmes(String nome, String idioma, String genero, int qtdVisualizacoes, int id, int tempoDuracao) {
            super(nome, idioma, genero, qtdVisualizacoes, tempoDuracao);
            this.tempoDuracao = tempoDuracao;
        }

        public int getDuracao(){
            return this.tempoDuracao;
        }
}
