import java.util.Random;
import java.time.LocalDate;

public class Filmes implements IConteudos {
    private int id;
    private String nome;
    private String genero;
    private String idioma;
    private int qtdVisualizacoes;
    private int avaliacaoMedia;
    private int qtdAvaliacoes;
    private int duracao;
    private LocalDate dataLancamento;

    /**
     * Construtor da classe Filme para leitura de arquivos
     * 
     * @param id do filme
     * @param nome do filme
     * @param dataLancamento data de lançamento do filme
     * @param duracao do filme
     */
    public Filmes(int id, String nome, LocalDate dataLancamento, int duracao) {
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
    public Filmes(int id, String genero, String nome, String idioma, LocalDate dataLancamento, int duracao) {
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

    @Override
    public void atualizarAvaliacaoMedia(int avaliacao) {
        this.avaliacaoMedia = (this.avaliacaoMedia * this.qtdAvaliacoes + avaliacao) / ++this.qtdAvaliacoes;
    }

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
        int n = rd.nextInt(8);
        return IDIOMAS[n];
    }

    /**
     * Converte o objeto em uma String no formato: Id | Nome | Genero | DataDeLançamento | qtdvisualizacoes | qtdAvaliacoes | avaliacaoMedia
     */
    @Override
    public String toString() {
        return " ID: " + this.id + " | Nome: " + this.nome + " | Genero: " + this.genero + " | Data de Lançamento: "
                + this.dataLancamento + " | qtdVisualizacoes: " + this.qtdVisualizacoes + "| Avaliacoes: " + this.qtdAvaliacoes
                + " | Rating: " + this.avaliacaoMedia;
    }



    public String getNome() { 
        return this.nome; 
    }
    public int getID() { 
        return this.id; 
    }
    public String getGenero() { 
        return this.genero; 
    }
    public String getIdioma() { 
        return this.idioma; 
    }
    public int getDuracao() { 
        return this.duracao; 
    }
    public int getQtdEp() { 
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