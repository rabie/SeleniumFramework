package com.tmb.utils;

import com.tmb.constants.FrameworkConstants;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ExcelUtils {

    private ExcelUtils(){}

    public static List<Map<String, String>> getTestDetails(String sheetName){
        List<Map<String, String>> list = new ArrayList<>();
        Map<String, String> map;
        List<String> header = new ArrayList<>();
        try(XSSFWorkbook workbook = new XSSFWorkbook(new File(FrameworkConstants.getExcelpath()))){

            XSSFSheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getLastRowNum();
            int columnCount = sheet.getRow(0).getLastCellNum();

            for (int i = 0; i <= rowCount ; i++) {
                map = new LinkedHashMap<>();
                for (int j = 0; j <columnCount ; j++) {
                    if (i == 0){
                        header.add(sheet.getRow(i).getCell(j).getStringCellValue());
                    }else{
                        map.put(header.get(j),sheet.getRow(i).getCell(j).getStringCellValue());
                    }
                }
                if (!map.isEmpty()){
                    list.add(map);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(getTestDetails("DATA"));
    }

}
