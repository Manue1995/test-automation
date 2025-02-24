package com.OrangeHRM_TestAutomation.utils;


import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Excel {

    private XSSFWorkbook libro;
    private FileInputStream file;

    public String leerDatosExcel (String ruta, String hoja, int rowValue, int cellValue) throws IOException {
        String valor = null;
        file= new FileInputStream(new File(ruta));
        libro=new XSSFWorkbook(file);
        Sheet sheet = libro.getSheet(hoja);
        //Row row = sheet.getRow(rowValue);
        //Cell cell = row.getCell(cellValue);

        XSSFCell cell = (XSSFCell) sheet.getRow(rowValue).getCell(cellValue);

        if (cell != null ) {

            CellType cellType = cell.getCellType();

            if (cellType.toString() == "STRING") {

                valor = cell.getStringCellValue();


            } else if (cellType.toString() == "NUMERICO") {

                valor = String.valueOf(cell.getNumericCellValue());

            }
        }
        //valor = cell.getStringCellValue();
        libro.close();
        file.close();
        return valor;

    }
}
