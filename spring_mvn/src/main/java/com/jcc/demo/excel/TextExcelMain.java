/*
 * @(#) ResumePowerData TextExcelMain.java Jan 7, 2014
 *
 * Copyright 2014 CDSF Corporation, Inc. All rights reserved.
 */
package com.jcc.demo.excel;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: TextExcelMain.java</p>
 * <p>Description: </p>
 * <p>Copyright:Copyright(c)2014</p>
 * <p>Company: 成都四方</p>
 * <p>CreateTime:Jan 7, 2014 9:25:10 AM</p>
 * @author chenjiacheng
 * @version 1.0
 **/
public class TextExcelMain {

    /**
     * @author chenjiacheng
     * @creaetime Jan 7, 2014 9:25:10 AM
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        String filePath = "D:/demo/power1/excel_output_"+System.currentTimeMillis()+".xls";
        System.out.println("导出文件名："+filePath);
        PowerFlowChatBean bean1 = new PowerFlowChatBean();
        bean1.setPowerId(1+"");
        bean1.setAreaName("地区");
        bean1.setDeptName("部门");
        bean1.setPowerCode("13456-A-999-000");
        bean1.setPowerName("行政处罚");
        List<PowerFlowChatBean> list = new ArrayList<PowerFlowChatBean>();
        for(int i = 0;i<10;i++){
            list.add(bean1);
        }
        //ExcelTools.createExcel(filePath, list);
        ExcelUtil<PowerFlowChatBean> eu = new ExcelUtil<PowerFlowChatBean>();
        eu.createExcel(bean1, list, filePath);
        
    }

}
