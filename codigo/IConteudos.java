public interface IConteudos {

    String[] GENEROS = { "Acao", "Anime", "Aventura", "Comédia", "Documentário", "Drama", "Policial", "Romance",
            "Suspense"};

    String[] IDIOMAS = { "Português", "Inglês", "Espanhol", "Francês", "Alemão", "Italiano" };

    /**
     * Atualiza a avaliacao media do conteudo
     * @param avaliacao avaliacao do cliente
     */
    public void atualizarAvaliacaoMedia(int avaliacao);

    /**
     * Aumenta a quantidade de visualizacoes do conteudo
     */
    public void adicionarQtdVisualizacoes();

    /**
     * Sortea um genero para o construtor de leitura de arquivos das classes filmes e serie
     * @return retorna um genero aleatorio
     */
    public String sortearGenero();

    /**
     * Sortea um idioma para o construtor de leitura de arquivos das classes filmes e serie
     * @return retorna um idioma aleatorio
     */
    public String sortearIdioma();

    
    public int getID();
    public String getGenero();
    public String getIdioma();
    public int getQtdEp();
    public int getDuracao();
    public String getNome();
}