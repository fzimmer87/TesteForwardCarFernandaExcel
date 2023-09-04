package pom.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.*;

public class Excel {
    public static FileInputStream fi;
    public static FileOutputStream fo;
    public static XSSFWorkbook wb;
    public static XSSFSheet ws;
    public static XSSFRow row;
    public static XSSFCell cell;


    public enum dados{
        NOME,
        DESCRICAO,
        IMPORTANTE,
        LIDO
    }

    public static int getCellDadosPlanilha(String xlFile, String xlSheet, String nomePasta) throws Exception {
        DataFormatter formatter = new DataFormatter();

        fi = new FileInputStream(xlFile);
        wb = new XSSFWorkbook(fi);
        ws = wb.getSheet(xlSheet);

        int rowCount = ws.getLastRowNum();

        PrintWriter arq = ArquivoTxt.abrirArquivo(nomePasta, "Dados_Excel");

        for(int i = 1; i <= rowCount; i++) {
                row = ws.getRow(i);

                if (row == null) {
                    wb.close();
                    fi.close();
                    return 0;
                }

                ArquivoTxt.escreverTexto(Integer.toString(i), "NOME", formatter.formatCellValue(row.getCell(dados.NOME.ordinal())), arq);
                ArquivoTxt.escreverTexto(Integer.toString(i), "DESCRICAO", formatter.formatCellValue(row.getCell(dados.DESCRICAO.ordinal())), arq);
                ArquivoTxt.escreverTexto(Integer.toString(i), "IMPORTANTE", formatter.formatCellValue(row.getCell(dados.IMPORTANTE.ordinal())), arq);
                ArquivoTxt.escreverTexto(Integer.toString(i), "LIDO", formatter.formatCellValue(row.getCell(dados.LIDO.ordinal())), arq);
        }

        ArquivoTxt.fecharArquivo(arq);


        wb.close();
        fi.close();

        return rowCount;
    }
}
