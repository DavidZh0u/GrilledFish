package com.fish;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.io.FileInputStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PoiFishModelApplicationTests {

    private static String sqlObj = "insert into `serve_hotel` (`city`,`hotel_id`,`hotel_name`,`brand_name`,`type_name`,`hotel_address`,`opening_hours`, `operating_state`,`is_delete`,`modify_user`,`update_time`,`hotel_lat`,`hotel_lng` ) values ";
    private static String sqlTwo = "insert into `serve_hotel_desc`(`hotel_id`,`serve_type`,`is_use`,`modify_user`,`update_time`) values ";
    @Test
    public void contextLoads() {
    }

    @Test
    public void poiTestMethod() throws Exception {


        //1.读取Excel文档对象
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream("C:\\Users\\David-PC\\Desktop\\需求\\2019-1-10 110217\\北京新增&天津地区酒店经纬度信息_20190109.xlsx"));
        //2.获取要解析的表格（第一个表格）
        XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
        //获得最后一行的行号
        int lastRowNum = sheet.getLastRowNum();
        for (int i = 0; i <= lastRowNum; i++) {//遍历每一行
            //3.获得要解析的行
            XSSFRow row = sheet.getRow(i);
            //4.获得每个单元格中的内容（String）

            int len = row.getLastCellNum();
            StringBuffer sbf = new StringBuffer();
            sbf.append(sqlTwo).append(" (");
            /*sbf.append("'天津'").append(",");*/
            /*('北京市','1000008','汉庭北京站前广场酒店','汉庭','加盟','北京市东城区北京站东街8号','全天',0,0,'admin',SYSDATE(),'116.432','39.9042');*/
            /*('1000008',1,1,'admin',SYSDATE());*/
            for(int j = 0 ; j < len ; j++){
                XSSFCell cell = row.getCell(j);
                if(!StringUtils.isEmpty(cell)){
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    if(j == 0){
                        sbf.append("'").append(cell.getStringCellValue()).append("'").append(",");
                        sbf.append("1").append(",");
                        sbf.append("1").append(",");
                        sbf.append("'admin'").append(",");
                        sbf.append("SYSDATE()").append(",");
                    }
                    /*if(j != 4 && j != 6 && j != 7){
                        sbf.append("'").append(cell.getStringCellValue()).append("'").append(",");
                        if(j==5){
                            sbf.append("'全天'").append(",");
                            sbf.append("0").append(",");
                            sbf.append("0").append(",");
                            sbf.append("'admin'").append(",");
                            sbf.append("SYSDATE()").append(",");
                        }

                    }*/


                }
            }
            String strs = sbf.toString();
            strs = strs.substring(0,strs.length()-1);
            strs = strs + ");";
            System.out.println(strs);
            /*insert into `serve_hotel` (`city`,`hotel_id`,`hotel_name`,`brand_name`,`type_name`,`hotel_address`,`opening_hours`, `operating_state`,`is_delete`,`modify_user`,`update_time`, `hotel_lng`, `hotel_lat`)
            values
            ('北京市','1000008','汉庭北京站前广场酒店','汉庭','加盟','北京市东城区北京站东街8号','全天',0,0,'admin',SYSDATE(),'116.432','39.9042');*/
//            String stringCellValue0 = row.getCell(0).getStringCellValue();
//            String stringCellValue1 = row.getCell(1).getStringCellValue();
//            String stringCellValue2 = row.getCell(2).getStringCellValue();
//            String stringCellValue3 = row.getCell(3).getStringCellValue();
//            String stringCellValue4 = row.getCell(4).getStringCellValue();
//            String stringCellValue5 = row.getCell(5).getStringCellValue();
//            String stringCellValue6 = row.getCell(6).getStringCellValue();
//            String stringCellValue7 = row.getCell(7).getStringCellValue();
//            String stringCellValue8 = row.getCell(8).getStringCellValue();
//            String stringCellValue9 = row.getCell(9).getStringCellValue();
//            System.out.println(stringCellValue0+"--"+stringCellValue1+"--"+stringCellValue2+"--"+stringCellValue3+"--"+stringCellValue4);
        }
    }


}

