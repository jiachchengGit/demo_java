/*
 * @(#) ResumePowerData PowerFlowChatBean.java Jan 7, 2014
 * 
 * Copyright 2014 CDSF Corporation, Inc. All rights reserved.
 */
package com.jcc.demo.excel;

/**
 * <p>Title: PowerFlowChatBean.java</p>
 * <p>Description: </p>
 * <p>Copyright:Copyright(c)2014</p>
 * <p>Company: 成都四方</p>
 * <p>CreateTime:Jan 7, 2014 8:48:24 AM</p>
 * @author chenjiacheng
 * @version 1.0
 **/
public class PowerFlowChatBean {
    @RowType(index=0,rowName="事项ID")
    private String powerId;
    @RowType(index=1,rowName="事项名称")
    private String powerName;
    @RowType(index=2,rowName="事项编码")
    private String powerCode;
    @RowType(index=3,rowName="事项部门")
    private String deptName;
    @RowType(index=4,rowName="事项地区")
    private String areaName;
    @RowType(index=5,rowName="事项文件名")
    private String fileName;
    @RowType(index=6,rowName="事项文件路径")
    private String fileUrl;

    private String address;
    
    /**
     * get address value
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * set address value
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * get fileUrl value
     * @return the fileUrl
     */
    public String getFileUrl() {
        return fileUrl;
    }

    /**
     * set fileUrl value
     * @param fileUrl the fileUrl to set
     */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    /**
     * get powerId value
     * @return the powerId
     */
    public String getPowerId() {
        return powerId;
    }

    /**
     * set powerId value
     * @param powerId the powerId to set
     */
    public void setPowerId(String powerId) {
        this.powerId = powerId;
    }

    /**
     * get powerName value
     * @return the powerName
     */
    public String getPowerName() {
        return powerName;
    }

    /**
     * set powerName value
     * @param powerName the powerName to set
     */
    public void setPowerName(String powerName) {
        this.powerName = powerName;
    }

    /**
     * get powerCode value
     * @return the powerCode
     */
    public String getPowerCode() {
        return powerCode;
    }

    /**
     * set powerCode value
     * @param powerCode the powerCode to set
     */
    public void setPowerCode(String powerCode) {
        this.powerCode = powerCode;
    }

    /**
     * get deptName value
     * @return the deptName
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * set deptName value
     * @param deptName the deptName to set
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    /**
     * get areaName value
     * @return the areaName
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * set areaName value
     * @param areaName the areaName to set
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * get fileName value
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * set fileName value
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
