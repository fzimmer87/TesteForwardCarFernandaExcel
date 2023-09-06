package utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.*;

public class Excel {

    public static final String caminho = "C:\\ProjetosBN\\Projetos individuais\\ProjetoGrupo\\ApiFernandaeEdson\\TesteForwardCarFernandaeEdson\\src\\excel";
    public static FileInputStream fi;
    public static FileOutputStream fo;
    public static XSSFWorkbook wb;
    public static XSSFSheet ws;
    public static XSSFRow row;
    public static XSSFCell cell;


    public enum dados {
        firstname,
        lastname,
        usarname,
        password
    }

    public static int getCellDadosPlanilha(String xlFile, String xlSheet) throws Exception {
        DataFormatter formatter = new DataFormatter();

        fi = new FileInputStream(caminho + "\\" + xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);

        int rowCount = ws.getLastRowNum();

        PrintWriter arq = ArquivoTxt.abrirArquivo(caminho, "ForwardCar");

        for (int i = 1; i <= rowCount; i++) {
            row = ws.getRow(i);

            if (row == null){
                wb.close();
                fi.close();
                ArquivoTxt.fecharArquivo(arq);
                return i - 1;
            }

            ArquivoTxt.escreverTexto(Integer.toString(i), "firstname", formatter.formatCellValue(row.getCell(dados.firstname.ordinal())), arq);
            ArquivoTxt.escreverTexto(Integer.toString(i), "lastname", formatter.formatCellValue(row.getCell(dados.lastname.ordinal())), arq);
            ArquivoTxt.escreverTexto(Integer.toString(i), "usarname", formatter.formatCellValue(row.getCell(dados.usarname.ordinal())), arq);
            ArquivoTxt.escreverTexto(Integer.toString(i), "password", formatter.formatCellValue(row.getCell(dados.password.ordinal())), arq);
        }

        ArquivoTxt.fecharArquivo(arq);


        wb.close();
        fi.close();

        return rowCount;
    }
    public enum dadosComMesmoUsarname {
        firstname,
        lastname,
        usarname,
        password
    }

    public static int getCellDadosPlanilha2(String xlFile, String xlSheet) throws Exception {
        DataFormatter formatter = new DataFormatter();

        fi = new FileInputStream(caminho + "\\" + xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);

        int rowCount = ws.getLastRowNum();

        PrintWriter arq = ArquivoTxt.abrirArquivo(caminho, "ForwardCar2");

        for (int i = 1; i <= rowCount; i++) {
            row = ws.getRow(i);

            if (row == null){
                wb.close();
                fi.close();
                ArquivoTxt.fecharArquivo(arq);
                return i - 1;
            }

            ArquivoTxt.escreverTexto(Integer.toString(i), "firstname", formatter.formatCellValue(row.getCell(dadosComMesmoUsarname.firstname.ordinal())), arq);
            ArquivoTxt.escreverTexto(Integer.toString(i), "lastname", formatter.formatCellValue(row.getCell(dadosComMesmoUsarname.lastname.ordinal())), arq);
            ArquivoTxt.escreverTexto(Integer.toString(i), "usarname", formatter.formatCellValue(row.getCell(dadosComMesmoUsarname.usarname.ordinal())), arq);
            ArquivoTxt.escreverTexto(Integer.toString(i), "password", formatter.formatCellValue(row.getCell(dadosComMesmoUsarname.password.ordinal())), arq);
        }

        ArquivoTxt.fecharArquivo(arq);


        wb.close();
        fi.close();

        return rowCount;
    }


    public enum dadosParaLogin {
        usarname,
        password
    }

    public static int getCellDadosPlanilhaTeste3(String xlFile, String xlSheet) throws Exception {
        DataFormatter formatter = new DataFormatter();

        fi = new FileInputStream(caminho + "\\" + xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);

        int rowCount = ws.getLastRowNum();

        PrintWriter arq = ArquivoTxt.abrirArquivo(caminho, "ForwardCar");

        for (int i = 1; i <= rowCount; i++) {
            row = ws.getRow(i);

            if (row == null){
                wb.close();
                fi.close();
                ArquivoTxt.fecharArquivo(arq);
                return i - 1;
            }

            ArquivoTxt.escreverTexto(Integer.toString(i), "usarname", formatter.formatCellValue(row.getCell(dadosParaLogin.usarname.ordinal())), arq);
            ArquivoTxt.escreverTexto(Integer.toString(i), "password", formatter.formatCellValue(row.getCell(dadosParaLogin.password.ordinal())), arq);
        }

        ArquivoTxt.fecharArquivo(arq);


        wb.close();
        fi.close();

        return rowCount;
    }
}
