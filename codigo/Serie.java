public class Serie  extends Conteudos{
        protected int quantidadeEpisodios;

        /**
        * Construtor da classe Serie
        * 
        * @param genero gênero da sêrie
        * @param nome   nome da sêrie
        * @param idioma idioma da sêrie
        * @param qtdVisualizacoes  quantidade de visualizações da serie
        * @param quantidadeEpisodios quantidade de episodios que a serie possui
        */

        public Serie(String nome, String idioma, String genero, int qtdVisualizacoes, int id, int quantidadeEpisodios) {
            super(nome, idioma, genero, qtdVisualizacoes, quantidadeEpisodios);
            this.quantidadeEpisodios = quantidadeEpisodios;
        }

        public int getEpisodios(){
            return this.quantidadeEpisodios;
        }
}

