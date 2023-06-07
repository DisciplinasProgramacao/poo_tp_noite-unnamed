import java.util.Scanner;
/**
 * Executa a aplicacao.
 */
public class App {
    static Scanner entrada = new Scanner(System.in);
    Streaming app = new Streaming();
    static int opcao = 0;

    public static void menu(int opcao){
        
        System.out.println("1 - Ler Arquivos\n");
        System.out.println("2 - Salvar Arquivos\n");
        System.out.println("3 - Filtrar por Genêros\n");
        System.out.println("4 - Filtrar por Idiomas\n");
        System.out.println("5 - Filtrar por Quantidade de episodios\n");
        System.out.println("6 - Filtrar filmes por duração\n");
        System.out.println("7 - Login\n");
        System.out.println("8 - Logout\n");
        System.out.println("9 - Adicionar mídia para ver\n");
        System.out.println("10 - Buscar Mídias\n");
        System.out.println("11 - Sair\n");
        System.out.println("Digite uma opção: ");
    }

    public static void main(String[] args) {
        
    }
}