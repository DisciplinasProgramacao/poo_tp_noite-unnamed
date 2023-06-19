import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class App {
    private static Streaming app = new Streaming("Plataforma");
    private static Scanner entrada = new Scanner(System.in);


    public static void main(String[] args) {
        boolean lock = true;
        while (lock) {
            menu();
            int opcao = lerInteiro();
            switch (opcao) {
                case 1:
                    entrada.nextLine(); // Limpar o buffer do scanner
                    System.out.print("Gênero: ");
                    String genero = entrada.nextLine();
                    app.buscarConteudoGenero(genero).forEach(System.out::println);
                    break;
                case 2:
                    entrada.nextLine(); // Limpar o buffer do scanner
                    System.out.print("Idioma: ");
                    String idioma = entrada.nextLine();
                    app.buscarConteudoIdioma(idioma).forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Quantidade de episódios: ");
                    int quantidadeEpisodios = entrada.nextInt();
                    app.buscarConteudoQtdEpisodios(quantidadeEpisodios).forEach(System.out::println);
                    break;
                case 4:
                    System.out.print("Duração: ");
                    int duracao = entrada.nextInt();
                    app.buscarConteudoDuracao(duracao).forEach(System.out::println);
                    break;
                case 5:
                    entrada.nextLine(); // Limpar o buffer do scanner
                    System.out.print("Email: ");
                    String login = entrada.nextLine();
                    System.out.print("Senha: ");
                    String senha = entrada.nextLine();
                    app.login(login, senha, false);
                    break;
                case 6:
                    app.logOff();
                    break;
                case 7:
                    menuAdicionar();
                    int opcaoAdicionar = lerInteiro();
                    menuAdicionarOpcao(opcaoAdicionar);
                    break;
                case 8:
                    entrada.nextLine(); // Limpar o buffer do scanner
                    System.out.print("Nome da mídia: ");
                    String nomeMidia = entrada.nextLine();
                    System.out.println(app.buscarMidia(nomeMidia));
                    break;
                case 9:
                    lock = false;
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
    }

    public static int lerInteiro() {
        return entrada.nextInt();
    }

    public static void menu() {
        System.out.println("========Sistema de Streaming========");
        System.out.println("1 - buscar por Gênero\n");
        System.out.println("2 - buscar por Idioma\n");
        System.out.println("3 - buscar por Quantidade de Episódios\n");
        System.out.println("4 - buscar filmes por duração\n");
        System.out.println("5 - Login\n");
        System.out.println("6 - Logout\n");
        System.out.println("7 - Adicionar Mídia/Audiência/Para Ver\n");
        System.out.println("8 - Buscar Mídia\n");
        System.out.println("9 - Sair\n");
        System.out.println("Digite uma opção: ");
    }

    public static void menuAdicionar() {
        System.out.println("1 - Adicionar Série\n");
        System.out.println("2 - Adicionar Filme\n");
        System.out.println("3 - Adicionar Cliente\n");
        System.out.println("4 - Adicionar Audiência\n");
        System.out.println("Digite uma opção: ");
    }

    public static void adicionarSerie() {
        System.out.print("id: ");
        int id = entrada.nextInt();
        entrada.nextLine(); // Limpar o buffer do scanner
        System.out.print("Gênero: ");
        String genero = entrada.nextLine();
        System.out.print("Nome: ");
        String nome = entrada.nextLine();
        System.out.print("Idioma: ");
        String idioma = entrada.nextLine();
        System.out.print("Data de lançamento (dd/MM/yyyy): ");
        String dataLancamentoStr = entrada.nextLine();
        LocalDate dataLancamento = LocalDate.parse(dataLancamentoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.print("Quantidade de episódios: ");
        int quantidadeEpisodios = entrada.nextInt();
        app.adicionarMidia(new Serie(id, genero, nome, idioma, dataLancamento, quantidadeEpisodios));
    }

    public static void adicionarFilme() {
        System.out.print("id: ");
        int id = entrada.nextInt();
        entrada.nextLine(); // Limpar o buffer do scanner
        System.out.print("Gênero: ");
        String genero = entrada.nextLine();
        System.out.print("Nome: ");
        String nome = entrada.nextLine();
        System.out.print("Idioma: ");
        String idioma = entrada.nextLine();
        System.out.print("Data de lançamento (dd/MM/yyyy): ");
        String dataLancamentoStr = entrada.nextLine();
        LocalDate dataLancamento = LocalDate.parse(dataLancamentoStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.print("Duração (min): ");
        int duracao = entrada.nextInt();
        app.adicionarMidia(new Filme(id, genero, nome, idioma, dataLancamento, duracao));
    }

    public static void adicionarCliente() {
        entrada.nextLine(); // Limpar o buffer do scanner
        System.out.print("Nome: ");
        String nome = entrada.nextLine();
        System.out.print("Login: ");
        String login = entrada.nextLine();
        System.out.print("Senha: ");
        String senha = entrada.nextLine();
        app.adicionarCliente(new Cliente(nome, login, senha));
    }

    public static void adicionarAudiencia() {
        entrada.nextLine(); // Limpar o buffer do scanner
        System.out.print("A mídia já foi assistida? (s/n) ");
        boolean assistida = entrada.nextLine().contains("s");
        System.out.print("Id da mídia: ");
        int idMidia = entrada.nextInt();
        app.registrarAudiencia(assistida, app.buscarMidia(idMidia), true);
    }

    public static void menuAdicionarOpcao(int opcao) {
        switch (opcao) {
            case 1:
                adicionarSerie();
                break;
            case 2:
                adicionarFilme();
                break;
            case 3:
                adicionarCliente();
                break;
            case 4:
                adicionarAudiencia();
                break;
            default:
                System.out.println("Opção inválida, tente novamente.");
                break;
        }
    }
}