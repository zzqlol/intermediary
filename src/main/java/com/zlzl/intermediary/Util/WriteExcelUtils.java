package com.zlzl.intermediary.Util;

import com.zlzl.intermediary.entity.HouseBasics;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class WriteExcelUtils {
    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";

    public static void writeExcel(List<HouseBasics> list, String fullFileName) {
        Workbook workBook = null;
        OutputStream out = null;
        Sheet sheet = null;
        Row row = null;

        try {
            // 创建Excel文档
            File file = new File(fullFileName);
            if (!file.exists()) {
                // 判断父目录是否存在
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();// 多层目录创建
                }
                if (file.getName().endsWith(EXCEL_XLS)) { // Excel 2003
                    workBook = new HSSFWorkbook();
                } else if (file.getName().endsWith(EXCEL_XLSX)) { // Excel // 2007/2010
                    workBook = new XSSFWorkbook();
                }

                // 创建sheet对象
                sheet = (Sheet) workBook.createSheet("sheet1");
                out = new FileOutputStream(fullFileName);
                workBook.write(out);
                out.flush();
                out.close();
            } else {
                if (file.getName().endsWith(EXCEL_XLS)) { // Excel 2003
                    workBook = new HSSFWorkbook();
                } else if (file.getName().endsWith(EXCEL_XLSX)) { // Excel // 2007/2010
                    workBook = new XSSFWorkbook();
                }
            }

            if (sheet == null) {
                sheet = workBook.createSheet("sheet1");
            }

            // 设置标题行
                row = sheet.createRow(0);
                row.createCell((short) 0).setCellValue("登记日期");
                row.createCell((short) 1).setCellValue("状态");
                row.createCell((short) 2).setCellValue("户型结构");
                row.createCell((short) 3).setCellValue("面积");
                row.createCell((short) 4).setCellValue("楼高");
                row.createCell((short) 5).setCellValue("层高");
                row.createCell((short) 6).setCellValue("小区名");
                row.createCell((short) 7).setCellValue("地域名");
                row.createCell((short) 8).setCellValue("装修程度");
                row.createCell((short) 9).setCellValue("用途");
                row.createCell((short) 10).setCellValue("置业顾问");
                row.createCell((short) 11).setCellValue("详细地址");
                row.createCell((short) 12).setCellValue("出租价格");
                row.createCell((short) 13).setCellValue("出租说明");
                row.createCell((short) 14).setCellValue("出售价格");
                row.createCell((short) 15).setCellValue("出售说明");
                row.createCell((short) 16).setCellValue("基础设施");
                row.createCell((short) 17).setCellValue("配套设施");
                row.createCell((short) 18).setCellValue("详细说明");
                row.createCell((short) 19).setCellValue("业主姓名");
                row.createCell((short) 20).setCellValue("联系电话");
                row.createCell((short) 21).setCellValue("联系手机");
                row.createCell((short) 22).setCellValue("具体地址");

            for (int j = 1; j <= list.size(); j++) {
                row = sheet.createRow(j);
                HouseBasics houseBasics = list.get(j - 1);
                row.createCell((short) 0).setCellValue(houseBasics.getRegisterDate());
                row.createCell((short) 1).setCellValue(houseBasics.getState());
                row.createCell((short) 2).setCellValue(houseBasics.getStructure());
                row.createCell((short) 3).setCellValue(houseBasics.getArea());
                row.createCell((short) 4).setCellValue(houseBasics.getFloorHeight());
                row.createCell((short) 5).setCellValue(houseBasics.getFloor());
                row.createCell((short) 6).setCellValue(houseBasics.getVid());
                row.createCell((short) 7).setCellValue(houseBasics.getRid());
                row.createCell((short) 8).setCellValue(houseBasics.getDecoration());
                row.createCell((short) 9).setCellValue(houseBasics.getPurpose());
                row.createCell((short) 10).setCellValue(houseBasics.getUid());
                row.createCell((short) 11).setCellValue(houseBasics.getDetailedAdd());
                row.createCell((short) 12).setCellValue(houseBasics.getRentalPrice());
                row.createCell((short) 13).setCellValue(houseBasics.getRentalExplain());
                row.createCell((short) 14).setCellValue(houseBasics.getSellPrice());
                row.createCell((short) 15).setCellValue(houseBasics.getSellExplain());
                row.createCell((short) 16).setCellValue(houseBasics.getInfrastructure());
                row.createCell((short) 17).setCellValue(houseBasics.getFacilities());
                row.createCell((short) 18).setCellValue(houseBasics.getDetailed());
                row.createCell((short) 19).setCellValue(houseBasics.getOwner());
                row.createCell((short) 20).setCellValue(houseBasics.getMobilePhone());
                row.createCell((short) 21).setCellValue(houseBasics.getTelephone());
                row.createCell((short) 22).setCellValue(houseBasics.getSpecificAddress());
            }
            // 创建文件输出流，准备输出电子表格
            out = new FileOutputStream(fullFileName);
            workBook.write(out);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
