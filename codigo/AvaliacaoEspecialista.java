import java.util.HashMap;

public class AvaliacaoEspecialista implements IAvaliacoes {
    private class Comentario {
        private String comentario;
        private int nota;

        /**
         * Construtor
         * 
         * @param nota nota
         * @param comentario comentário
         */

        public Comentario(int nota, String comentario) {
            this.nota = nota;
            this.comentario = comentario;
        }

        @Override
        public String toString() {
            return this.nota + " " + this.comentario;
        }
    }

    private HashMap<Integer, Comentario> avaliacoes;

    /**
     * Tornando especialista
     * 
     * @param avaliacoes avaliações antigas
     */
    public AvaliacaoEspecialista(HashMap<Integer, Integer> avaliacoes) {
        this.avaliacoes = new HashMap<Integer, Comentario>();
        avaliacoes.keySet().stream().map(idMidia -> this.avaliacoes.put(idMidia, new Comentario(avaliacoes.get(idMidia), "")));
    }

    @Override
    public String get(int idMidia) {
        return avaliacoes.get(idMidia).toString();
    }

    @Override
    public void avaliar(int idMidia, int avaliacao) {
        avaliacoes.put(idMidia, new Comentario(avaliacao, System.console().readLine()));
    }
}