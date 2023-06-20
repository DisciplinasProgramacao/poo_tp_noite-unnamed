import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
// import java.time.String;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class LeitorArquivo {

    public static Streaming lerArquivos(Streaming app) {
        try {
            lerArquivoEspectadores(app);
            lerArquivoSeries(app);
            lerArquivoFilmes(app);
            // lerArquivoAudiencia(app);
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo não encontrado.");
            System.out.println(e);
        }

        return app;
    }

    private static void lerArquivoEspectadores(Streaming app) throws FileNotFoundException {
        Scanner ler = new Scanner(new File("C:\\Users\\Pichau\\Documents\\programacao\\Streaming POO\\Arquivos\\POO_Espectadores.csv")).useDelimiter(";|\n");

        while (ler.hasNext()) {
            String nome = ler.next();
            String login = ler.next();
            String senha = ler.next();
            app.adicionarCliente(new Cliente(nome, login, senha));
        }

        ler.close();
    }

    private static void lerArquivoSeries(Streaming app) throws FileNotFoundException {
        Scanner ler = new Scanner(new File("C:\\Users\\Pichau\\Documents\\programacao\\Streaming POO\\Arquivos\\POO_Series.csv")).useDelimiter(";|\n");

        while (ler.hasNext()) {
            String ids = ler.next().replaceAll("\\D+", "");;
            int id = Integer.parseInt(ids);
            String nome = ler.next();
            String data = ler.next();
            // String dataLancamento = String.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            app.adicionarMidia(new Serie(id, nome, data));
        }

        ler.close();
    }

    private static void lerArquivoFilmes(Streaming app) throws FileNotFoundException {
        Scanner ler = new Scanner(new File("C:\\Users\\Pichau\\Documents\\programacao\\Streaming POO\\Arquivos\\POO_Filmes.csv")).useDelimiter(";|\n");

        while (ler.hasNext()) {
            String ids = ler.next();
            ids = ids.replaceAll("\\D+", "");
            System.out.println (ids);
            int id = Integer.parseInt(ids);
            String nome = ler.next();
            String dataLancamento = ler.next();
            String duracaos = ler.next();
            // int duracao = Integer.parseInt(duracaos);
            Filme filme = new Filme(id, nome, dataLancamento, duracaos);
            app.adicionarMidia(filme);
            System.out.print(filme); 
        }

        ler.close();
    }

    private static void lerArquivoAudiencia(Streaming app) throws FileNotFoundException {
        Scanner ler = new Scanner(new File("Arquivos\\POO_Audiencia.csv")).useDelimiter(";|\n");

        while (ler.hasNext()) {
            String login = ler.next();
            app.login(login, null, true);

            boolean serieAssistida = ler.next().charAt(0) == 'A';

            int idMidia = Integer.parseInt(ler.next());
            IConteudos midia = app.buscarMidia(idMidia);

            app.registrarAudiencia(serieAssistida, midia, false);
        }

        app.logOff();
        ler.close();
    }
}