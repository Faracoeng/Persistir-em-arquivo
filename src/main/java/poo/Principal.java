package poo;

import java.io.*;
import java.util.Scanner;

public class Principal {
    public void imprimeConteudoArquivo(String nomeArquivo) {
        File arquivo = new File(nomeArquivo);
        try {
            Scanner leitor = new Scanner(arquivo);
            while (leitor.hasNext()) {
                String linha = leitor.nextLine();
                System.out.println(linha);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void escrever(String linha) {//throws IOException {

        String nomeArquivo = "teste.txt";

        File arq = new File(nomeArquivo);
        FileWriter fwArquivo = null;
        BufferedWriter bw;
        try {
            if (!arq.exists()) {

                fwArquivo = new FileWriter(arq, !arq.exists()); //parametro do tipo FILE
                bw = new BufferedWriter(fwArquivo);
                bw.write(linha + "\n");
                bw.close();
                fwArquivo.close();


            } else {
                // se true, ele concatena, se false ele cria ou zera o arquivo

                fwArquivo = new FileWriter(arq, true); //parametro do tipo FILE
                bw = new BufferedWriter(fwArquivo);
                bw.write(linha + "\n");
                bw.close();
                fwArquivo.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void salvarPessoa(Pessoa p, String nomeArquivo) {
        File arq = new File(nomeArquivo);
        try {

            FileOutputStream fout = new FileOutputStream(arq);
            ObjectOutputStream oos = new ObjectOutputStream(fout);

            oos.writeObject(p);

            oos.flush(); //Descarregar o flush
            oos.close();
            fout.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public Pessoa lerPessoaDoDisco(String nomeArquivo) {
        File arq = new File(nomeArquivo);
        try {

            FileInputStream fis = new FileInputStream(arq);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Pessoa p = (Pessoa) ois.readObject();

            ois.close();
            fis.close();

            return p;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    return null;
    }




    public static void main(String[] args) {

        Pessoa alunos01 = new Pessoa("Andre", "alfmazucheli@g...", 1600);
        // Pessoa alunos02 = new Pessoa("Alexandre" ,"enolagay@g...",1800);
        String linha = alunos01.toString();
        String[] vetor = linha.split(",");
        for (String e : vetor) {
            System.out.println(e);
        }


        Principal invoc = new Principal();
        //salvando
        invoc.escrever("\n");
        invoc.escrever(alunos01.toString());
        //   invoc.escrever(alunos02.toString());
        //escrevendo
        invoc.imprimeConteudoArquivo("teste.txt");
        //Salvando
        invoc.salvarPessoa(alunos01, "teste.txt");
        //lendo pessoa
       invoc.escrever(invoc.lerPessoaDoDisco("teste.txt").toString());
        System.out.println("aqui --------> "+invoc.lerPessoaDoDisco("teste.txt").toString());

    }
}
