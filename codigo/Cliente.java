import java.time.LocalDate;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

public class Cliente {
    private String nome;
    private String email;
    private String senha;
    private List<IConteudos> conteudosFuturos;
    private List<IConteudos> conteudosAssistidos;
    private IAvaliacoes avaliacoes;

    /**
     * Construtor da classe Cliente
     * 
     * @param nome nome de usuario do cliente
     * @param email email do cliente
     * @param senha senha do cliente
     */
    public Cliente(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.conteudosFuturos = new Stack<IConteudos>();
        this.conteudosAssistidos = new Stack<IConteudos>();
        this.avaliacoes = new AvaliacaoComum();
    }

    /**
     * Adiciona um conteudo na lista de series para ver
     * 
     * @param midia a ser adicionada
     */
    public void adicionarNaLista(IConteudos midia) {
        this.conteudosFuturos.add(midia);
    }

    /**
     * Adiciona um conteudo na lista de series ja vistas, como o cliente comum nao
     * pode dar avaliacao, o comentario e vazio
     * 
     * @param midia a ser adicionada
     * @param avaliacao avaliacao da midia
     * @param data data de visualizacao
     */
    public void registrarAudiencia(IConteudos midia, int avaliacao, LocalDate data) {
        this.conteudosAssistidos.add(midia);
        midia.adicionarQtdVisualizacoes();
        if (avaliacao != 0) {
            this.avaliacoes.avaliar(midia.getId(),avaliacao);
            midia.atualizarAvaliacaoMedia(avaliacao);
        }
    }

    /**
     * Remove um conteudo da lista de series para ver
     * 
     * @param nomeMidia nome da midia a ser removida
     */
    public void retirarDaLista(String nomeMidia) {
        this.conteudosFuturos.removeIf(midia -> midia.getNome().equals(nomeMidia));
    }

    /**
     * busca a lista de series para ver por genero
     * 
     * @param genero a ser buscado
     * @return lista de series buscada
     */
    public Stream<String> buscarPorGenero(String genero) {
        return this.conteudosAssistidos.stream()
                .filter(midia -> midia.getGenero().equals(genero))
                .map(midia -> {
                    String avaliacao = this.avaliacoes.get(midia.getId());
                    return midia + " | Sua avaliacao: " + (avaliacao == null ? "Voce não fez uma avaliação" : avaliacao);
                });
    }

    /**
     * busca a lista de series para ver por idioma
     * 
     * @param idioma a ser buscado
     * @return lista de series buscada
     */
    public Stream<String> buscarPorIdioma(String idioma) {
        return this.conteudosAssistidos.stream()
                .filter(midia -> midia.getIdioma().equals(idioma))
                .map(i -> {
                    String avaliacao = this.avaliacoes.get(i.getId());
                    return i + " | Sua avaliacao: " + (avaliacao == null ? "Voce nao fez uma avaliação" : avaliacao);
                });
    }

    /**
     * busca a lista de series para ver por quantidade de episodios
     * 
     * @param qntsEpisodios quantidade de episodios a ser buscada
     * @return lista de series buscada
     */
    public Stream<String> buscarConteudoQtdEpisodios(int qntsEpisodios) {
        return this.conteudosAssistidos.stream()
                .filter(midia -> midia.getQtdEpisodios() == qntsEpisodios)
                .map(i -> {
                    String avaliacao = this.avaliacoes.get(i.getId());
                    return i + " | Sua avaliacao: " + (avaliacao == null ? "Voce nao deu avaliação" : avaliacao);
                });
    }

    /**
     * busca a lista de filmes para ver por duracao
     * 
     * @param duracao a ser buscada
     * @return lista de filmes buscada
     */
    public Stream<String> buscarPorDuracao(int duracao) {
        return this.conteudosAssistidos.stream()
                .filter(midia -> midia.getDuracao() == duracao)
                .map(i -> {
                    String avaliacao = this.avaliacoes.get(i.getId());
                    return i + " | Sua avaliacao: " + (avaliacao == null ? "Voce nao deu avaliação" : avaliacao);
                });
    }

    /**
     * Verifica se o cliente inseriu a senha correta
     * 
     * @param senha a ser verificada
     * @return TRUE se a senha esta correta, FALSE caso contrario
     */
    public boolean verificarSenha(String senha) {
        return this.senha.equals(senha);
    }

    /**
     * Converte o objeto em uma String no formato: {Nome;email;Senha}
     * 
     * @return String com os dados do cliente
     */
    public String toString() {
        return this.nome + ";" + this.email + ";" + this.senha;
    }

    /**
     * Retorna um array de Strings com as audiencias do cliente
     * 
     * @return array de Strings com todas as audiencias do cliente
     */
    public String[] qtdVisualizacoes() {
        int paraVerSize = this.conteudosFuturos.size();
        int sizeTotal = paraVerSize + this.conteudosAssistidos.size();
        String[] qtdVisualizacoes = new String[sizeTotal];

        for (int i = 0; i < paraVerSize; i++)
            qtdVisualizacoes[i] = this.email + ";" + "A" + ";" + this.conteudosFuturos.get(i).getId();

        for (int i = paraVerSize; i < sizeTotal; i++)
            qtdVisualizacoes[i] = this.email + ";" + "F" + ";" + this.conteudosAssistidos.get(i - paraVerSize).getId();

        return qtdVisualizacoes;
    }

    /**
     * Retorna o nome de usuario do cliente
     * 
     * @return nome de usuario do cliente
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Retorna a avaliacao de um conteudo
     * 
     * @param idMidia id da midia a ser buscada
     */
    public String getAvaliacao(int idMidia) {
        return this.avaliacoes.get(idMidia);
    }

    /**
     * Retorna lista para ver
     * 
     * @return quantidade de midias para ver
     */
    public List<IConteudos> getconteudosFuturos() {
        return this.conteudosFuturos;
    }

    /**
     * Retorna lista ja vistas
     * 
     * @return quantidade de midias ja vistas
     */
    public List<IConteudos> getconteudosAssistidos() {
        return this.conteudosAssistidos;
    }

    /**
     * Retorna avaliacoes
     * 
     * @return avaliacoes
     */
    public IAvaliacoes getAvaliacoes() {
        return this.avaliacoes;
    }
}