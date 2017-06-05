package com.sis.clms.network.entity.request;

import com.sis.clms.entity.Bean;

/**
 * Created by DELL on 2017/6/5.
 */

public class Header implements Bean {
    private String serviceCode;//服务号
    private String userCode;//用户标识

    public Header(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public Header(String serviceCode, String userCode) {
        this.serviceCode = serviceCode;
        this.userCode = userCode;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
