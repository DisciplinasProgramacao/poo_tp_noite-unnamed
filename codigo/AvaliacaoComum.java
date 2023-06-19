import java.util.HashMap;

/**
 * Avaliação inicial que o usuario pode fazer, armazena apenas a nota de uma
 * midia
 */
public class AvaliacaoComum implements IAvaliacoes {
    private HashMap<Integer, Integer> avaliacoes;

    /**
     * Primeira avaliação
     */
    public AvaliacaoComum() {
        this.avaliacoes = new HashMap<Integer, Integer>();
    }

    public AvaliacaoComum(HashMap<Integer, Integer> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    @Override
    public String get(int idMidia) {
        return avaliacoes.get(idMidia).toString();
    }

    @Override
    public void avaliar(int idMidia, int avaliacao) {
        avaliacoes.put(idMidia, avaliacao);
    }
}