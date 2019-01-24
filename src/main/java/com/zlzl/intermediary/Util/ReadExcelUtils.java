package com.zlzl.intermediary.Util;

import com.zlzl.intermediary.entity.HouseBasics;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ReadExcelUtils {
    public static List<HouseBasics> read2007Xlsx(InputStream is) throws IOException {
        XSSFWorkbook xWorkbook = new XSSFWorkbook(is);
        List<HouseBasics> list = new ArrayList<>();
        // Read the Sheet
        XSSFSheet xssfSheet = xWorkbook.getSheetAt(0);
        // Read the Row
        for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
            XSSFRow xssfRow = xssfSheet.getRow(rowNum);
            if (xssfRow != null) {
                HouseBasics houseBasics = new HouseBasics();
                houseBasics.setRegisterDate(xssfRow.getCell(0).getStringCellValue());//s
                houseBasics.setState(xssfRow.getCell(1).getStringCellValue());//s
                houseBasics.setStructure(xssfRow.getCell(2).getStringCellValue());//s
                houseBasics.setArea(Integer.valueOf(xssfRow.getCell(3).getStringCellValue()));//i
                houseBasics.setFloor(Integer.valueOf(xssfRow.getCell(4).getStringCellValue()));//i
                houseBasics.setFloorHeight(Integer.valueOf(xssfRow.getCell(5).getStringCellValue()));
                houseBasics.setRid(Integer.valueOf(xssfRow.getCell(6).getStringCellValue()));
                houseBasics.setVid(Integer.valueOf(xssfRow.getCell(7).getStringCellValue()));
                houseBasics.setDecoration(xssfRow.getCell(8).getStringCellValue());
                houseBasics.setPurpose(xssfRow.getCell(9).getStringCellValue());
                houseBasics.setUid(Integer.valueOf(xssfRow.getCell(10).getStringCellValue()));
                houseBasics.setDetailedAdd(xssfRow.getCell(11).getStringCellValue());
                houseBasics.setRentalPrice(Integer.valueOf(xssfRow.getCell(12).getStringCellValue()));
                houseBasics.setRentalExplain(xssfRow.getCell(13).getStringCellValue());
                houseBasics.setSellPrice(Double.valueOf(xssfRow.getCell(14).getStringCellValue()));
                houseBasics.setSellExplain(xssfRow.getCell(15).getStringCellValue());
                houseBasics.setInfrastructure(xssfRow.getCell(16).getStringCellValue());
                houseBasics.setFacilities(xssfRow.getCell(17).getStringCellValue());
                houseBasics.setDetailed(xssfRow.getCell(18).getStringCellValue());
                houseBasics.setOwner(xssfRow.getCell(19).getStringCellValue());
                houseBasics.setTelephone(xssfRow.getCell(20).getStringCellValue());
                houseBasics.setMobilePhone(xssfRow.getCell(21).getStringCellValue());
                houseBasics.setSpecificAddress(xssfRow.getCell(22).getStringCellValue());
                list.add(houseBasics);
            }
        }
        xWorkbook.close();
        return list;
    }

    // HSSF -- 提供读写Microsoft Excel格式档案的功能。
    // HSSFWorkbook:是操作Excel2003以前（包括2003）的版本，扩展名是.xls
    public static List<HouseBasics> read2003Xls(InputStream is) throws IOException {
        HSSFWorkbook hWorkbook = new HSSFWorkbook(is);
        List<HouseBasics> list = new ArrayList<>();

        // Read the Sheet
        HSSFSheet hssfSheet = hWorkbook.getSheetAt(0);
        // Read the Row
        for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
            HSSFRow xssfRow = hssfSheet.getRow(rowNum);
            if (xssfRow != null) {
                    HouseBasics houseBasics = new HouseBasics();
                    houseBasics.setRegisterDate(String.valueOf(BigDecimal.valueOf(xssfRow.getCell(0).getNumericCellValue())));//s
                    houseBasics.setState(xssfRow.getCell(1).getStringCellValue());//s
                    houseBasics.setStructure(xssfRow.getCell(2).getStringCellValue());//s
                    houseBasics.setArea((int)xssfRow.getCell(3).getNumericCellValue());//i
                    houseBasics.setFloor((int)xssfRow.getCell(4).getNumericCellValue());//i
                    houseBasics.setFloorHeight((int)xssfRow.getCell(5).getNumericCellValue());
                    houseBasics.setRid((int)xssfRow.getCell(6).getNumericCellValue());
                    houseBasics.setVid((int)xssfRow.getCell(7).getNumericCellValue());
                    houseBasics.setDecoration(xssfRow.getCell(8).getStringCellValue());
                    houseBasics.setPurpose(xssfRow.getCell(9).getStringCellValue());
                    houseBasics.setUid((int)xssfRow.getCell(10).getNumericCellValue());
                    houseBasics.setDetailedAdd(xssfRow.getCell(11).getStringCellValue());
                    houseBasics.setRentalPrice((int)xssfRow.getCell(12).getNumericCellValue());
                    houseBasics.setRentalExplain(xssfRow.getCell(13).getStringCellValue());
                    houseBasics.setSellPrice(Double.valueOf(xssfRow.getCell(14).getNumericCellValue()));
                    houseBasics.setSellExplain(xssfRow.getCell(15).getStringCellValue());
                    houseBasics.setInfrastructure(xssfRow.getCell(16).getStringCellValue());
                    houseBasics.setFacilities(xssfRow.getCell(17).getStringCellValue());
                    houseBasics.setDetailed(xssfRow.getCell(18).getStringCellValue());
                    houseBasics.setOwner(xssfRow.getCell(19).getStringCellValue());
                    houseBasics.setTelephone(String.valueOf(BigDecimal.valueOf(xssfRow.getCell(20).getNumericCellValue())));
                    houseBasics.setMobilePhone(String.valueOf(BigDecimal.valueOf(xssfRow.getCell(21).getNumericCellValue())));
                    houseBasics.setSpecificAddress(xssfRow.getCell(22).getStringCellValue());
                    list.add(houseBasics);
                }
            }
            hWorkbook.close();
            return list;
        }
}
