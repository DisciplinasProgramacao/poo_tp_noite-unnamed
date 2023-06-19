public interface IConteudos {

    String[] GENEROS = { "Ação", "Anime", "Aventura", "Comédia", "Documentário", "Drama", "Policial", "Romance",
            "Suspense"};

    String[] IDIOMAS = { "Português", "Inglês", "Espanhol", "Francês", "Alemão", "Italiano" };

    /**
     * Registra uma avaliacao de conteudo
     * 
     * @param avaliacao avaliacao de conteudo
     */
    public void atualizarAvaliacaoMedia(int avaliacao);

    /**
     * Adiciona uma audiencia a série
     */
    public void adicionarQtdVisualizacoes();

    public String sortearGenero();

    public String sortearIdioma();

    public int getId();

    public String getGenero();

    public String getIdioma();

    public int getQtdEpisodios();

    public int getDuracao();

    public String getNome();

}