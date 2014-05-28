/*
 * @(#) ResumePowerData ExcelTools.java Jan 7, 2014
 *
 * Copyright 2014 CDSF Corporation, Inc. All rights reserved.
 */
package com.jcc.demo.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * <p>Title: ExcelTools.java</p>
 * <p>Description: </p>
 * <p>Copyright:Copyright(c)2014</p>
 * <p>Company: 成都四方</p>
 * <p>CreateTime:Jan 7, 2014 8:44:01 AM</p>
 * @author chenjiacheng
 * @version 1.0
 **/
public class ExcelTools {
   
    /**
     * 创建Excel
     * @author chenjiacheng
     * @creaetime Jan 10, 2014 11:27:19 AM
     * @param filePath
     * @param list
     */
    public static void createExcel(String filePath,List<PowerFlowChatBean> list){
        int eachRowCellCount = 6;
        HSSFWorkbook book = new HSSFWorkbook();
        HSSFSheet sheet = book.createSheet();
        //获取第一行
        HSSFRow firstRow = sheet.createRow(0);
        //定义6个单元格的数组
        HSSFCell[] firstCells = new HSSFCell[eachRowCellCount];
        String[] header = new String[eachRowCellCount];
        header[0] ="外部流程图ID";
        header[1] ="事项名称";
        header[2] ="权力事项编码";
        header[3] ="外部流程图名称";
        header[4] ="所属部门";
        header[5] ="所属地区";
        if(eachRowCellCount == 7){
            header[6] ="外部流程图Key";
        }
        //为首行每个单元格设置数据
        for(int i =0;i<eachRowCellCount;i++){
            firstCells[i] = firstRow.createCell(i);
            firstCells[i].setCellValue(new HSSFRichTextString(header[i]));     
        }
        
        if(list != null && !list.isEmpty()){
            //插入文档内容
            for(int i = 0;i<list.size();i++){
                 HSSFRow row = sheet.createRow(i+1);
                 PowerFlowChatBean bean = list.get(i);
                 HSSFCell powerId = row.createCell(0);
                 powerId.setCellValue(bean.getPowerId());
                 HSSFCell powerName = row.createCell(1);
                 powerName.setCellValue(new HSSFRichTextString(bean.getPowerName()));
                 HSSFCell powerCode = row.createCell(2);
                 powerCode.setCellValue(new HSSFRichTextString(bean.getPowerCode()));
                 HSSFCell filName = row.createCell(3);
                 filName.setCellValue(new HSSFRichTextString(bean.getFileName()));
                 HSSFCell deptName = row.createCell(4);
                 deptName.setCellValue(new HSSFRichTextString(bean.getDeptName()));
                 HSSFCell areaName = row.createCell(5);
                 areaName.setCellValue(new HSSFRichTextString(bean.getAreaName()));
                 if(eachRowCellCount == 7){
                     HSSFCell fileUrl = row.createCell(6);
                     fileUrl.setCellValue(new HSSFRichTextString(bean.getFileUrl()));
                 }
            }
        }
        //
        File file = new File(filePath);
        if(file.exists()){
        }else{
            try {
                file.getParentFile().mkdir();
                file.createNewFile();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
            book.write(out);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(out != null){
                try {
                    out.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("文件导出成功："+filePath);
    }
}
