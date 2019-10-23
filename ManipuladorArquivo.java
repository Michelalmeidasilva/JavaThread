

import java.io.*;

public class ManipuladorArquivo implements Runnable{
     private long palavras;
     private String nome;

    public ManipuladorArquivo(String nome){
        this.nome = nome;
     }

    public static long contaPalavras(String linha){
        long numeropalavras=0;
        int indice = 0;
        boolean espacoembranco = true;
        while(indice < linha.length()){
            char c = linha.charAt(indice++);
            boolean espacoembrancoatual = Character.isWhitespace(c);
            if(espacoembranco && !espacoembrancoatual){
                numeropalavras++;
            }
            espacoembranco = espacoembrancoatual;
        }
        return numeropalavras;
    }

    public void leitor(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        while (true) {
            if (linha != null) {
                this.palavras = this.palavras + contaPalavras(linha);
            } else
                break;
            linha = buffRead.readLine();
        }
        buffRead.close();
    }

    @Override
    public void run() {
        try {
            System.out.println("nome = " + this.nome);
            leitor(this.nome);
            System.out.println("Quantidade de palavras é : " + this.palavras);
        } catch (IOException var4) {
            var4.printStackTrace();
        }
    }
}