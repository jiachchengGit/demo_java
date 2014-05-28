/*
 * @(#) SpringMVC ExcelUtil.java Jan 10, 2014
 * 
 * Copyright 2014 CDSF Corporation, Inc. All rights reserved.
 */
package com.jcc.demo.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * <p>Title: ExcelUtil.java</p>
 * <p>Description: </p>
 * <p>Copyright:Copyright(c)2014</p>
 * <p>Company: 成都四方</p>
 * <p>CreateTime:Jan 10, 2014 2:29:42 PM</p>
 * @author chenjiacheng
 * @version 1.0
 **/
public class ExcelUtil<T> {

    /**
     * 根据传递的对象类型，产生Excel文件
     * @author chenjiacheng
     * @creaetime Jan 10, 2014 2:31:47 PM
     * @param model 该对象需要使用RowType注解
     * @param list 导出数据对象列表
     * @param savePath 保存文件的完整路径：../my.xls
     * @throws Exception
     */
    public void createExcel(T model, List<T> list, String savePath) throws Exception {
        Class<?> c = model.getClass();
        Field[] fields = c.getDeclaredFields();
        if ( fields == null || fields.length < 1 ) {
            throw new Exception("Model haved not field!");
        }
        // 获取首行
        String[] rowNames = new String[fields.length];
        for (Field f : fields) {
            if ( f.isAnnotationPresent(RowType.class) ) {
                RowType annotation = f.getAnnotation(RowType.class);
                int index = annotation.index();
                String rowName = annotation.rowName();
                rowNames[index]= rowName;
            }
        }
        rowNames = trimRowNames(rowNames);
        // 最大列数
        int maxRowCount = rowNames.length;

        HSSFWorkbook book = new HSSFWorkbook();
        HSSFSheet sheet = book.createSheet();
        // 获取第一行
        HSSFRow firstRow = sheet.createRow(0);
        // 定义首行列
        HSSFCell[] firstCells = new HSSFCell[maxRowCount];
        // 为首行每个单元格设置数据
        for (int i = 0; i < maxRowCount; i++) {
            firstCells[i] = firstRow.createCell(i);
            firstCells[i].setCellValue(new HSSFRichTextString(rowNames[i]));
        }
        // 数据导入
        if ( list != null && !list.isEmpty() ) {
            // 插入文档内容
            for (int i = 0; i < list.size(); i++) {
                HSSFRow row = sheet.createRow(i + 1);
                T bean = list.get(i);
                Field[] fields1 = bean.getClass().getDeclaredFields();
                for (Field f : fields1) {
                    if ( f.isAnnotationPresent(RowType.class) ) {
                        RowType annotation = f.getAnnotation(RowType.class);
                        int index = annotation.index();
                        String fieldName = f.getName();
                        Method m = bean.getClass().getMethod(getMethodName(fieldName));
                        Object value = m.invoke(bean);
                        HSSFCell cell = row.createCell(index);
                        cell.setCellValue(new HSSFRichTextString(value + ""));
                    }
                }
            }
        }
        // 导出文件
        File file = new File(savePath);
        if ( file.exists() ) {
        }
        else {
            try {
                file.getParentFile().mkdir();
                file.createNewFile();
            }
            catch (IOException e) {
                throw e;
            }
        }
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
            book.write(out);
        }
        catch (FileNotFoundException e) {
           throw e;
        }
        catch (IOException e) {
            throw e;
        }
        finally {
            if ( out != null ) {
                try {
                    out.close();
                }
                catch (IOException e) {
                }
            }
        }
        System.out.println("文件导出成功：" + savePath);
    }

    /**
     * 将过长的数组空值切除
     * @author chenjiacheng
     * @creaetime Jan 10, 2014 3:37:48 PM
     * @param rowNames
     * @return
     */
    private String[] trimRowNames(String[] rowNames) {
        List<String> list = new ArrayList<String>();
        for(String r : rowNames){
            if(r == null || "".equals(r)){
                continue;
            }
            list.add(r);
        }
        String[] str = new String[list.size()];
        list.toArray(str);
        return str;
    }

    /**
     * 获取方法名
     * @author chenjiacheng
     * @creaetime Jan 10, 2014 3:13:21 PM
     * @param fildeName
     * @return
     * @throws Exception
     */
    private String getMethodName(String fildeName) throws Exception {
        byte[] items = fildeName.getBytes();
        items[0] = (byte) ((char) items[0] - 'a' + 'A');
        return "get"+new String(items);
    }
}
