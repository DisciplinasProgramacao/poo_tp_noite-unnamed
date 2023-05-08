public class Serie {
        protected int id;
        protected String nome;
        protected String idioma;
        protected String genero;
        protected int qtdVisualizacoes;

        /**
        * Construtor da classe Serie
        * 
        * @param genero gênero da sêrie
        * @param nome   nome da sêrie
        * @param idioma idioma da sêrie
        * @param qtdVisualizacoes  quantidade de visualizações da serie
        */

        public Serie(String nome, String idioma, String genero, int qtdVisualizacoes, int id) {
            this.nome = nome;
            this.idioma = idioma;
            this.genero = genero;
            this.qtdVisualizacoes = qtdVisualizacoes;
            this.id = id;
        }

        
        
        public static boolean temNome(String nome) {
        	return nome.equals(nome);
        }

        //método para adicionar mais 1 visualização na serie se alguem assistir ela
        protected void adicionarQtdVisualizacoes(int qtdVisualizacoes){
            qtdVisualizacoes++;
        }
}

