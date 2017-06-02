package com.sis.clms.listener;

/**
 * 作者： LYJ
 * 功能： 规范接口
 * 创建日期： 2017/5/4
 */

public interface UIListener {
    void initView();//初始化空间
    void setListener();//在该方法中添加监听事件
    void setFunction();//设置功能
}
