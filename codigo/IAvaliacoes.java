public interface IAvaliacoes {
    /**
     * Retorna a avaliacao de uma midia
     * 
     * @param idMidia id da midia a ser buscada
     * @return avaliacao da midia em string
     */
    public String get(int idMidia);

    /**
     * Gera uma nova avaliacao para uma midia
     * 
     * @param idMidia   id da midia a ser avaliada
     * @param avaliacao nota da midia
     */
    public void avaliar(int idMidia, int avaliacao);
}