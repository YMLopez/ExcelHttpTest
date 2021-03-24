package com.fl.controller;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.io.*;

/**
 * Created by Administrator on 2017/9/30.
 */
public class ReadExcel {

    public static void main(String[] args) {
        //读Excel
        //readExcel();

        //测试请求网络
        //Test.toGetFromUrl("https://apis.17wo.cn/flowq-web/#/goods/goodsOrder?productId=1016010&wealthUserId=326518&rebateType=2");

        //Test.toGetFromUrl("https://apis.17wo.cn/share-center-flowq/order/orderbyphonebill");

        MultiValueMap<String, String> params0 = new LinkedMultiValueMap<>();
        params0.add("date", "3/25");
        //Test.toPostFromUrl("http://v.juhe.cn/todayOnhistory/queryEvent.php", params0);

        Test.test();
        //Test.test2();
    }

    private static void readExcel() {
        ReadExcel readExcel = new ReadExcel();
        // Excel路径：xls格式为97~03年的Excel兼容格式
        File file = new File("D:\\\\Excels\\\\广东联通号码60K.xls");
        readExcel.readExcel(file);
    }

    // 去读Excel的方法readExcel，该方法的入口参数为一个File对象
    public void readExcel(File file) {
        System.out.println(Thread.currentThread().getId() + "\tThread Name: " + Thread.currentThread().getName());
        try {
            // 创建输入流，读取Excel
            InputStream is = new FileInputStream(file.getAbsolutePath());
            // jxl提供的Workbook类
            Workbook wb = Workbook.getWorkbook(is);
            // Excel的页签数量
            int sheet_size = wb.getNumberOfSheets();
            for (int index = 0; index < sheet_size; index++) {
                // 每个页签创建一个Sheet对象
                Sheet sheet = wb.getSheet(index);
                // sheet.getRows()返回该页的总行数
                for (int i = 0; i < sheet.getRows(); i++) {
                    // sheet.getColumns()返回该页的总列数
                    for (int j = 0; j < sheet.getColumns(); j++) {
                        String cellinfo = sheet.getCell(j, i).getContents();
                        System.out.print(cellinfo + "\t");
                    }
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
