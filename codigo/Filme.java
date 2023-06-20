import java.util.Random;
// import java.time.String;

public class Filme implements IConteudos {
    private final int id;
    private String nome;
    private String genero;
    private String idioma;
    private int qtdVisualizacoes;
    private int avaliacaoMedia;
    private int qtdAvaliacoes;
    private String duracao;
    private String dataLancamento;

    /**
     * Construtor da classe Filme para leitura de arquivos
     * 
     * @param id do filme
     * @param nome do filme
     * @param dataLancamento data de lançamento do filme
     * @param duracao do filme
     */
    public Filme(int id, String nome, String dataLancamento, String duracao) {
        this.id = id;
        this.genero = sortearGenero();
        this.nome = nome;
        this.idioma = sortearIdioma();
        this.dataLancamento = dataLancamento;
        this.qtdVisualizacoes = 0;
        this.avaliacaoMedia = 0;
        this.qtdAvaliacoes = 0;
        this.duracao = duracao;
    }

    /**
     * Construtor da classe Filme
     * 
     * @param id do filme
     * @param genero do filme
     * @param nome do filme
     * @param idioma do filme
     * @param dataLancamento data de lançamento do filme
     * @param duracao do filme
     */
    public Filme(int id, String genero, String nome, String idioma, String dataLancamento, String duracao) {
        this.id = id;
        this.genero = genero;
        this.nome = nome;
        this.idioma = idioma;
        this.dataLancamento = dataLancamento;
        this.qtdVisualizacoes = 0;
        this.avaliacaoMedia = 0;
        this.qtdAvaliacoes = 0;
        this.duracao = duracao;
    }

    /**
     * atualiza uma avaliacao do conteudo
     * 
     * @param avaliacao avaliacao do conteudo
     */
    @Override
    public void atualizarAvaliacaoMedia(int avaliacao) {
        this.avaliacaoMedia = (this.avaliacaoMedia * this.qtdAvaliacoes + avaliacao) / ++this.qtdAvaliacoes;
    }

    /**
     * Adiciona uma qtdVisualizacoes a serie
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

    public String sortearIdioma(){
        Random rd = new Random();
        int n = rd.nextInt(5);
        return GENEROS[n];
    }

    @Override
    public String toString() {
        return " ID: " + this.id + " | Nome: " + this.nome + " | Genero: " + this.genero + " | Data de Lançamento: "
                + this.dataLancamento + " | qtdVisualizacoes: " + this.qtdVisualizacoes + "| Avaliacoes: " + this.qtdAvaliacoes
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

    public String getDuracao() { 
        return this.duracao; 
    }

    public int getQtdEpisodios() { 
        return -1; 
    }
    
    public int getQtdAvaliacoes() { 
        return this.qtdAvaliacoes; 
    }
    
    public int getavaliacaoMedia() { 
        return this.avaliacaoMedia; 
    }

    public int getQtdVisualizacoes() { 
        return this.qtdVisualizacoes; 
    }
}