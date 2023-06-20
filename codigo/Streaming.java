import java.util.HashMap;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Clase que representa uma plataforma de streaming.
 */
public class Streaming {
    private String nome;
    private HashMap<Integer, IConteudos> conteudos;
    private HashMap<String, Integer> nomes;
    private HashMap<String, Cliente> clientes;
    private Optional<Cliente> contaAtual;

    /**
     * Construtor da classe PlataformaStreaming.
     * 
     * @param nome Nome da plataforma de streaming.
     */
    public Streaming(String nome) {
        this.nome = nome;
        this.conteudos = new HashMap<Integer, IConteudos>();
        this.nomes = new HashMap<String, Integer>();
        this.clientes = new HashMap<String, Cliente>();
        this.logOff();
    }

    /**
     * Executa o login de um cliente.
     * 
     * @param user  nome de usuario do cliente.
     * @param senha senha do cliente.
     * @param admin se o login ocorre como administrador.
     */
    public void login(String user, String senha, boolean admin) {
        try {
            if (admin) // loga no cliente como administrador
                this.contaAtual = Optional.of(this.clientes.get(user));

            else if (this.clientes.get(user).verificarSenha(senha)) { // loga no cliente como usuario comum
                this.contaAtual = Optional.of(this.clientes.get(user));
                System.out.println(" Logado como " + this.contaAtual.get().getEmail());
            }

            else // login ou senha incorretos
                System.out.println("Login ou senha incorretos");

        } catch (NullPointerException e) { // cliente nao encontrado, excecao na linha 45
            System.out.println(" Nenhum cliente com esse login");
        }
    }

    /**
     * Desloga o cliente atual.
     */
    public void logOff() {
        this.contaAtual = Optional.empty();
    }

    /**
     * Adiciona um conteudo na plataforma de streaming.
     * 
     * @param conteudos nova conteudos a ser adicionada.
     */
    public void adicionarMidia(IConteudos conteudos) {
        this.conteudos.put(conteudos.getId(), conteudos);
        this.nomes.put(conteudos.getNome(), conteudos.getId());
    }

    /**
     * Adiciona um cliente na plataforma de streaming.
     * 
     * @param cliente novo cliente a ser adicionado.
     */
    public void adicionarCliente(Cliente cliente) {
        this.clientes.put(cliente.getEmail(), cliente);
    }

    /**
     * Adiciona uma midia a lista de conteudos ja assistidas pelo cliente atual e
     * incrementa a audiencia da midia.
     * 
     * @param completado se o cliente assistiu a midia por completo.
     * @param midia ter a audiencia incrementada.
     */
    public void registrarAudiencia(boolean completado, IConteudos midia, boolean avaliacao) {
        if (midia == null) { // Se a midia nao existir, nao e possivel registrar audiencia
            System.out.println("IMidia nao encontrada"); 
            return;
        }

        if (this.contaAtual.isEmpty()) { // Se nao houver cliente logado, nao e possivel registrar audiencia
            System.out.println("Nenhum cliente logado, nao e possivel registrar audiencia."); 
            return;
        }

        if (!completado) { // Atualiza o cliente caso ele se torne especialista
            this.contaAtual.get().adicionarNaLista(midia); 
            return;
        }
    }

    /**
     * Retorna uma lista com todas as conteudos de um cliente participantes de um
     * determinado genero.
     * 
     * @param genero genero das conteudos a serem filtradas
     * @return Lista com as conteudos do genero passado como parâmetro
     */
    public Stream<String> buscarConteudoGenero(String genero) {
        if (this.contaAtual.isPresent()) // Se o cliente estiver logado, filtra as conteudos dele
            return this.contaAtual.get().buscarPorGenero(genero);

        // Se nao, filtra todas as conteudos da plataforma
        return this.conteudos.values().stream()
                .filter(midia -> midia.getGenero().equals(genero))
                .map(Object::toString);
    }

