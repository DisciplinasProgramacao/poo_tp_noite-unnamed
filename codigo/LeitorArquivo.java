import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * A classe LeitorArquivo recebe um parâmetro genérico T, que representa o tipo de objeto que será criado a partir do arquivo. O método lerArquivo recebe o caminho do arquivo a ser lido e um objeto do tipo CriadorDeObjeto, que é uma interface funcional que será utilizada para criar o objeto a partir dos dados lidos do arquivo.
 * 
 * 
 * A interface CriadorDeObjeto também é parametrizada, recebendo o tipo do objeto a ser criado. Ela possui um único método criarObjeto que recebe um array de strings contendo os dados lidos do arquivo e retorna um objeto do tipo T. Dessa forma, é possível criar diferentes implementações dessa interface para criar objetos de diferentes classes.
 * 
 * 
 * Para utilizar essa classe para ler os dados dos espectadores, podemos criar uma classe que implementa a interface CriadorDeObjeto e define como criar um objeto do tipo Cliente.
 */

public class LeitorArquivo<T> {
    
    /**
     *  Método para ler arquivos passados por parametro
     * 
     * @param caminhoArquivo caminho do arquivo
     * @param criadorDeObjeto objeto criado e passado por parametro
     * @return retorna uma lista de objetos
     * @throws FileNotFoundException
     */
    public List<T> lerArquivo(String caminhoArquivo, CriadorDeObjeto<T> criadorDeObjeto) throws FileNotFoundException {
        List<T> objetos = new ArrayList<>();
        Scanner ler = new Scanner(new File(caminhoArquivo));
        ler.nextLine(); // descarta a primeira linha
        while (ler.hasNextLine()) {
            String[] dados = ler.nextLine().split(";");
            T objeto = criadorDeObjeto.criarObjeto(dados);
            objetos.add(objeto);
        }
        ler.close();
        return objetos;
    }
    
    public interface CriadorDeObjeto<T> {
        T criarObjeto(String[] dados);
    }
}