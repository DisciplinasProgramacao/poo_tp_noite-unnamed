import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Classe usado para ler e escrever os arquivos csv da plataforma de streaming.
 */
final public class LeitorArquivo {

    /**
     * Le os arquivos Arquivos/POO_Audiencia.csv, Arquivos/POO_Series.csv e Arquivos/POO_Espectadores.csv e
     * os carrega na plataforma.
     * 
     * @param app plataforma de streaming com ou sem dados
     * @return plataforma de streaming com os dados já existentes + dados lidos
     */
    public static Streaming lerArquivos(Streaming app) {
        try {
            //========Espectadores========
            Scanner ler = new Scanner(new File("Arquivos/POO_Espectadores.csv")).useDelimiter(";|\\n");

            while (ler.hasNext())
                app.adicionarCliente(new Cliente(ler.next(), // Nome
                        ler.next(), // Login
                        ler.next() // Senha
                ));
            ler.close();

            //========Series========
            ler = new Scanner(new File("Arquivos/POO_Series.csv")).useDelimiter(";|\\n");

            while (ler.hasNext()) {
                app.adicionarMidia(new Serie(
                        Integer.parseInt(ler.next()), // Id
                        ler.next(), // Nome
                        LocalDate.parse(ler.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy")) // DataDeLançamento
                ));
            }
            ler.close();

            //========Filmes========
            ler = new Scanner(new File("Arquivos/POO_Filmes.csv")).useDelimiter(";|\\n");

            while (ler.hasNext())
                app.adicionarMidia(new Filme(
                        Integer.parseInt(ler.next()), // Id
                        ler.next(), LocalDate.parse(ler.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy")), 
                        Integer.parseInt(ler.next()) 
                ));
            ler.close();

            //========Audiencia========
            ler = new Scanner(new File("Arquivos/POO_Audiencia.csv")).useDelimiter(";|\\n");

            while (ler.hasNext()) {
                app.login(ler.next(), null, true);
                app.registrarAudiencia(ler.next().charAt(0) == 'A', app.buscarMidia(Integer.parseInt(ler.next())),
        false //Nao ha nota na leiura do arquivo
                );
            }
            app.logOff();
            ler.close();
        } catch (FileNotFoundException e) {
            System.out.println(" Arquivo não encontrado.");
        }

        return app;
    }
}