    /**
     * Retorna uma lista com todos os conteudos de um cliente que possuem um
     * determinado idioma.
     * 
     * @param idioma idioma das conteudos a serem filtradas
     * @return Lista com os conteudos do idioma passado como parâmetro
     */
    public Stream<String> buscarConteudoIdioma(String idioma) {
        if (this.contaAtual.isPresent()) // Se o cliente estiver logado, filtra as conteudos dele
            return this.contaAtual.get().buscarPorIdioma(idioma);

        // Se nao, filtra todos os conteudos da plataforma
        return this.conteudos.values().stream()
                .filter(midia -> midia.getIdioma().equals(idioma))
                .map(Object::toString);
    }

    /**
     * Retorna uma lista com todas as series de um cliente que possuem uma
     * determinada quantidade de episodios.
     * 
     * @param quantidadeEpisodios quantidade de episodios das series a serem filtrados
     * @return Lista com as series com a quantidade de episodios passada como parâmetro
     */
    public Stream<String> buscarConteudoQtdEpisodios(int quantidadeEpisodios) {
        if (this.contaAtual.isPresent()) // Se o cliente estiver logado, filtra as series dele
            return this.contaAtual.get().buscarConteudoQtdEpisodios(quantidadeEpisodios);

        // Se nao, filtra todas as conteudos da plataforma
        return this.conteudos.values().stream()
                .filter(midia -> midia.getQtdEpisodios() == quantidadeEpisodios)
                .map(Object::toString);
    }

    /**
     * Retorna uma lista com todos os filmes de um cliente que possuem uma
     * determinada duracao.
     * 
     * @param duracao duracao dos filmes a serem filtrados
     * @return Lista com os filmes com a duracao passada como parâmetro
     */
    public Stream<String> buscarConteudoDuracao(String duracao) {
        if (this.contaAtual.isPresent()) // Se o cliente estiver logado, filtra os filmes dele
            return this.contaAtual.get().buscarPorDuracao(duracao);

        // Se nao, filtra todos os filmes da plataforma
        return this.conteudos.values().stream()
                .filter(midia -> midia.getDuracao() == duracao)
                .map(Object::toString);
    }

    /**
     * Busca uma midia na plataforma de streaming pelo id.
     * 
     * @param idMidia id da midia a ser buscada.
     * @return IMidia com o id passado como parâmetro, NULL caso nao exista.
     */
    public IConteudos buscarMidia(int idMidia) {
        return this.conteudos.get(idMidia);
    }
    /**
     * Busca uma midia na plataforma de streaming pelo nome.
     * 
     * @param nomeMidia nome da midia a ser buscada.
     * @return IMidia com o nome passado como parâmetro, NULL caso nao exista.
     */ 
    public IConteudos buscarMidia(String nomeMidia) {
        return this.conteudos.get(this.nomes.get(nomeMidia));
                // (this.contaAtual.isPresent()
                //         ? " Sua avaliação: " + String.valueOf(this.contaAtual.get().getAvaliacao(this.nomes.get(nomeMidia)))
                //         : "");
    }

    /**
     * Retorna uma string que representa a plataforma de streaming com o nome e
     * número de conteudos e clientes cadastrados.
     * 
     * @return String que representa a plataforma de streaming.
     */
    @Override
    public String toString() {
        return " Ha " + this.conteudos.size() + " conteudos cadastradas na plataforma " + this.nome + " e " + this.clientes.size() + " clientes cadastrados.";
    }

    /** Retorna as conteudos
     * @return conteudos
     * 
     */
    public HashMap<Integer, IConteudos> getMidia() { 
        return this.conteudos; 
    }

    /** Retorna os clientes
     * @return clientes
     */
    public HashMap<String, Cliente> getClientes() { 
        return this.clientes; 
    }

    /**
     * Retorna cliente atual
     * @return contaAtual
     */
    public Optional<Cliente> getcontaAtual() { 
        return this.contaAtual; 
    }
}