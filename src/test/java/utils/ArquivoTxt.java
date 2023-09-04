package pom.utils;

import pom.DTO.ApiDTO;
import pom.DTO.TaskDTO;

import java.io.*;

public class ArquivoTxt {

    public static PrintWriter abrirArquivo(String nomePasta, String nomeArquivo) throws IOException {
        FileWriter arq = new FileWriter(nomePasta + "\\" + nomeArquivo + ".txt");
        PrintWriter gravarArq = new PrintWriter(arq);

        return gravarArq;
    }

    public static void escreverTexto(String linha, String titulo, String valor, PrintWriter gravarArq){
        gravarArq.printf(titulo + "_" + linha + ": ");
        gravarArq.printf(valor + "%n");
    }

    public static void fecharArquivo(PrintWriter gravarArq){
        gravarArq.close();
    }

    public static String lerArquivo(TaskDTO pixDTO, String busca){
        try {
            FileReader arq = new FileReader(pixDTO.getNomePasta() + "\\Dados_Excel.txt");
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine(); // lê a primeira linha

            while (linha != null) {
                if(linha.split(":")[0].equals(busca)) {
                    arq.close();
                    return linha.split(":")[1].trim();
                }

                linha = lerArq.readLine();
            }

            arq.close();

            return null;

        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }

        return null;
    }

    private static PrintWriter evidenciaPadrao(ApiDTO apiDTO, PrintWriter arq){
        ArquivoTxt.escreverTexto("","URI", apiDTO.getUrl(), arq);
        if(apiDTO.getParams() != null) ArquivoTxt.escreverTexto("","PARAMS", apiDTO.getParams().toString(), arq);
        if(apiDTO.getHeader() != null) ArquivoTxt.escreverTexto("","HEADER", apiDTO.getHeader().toString(), arq);
        if(apiDTO.getBody() != null) ArquivoTxt.escreverTexto("","BODY", apiDTO.getBody(), arq);
        ArquivoTxt.escreverTexto("","RESP", apiDTO.getResp().asString(), arq);
        ArquivoTxt.escreverTexto("","STATUS CODE", apiDTO.getResp().statusLine() , arq);

        return arq;
    }

    public static void escreverAPI(String nomePasta, String nomeArquivo, ApiDTO apiDTO) throws IOException {
        PrintWriter arq = ArquivoTxt.abrirArquivo(nomePasta, nomeArquivo);

        arq = evidenciaPadrao(apiDTO, arq);

        ArquivoTxt.fecharArquivo(arq);
    }

    public static void DeletaArquivo(String nomeArquivo){
        File file = new File(nomeArquivo);

        if (file.delete())
            System.out.println("File deleted");
        else
            System.out.println("File was not deleted");
    }
}
jetbrains://idea/navigate/reference?project=TesteForwardCarFernandaeEdson&path=~\Downloads\ArquivoTxt.java

