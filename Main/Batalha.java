package Main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Batalha {
    private BufferedReader conteudoCsv = null;

    private String linha;

    private String separador = "\t";

    private String [][] tabelaEspecie = new String[153][9];
    private String [][] tabelaAtaque = new String[167][8];


    public void carregarTabelas(String arq, int chave){
        int i = 0, j = 0;

        try {
            conteudoCsv = new BufferedReader(new FileReader(arq));//abre arquivo e cria objeto
            while ((linha = conteudoCsv.readLine()) != null) {
                String[] camposLidos = linha.split(separador);
                for (String s : camposLidos) {
                    if (chave == 1)
                        tabelaEspecie[i][j++] = s;
                    else if (chave == 2)
                        tabelaAtaque[i][j++] = s;
                }
                j = 0;
                i++;
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Arquivo nao encontrado: \n" + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Indice fora do limite: \n" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro de IO: \n" + e.getMessage());
        } finally {
            //if (conteudoCsv);
            //
        }

    }

    public void inicializarJogadores(){

    }

    public void executarTurno(){

    }

    public void printaAtaque(){
        for(int i = 0; i < 167; i++){
            for (int j = 0; j < 8; j++)
                System.out.printf(tabelaAtaque[i][j] + "\t");
            System.out.println();
        }
        System.out.println();
    }

    public void printaEspecie(){
        for(int i = 0; i < 153; i++){
            for (int j = 0; j < 8; j++)
                System.out.printf(tabelaEspecie[i][j] + "\t");
            System.out.println();
        }
        System.out.println();
    }
}
