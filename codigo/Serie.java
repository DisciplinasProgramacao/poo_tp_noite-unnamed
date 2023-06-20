import java.time.LocalDate;
// import java.time.String;
import java.util.Random;

public class Serie implements IConteudos {
    private final int id;
    private String nome;
    private String genero;
    private String idioma;
    private int qtdVisualizacoes;
    private int avaliacaoMedia;
    private int qtdAvaliacoes;
    private int quantidadeEpisodios;
    private String dataLancamento;

    /**
     * Construtor da classe Serie para leitura de arquivos
     * 
     * @param id id da serie
     * @param nome nome da serie
     * @param dataLancamento data de lançamento da serie
     */
    
    public Serie(int id, String nome, String dataLancamento) {
        this.id = id;
        this.genero = sortearGenero();
        this.nome = nome;
        this.idioma = sortearIdioma();
        this.dataLancamento = dataLancamento;
        this.qtdVisualizacoes = 0;
        this.avaliacaoMedia = 0;
        this.qtdAvaliacoes = 0;
        this.quantidadeEpisodios = 10;
    }

    /**
     * Construtor da classe Serie
     * 
     * @param id id da serie
     * @param genero genero da serie
     * @param nome nome da serie
     * @param idioma idioma da serie
     * @param dataLancamento data de lançamento da serie
     * @param quantidadeEpisodios quantidade de episodios da serie
     */
    public Serie(int id, String genero, String nome, String idioma, String dataLancamento, int quantidadeEpisodios) {
        this.id = id;
        this.genero = genero;
        this.nome = nome;
        this.idioma = idioma;
        this.dataLancamento = dataLancamento;
        this.qtdVisualizacoes = 0;
        this.avaliacaoMedia = 0;
        this.qtdAvaliacoes = 0;
        this.quantidadeEpisodios = quantidadeEpisodios;
    }

    /**
     * Registra uma avaliacao da mídia
     * 
     * @param avaliacao avaliacao da mídia
     */
    @Override
    public void atualizarAvaliacaoMedia(int avaliacao) {
        this.avaliacaoMedia = (this.avaliacaoMedia * this.qtdAvaliacoes + avaliacao) / ++this.qtdAvaliacoes;
    }

    /**
     * Adiciona uma Visualizacao a serie
     */
    @Override
    public void adicionarQtdVisualizacoes() {
        this.qtdVisualizacoes++;
    }

    @Override
    public String sortearGenero(){
        Random rd = new Random();
        int n = rd.nextInt(8);
        return GENEROS[n];
    }

    @Override
    public String sortearIdioma(){
        Random rd = new Random();
        int n = rd.nextInt(5);
        return GENEROS[n];
    }

    /**
     * Converte o objeto em uma String no formato: {IdSerie;Nome;DataDeLançamento}
     */
    @Override
    public String toString() {
        return " ID: " + this.id + " | Nome: " + this.nome + " | Genero: " + this.genero + " | Data de Lançamento: "
                + this.dataLancamento + " | Audiencia: " + this.qtdVisualizacoes + "| Quantidade de Episodios: " + this.quantidadeEpisodios
                + " | Rating: " + this.avaliacaoMedia;
    }

    public String getNome() { 
        return this.nome; 
    }

    public int getId() { 
        return this.id; 
    }

    public String getGenero() { 
        return this.genero; 
    }

    public String getIdioma() { 
        return this.idioma; 
    }

    public int getQtdEpisodios() { 
        return this.quantidadeEpisodios; 
    }

    public String getDuracao() { 
        return ""; 
    }

    public int getAudiencia() { 
        return this.qtdVisualizacoes; 
    }

    public int getavaliacaoMedia() { 
        return this.avaliacaoMedia; 
    }
}